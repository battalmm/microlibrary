package com.library.bookservice.dto;

import com.library.bookservice.model.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookIdDto {

    private Long bookId;
    private String isbn;

    public static BookIdDto toDto(Book book){
        return new BookIdDto(book.getId(), book.getIsbn());
    }

}
