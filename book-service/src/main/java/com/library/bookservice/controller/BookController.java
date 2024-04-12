package com.library.bookservice.controller;

import com.library.bookservice.dto.BookDto;
import com.library.bookservice.dto.BookIdDto;
import com.library.bookservice.service.BookService;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/v1/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService service) {
        this.bookService = service;
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<BookIdDto> getBookByIsbn(@PathVariable @NotEmpty String isbn){
        return ResponseEntity.ok(bookService.findByIsbn(isbn));
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable @NotEmpty Long id){
        return ResponseEntity.ok(bookService.findBookDetailsById(id));
    }

}
