package ee.smit.booksreg.error;

import ee.smit.booksreg.dto.ApiErrorResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class ApiExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiErrorResponseDto> handleBadRequest(BadRequestException exception) {
        log.warn("Not found error: {}", exception.getError().getValue());
        ApiErrorResponseDto dto = ApiErrorResponseDto.builder().error(exception.getError().getValue()).build();
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
