package com.library.libraryservice.repository;

import com.library.libraryservice.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}
