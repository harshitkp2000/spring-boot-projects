package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.DTO.*;
import com.example.LibraryManagementSystem.Entity.*;
import com.example.LibraryManagementSystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService implements BookServiceInterface {

    @Autowired private BookRepository bookRepository;
    @Autowired private AuthorRepository authorRepository;

    @Override
    public BookResponseDTO addBook(BookDTO bookDTO, Long authorId) {
        AuthorEntity author = authorRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        BookEntity book = new BookEntity();
        book.setBookName(bookDTO.getBookName());
        book.setStock(bookDTO.getStock());
        book.setAuthor(author);

        BookEntity saved = bookRepository.save(book);

        BookResponseDTO response = new BookResponseDTO();
        response.setBookId(saved.getBookId());
        response.setBookName(saved.getBookName());
        response.setStock(saved.getStock());
        response.setAuthorName(saved.getAuthor().getAuthorName());
        return response;
    }

    @Override
    public List<BookResponseDTO> getAllBooks() {
        return bookRepository.findAll().stream().map(book -> {
            BookResponseDTO dto = new BookResponseDTO();
            dto.setBookId(book.getBookId());
            dto.setBookName(book.getBookName());
            dto.setStock(book.getStock());
            dto.setAuthorName(book.getAuthor().getAuthorName());
            dto.setMemberNames(book.getMembers().stream()
                    .map(MemberEntity::getMemberName)
                    .collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }
}
