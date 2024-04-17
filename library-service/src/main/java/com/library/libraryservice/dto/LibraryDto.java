package com.library.libraryservice.dto;

import com.library.libraryservice.model.Library;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LibraryDto {

    private Long id;
    private List<String> userBook;

}
