package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.DTO.*;
import com.example.LibraryManagementSystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired private BookService bookService;

    @PostMapping("/create/{authorId}")
    public ResponseEntity<BookResponseDTO> createBook(@PathVariable Long authorId, @RequestBody BookDTO bookDTO) {
        return ResponseEntity.ok(bookService.addBook(bookDTO, authorId));
    }

    @GetMapping
    public List<BookResponseDTO> getAllBooks() {
        return bookService.getAllBooks();
    }
}
