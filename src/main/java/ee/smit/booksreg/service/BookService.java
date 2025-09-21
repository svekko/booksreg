package ee.smit.booksreg.service;

import ee.smit.booksreg.dto.BookRequestDto;
import ee.smit.booksreg.dto.BookResponseDto;
import ee.smit.booksreg.error.ApiError;
import ee.smit.booksreg.error.BadRequestException;
import ee.smit.booksreg.mapper.BookMapper;
import ee.smit.booksreg.model.Book;
import ee.smit.booksreg.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BookService {
    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public Page<BookResponseDto> getBooks(Pageable pageable) {
        return bookRepository.findAll(pageable).map(bookMapper::bookToResponseDto);
    }

    public BookResponseDto getBook(int id) {
        return bookMapper.bookToResponseDto(bookRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Transactional
    public BookResponseDto addBook(BookRequestDto requestDto) {
        log.warn("Adding new book with title: {}", requestDto.getTitle());

        if (bookRepository.findByTitle(requestDto.getTitle()).isPresent()) {
            throw new BadRequestException(ApiError.BOOK_WITH_TITLE_ALREADY_EXISTS);
        }

        Book book = Book.builder()
            .title(requestDto.getTitle().trim())
            .subtitle(requestDto.getSubtitle().trim())
            .numberOfPages(requestDto.getNumber_of_pages())
            .build();

        book = bookRepository.save(book);
        return bookMapper.bookToResponseDto(book);
    }

    @Transactional
    public BookResponseDto editBook(int id, BookRequestDto requestDto) {
        log.info("Editing book with id: {}", id);
        Book book = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        if (bookRepository.findByTitle(requestDto.getTitle()).filter(b -> b.getId() != id).isPresent()) {
            throw new BadRequestException(ApiError.BOOK_WITH_TITLE_ALREADY_EXISTS);
        }

        book.setTitle(StringUtils.trim(requestDto.getTitle()));
        book.setSubtitle(StringUtils.trim(requestDto.getSubtitle()));
        book.setNumberOfPages(requestDto.getNumber_of_pages());

        book = bookRepository.save(book);
        return bookMapper.bookToResponseDto(book);
    }

    @Transactional
    public void deleteBook(int id) {
        log.info("Deleting book with id: {}", id);

        Book book = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        bookRepository.delete(book);
    }
}
