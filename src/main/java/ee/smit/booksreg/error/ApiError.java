package ee.smit.booksreg.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApiError {
    BOOK_WITH_TITLE_ALREADY_EXISTS("BOOK_WITH_TITLE_ALREADY_EXISTS");

    private final String value;
}
