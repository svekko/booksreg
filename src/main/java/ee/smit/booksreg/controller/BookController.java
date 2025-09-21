package ee.smit.booksreg.controller;

import ee.smit.booksreg.dto.BookRequestDto;
import ee.smit.booksreg.dto.BookResponseDto;
import ee.smit.booksreg.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public Page<BookResponseDto> getBooks(Pageable pageable) {
        return bookService.getBooks(pageable);
    }

    @GetMapping("/{id}")
    public BookResponseDto getBook(@PathVariable int id) {
        return bookService.getBook(id);
    }

    @PostMapping
    public BookResponseDto addBook(@Valid @RequestBody BookRequestDto dto) {
        return bookService.addBook(dto);
    }

    @PutMapping("/{id}")
    public BookResponseDto editBook(@PathVariable int id, @Valid @RequestBody BookRequestDto dto) {
        return bookService.editBook(id, dto);
    }

    @PutMapping("/{id}/delete-book")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}
