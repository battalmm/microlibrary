package com.library.libraryservice.service;

import com.library.libraryservice.client.BookServiceClient;
import com.library.libraryservice.dto.AddBookRequest;
import com.library.libraryservice.dto.BookDto;
import com.library.libraryservice.dto.LibraryDto;
import com.library.libraryservice.exception.LibraryNotFoundException;
import com.library.libraryservice.model.Library;
import com.library.libraryservice.repository.LibraryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository,
                          BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    public LibraryDto getAllBooksInLibraryById (Long id){
        Library library = libraryRepository.findById(id)
                .orElseThrow(()-> new LibraryNotFoundException("Libray could not find by id: " + id));

        return createLibraryDtoFromLibrary(library);
    }

    public LibraryDto createLibrary(){
        Library newLibrary = libraryRepository.save( new Library());
        return createLibraryDtoFromLibrary(newLibrary);
    }

    public void addBookToLibrary(AddBookRequest request){
        Long newBookId = bookServiceClient.getBookByIsbn(request.getIsbn()).getBody().getBookId();
        Library library = libraryRepository.findById(request.getLibraryId()).orElseThrow(()-> new LibraryNotFoundException("Libray could not find by id: " + request.getLibraryId()));
        library.getUserBook().add(newBookId);
        libraryRepository.save(library);
    }

    private LibraryDto createLibraryDtoFromLibrary(Library library){
        Long id = library.getId();
        List<Long> userBooksId = library.getUserBook() != null ? library.getUserBook() : new ArrayList<Long>();
        List<BookDto> userBooksList = userBooksId
                .stream()
                .map(bookId -> bookServiceClient.getBookById(bookId).getBody())
                .toList();
        return new LibraryDto(id,userBooksList);
    }
}
