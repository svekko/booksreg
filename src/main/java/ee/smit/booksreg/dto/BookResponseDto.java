package ee.smit.booksreg.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookResponseDto {
    private int id;

    private String title;

    private String subtitle;

    private int numberOfPages;

    //
    // To be implemented...
    // private LocalDate releaseDate;
}
