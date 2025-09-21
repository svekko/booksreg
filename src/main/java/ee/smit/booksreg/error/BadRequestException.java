package ee.smit.booksreg.error;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {
    private final ApiError error;

    public BadRequestException(ApiError error) {
        super(error.getValue());
        this.error = error;
    }
}
