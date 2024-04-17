package com.library.libraryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.print.Book;

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

}
