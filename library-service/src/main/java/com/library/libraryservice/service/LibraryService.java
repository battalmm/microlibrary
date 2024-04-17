package com.library.libraryservice.service;

import com.library.libraryservice.dto.LibraryDto;
import com.library.libraryservice.exception.LibraryNotFoundException;
import com.library.libraryservice.model.Library;
import com.library.libraryservice.repository.LibraryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;

    public LibraryService(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }


    public LibraryDto getAllBooksInLibraryById (Long id){
        Library library = libraryRepository.findById(id)
                .orElseThrow(()-> new LibraryNotFoundException("Libray could not find by id: " + id));

        return createLibraryDtoFromLibrary(library.getUserBook(),id);
    }

    public LibraryDto createLibrary(){
        Library newLibrary = libraryRepository.save( new Library());
        return createLibraryDtoFromLibrary(newLibrary.getUserBook(),newLibrary.getId());
    }

    private LibraryDto createLibraryDtoFromLibrary(List<String> userBooks, Long id){
        List<String> userBookList = userBooks != null ? userBooks : new ArrayList<String>();
        return new LibraryDto(id,userBookList);
    }
}
