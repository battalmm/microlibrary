package com.library.bookservice.service;

import com.library.bookservice.dto.BookDto;
import com.library.bookservice.dto.BookIdDto;
import com.library.bookservice.exception.BookNotFoundException;
import com.library.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository repository) {
        this.bookRepository = repository;
    }

    public List<BookDto> getAllBooks(){
        return bookRepository.findAll()
                .stream()
                .map(BookDto::toDto)
                .collect(Collectors.toList());
    }

    public BookIdDto findByIsbn(String isbn){
        return BookIdDto.toDto(bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new BookNotFoundException("Book could not found by isbn: " + isbn)));
    }

    public  BookDto findBookDetailsById(Long id){
        return bookRepository.findById(id)
                .map(BookDto::toDto)
                .orElseThrow(() -> new BookNotFoundException("Book could not find by id: " + id));
    }
}
