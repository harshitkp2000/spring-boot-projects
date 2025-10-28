package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.DTO.BookDTO;
import com.example.LibraryManagementSystem.DTO.BookResponseDTO;
import com.example.LibraryManagementSystem.Entity.AuthorEntity;
import com.example.LibraryManagementSystem.Entity.BookEntity;

import java.util.List;

public interface BookServiceInterface {
    BookResponseDTO addBook(BookDTO bookDTO, Long authorId);
    List<BookResponseDTO> getAllBooks();
}
