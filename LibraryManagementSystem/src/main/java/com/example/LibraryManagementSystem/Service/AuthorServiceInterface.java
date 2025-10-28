package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.DTO.AuthorDTO;
import com.example.LibraryManagementSystem.DTO.AuthorResponseDTO;
import com.example.LibraryManagementSystem.Entity.AuthorEntity;

import java.util.List;

public interface AuthorServiceInterface {
     List<AuthorResponseDTO> getAllAuthors();
    AuthorResponseDTO addAuthor(AuthorDTO authorDTO);

}
