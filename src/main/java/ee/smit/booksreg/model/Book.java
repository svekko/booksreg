package ee.smit.booksreg.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "book")
public class Book {
    @Id
    @SequenceGenerator(name = "book_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "book_id_seq", strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "number_of_pages", nullable = false)
    private int numberOfPages;
}
