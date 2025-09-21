package ee.smit.booksreg.repository;

import ee.smit.booksreg.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(
        nativeQuery = true,
        value = """
                select *
                FROM book
                where TRIM(UPPER(title)) = trim(upper(:title))
            """
    )
    Optional<Book> findByTitle(String title);

    @Query(
        nativeQuery = true,
        value = """
                select *
                FROM book
                where number_of_pages >= :from
                AND number_of_pages <= :to
            """
    )
    List<Book> findByNumberOfPages(int from, int to);
}
