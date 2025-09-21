package ee.smit.booksreg.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BookRequestDto {
    @NotBlank
    private String title;

    private String subtitle;

    @Min(1)
    @Max(Integer.MAX_VALUE)
    private int number_of_pages;
}
