package ee.smit.booksreg.mapper;

import ee.smit.booksreg.dto.BookResponseDto;
import ee.smit.booksreg.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface BookMapper {
    BookResponseDto bookToResponseDto(Book book);
}
