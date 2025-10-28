package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.DTO.*;
import com.example.LibraryManagementSystem.Entity.*;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService implements AuthorServiceInterface {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public AuthorResponseDTO addAuthor(AuthorDTO authorDTO) {
        AuthorEntity author = new AuthorEntity();
        author.setAuthorName(authorDTO.getAuthorName());

        List<BookEntity> books = authorDTO.getBooks().stream()
                .map(b -> {
                    BookEntity book = new BookEntity();
                    book.setBookName(b.getBookName());
                    book.setStock(b.getStock());
                    book.setAuthor(author);
                    return book;
                }).collect(Collectors.toList());

        author.setBooks(books);

        AuthorEntity saved = authorRepository.save(author);


        AuthorResponseDTO response = new AuthorResponseDTO();
        response.setAuthorId(saved.getAuthorId());
        response.setAuthorName(saved.getAuthorName());
        response.setBooks(saved.getBooks().stream().map(book -> {
            BookForAuthorAndMemberDTO b = new BookForAuthorAndMemberDTO();
            b.setBookId(book.getBookId());
            b.setBookName(book.getBookName());
            b.setStock(book.getStock());
            return b;
        }).collect(Collectors.toList()));

        return response;
    }

    @Override
    public List<AuthorResponseDTO> getAllAuthors() {
        return authorRepository.findAll().stream().map(author -> {
            AuthorResponseDTO dto = new AuthorResponseDTO();
            dto.setAuthorId(author.getAuthorId());
            dto.setAuthorName(author.getAuthorName());
            dto.setBooks(author.getBooks().stream().map(book -> {
                BookForAuthorAndMemberDTO b = new BookForAuthorAndMemberDTO();
                b.setBookId(book.getBookId());
                b.setBookName(book.getBookName());
                b.setStock(book.getStock());
                return b;
            }).collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }
}
