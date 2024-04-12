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
public class BookDto {

    private BookIdDto id;
    private String title;
    private String author;
    private Integer bookYear;
    private String pressName;

    public static BookDto toDto(Book book){
        return new BookDto(
               BookIdDto.toDto(book),
               book.getTitle(),
               book.getAuthor(),
               book.getBookYear(),
               book.getPressName()
        );
    }

}
