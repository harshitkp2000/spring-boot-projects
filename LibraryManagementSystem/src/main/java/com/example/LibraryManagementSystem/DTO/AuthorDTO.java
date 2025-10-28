package com.example.LibraryManagementSystem.DTO;

import com.example.LibraryManagementSystem.Entity.BookEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDTO {

    private String authorName;
    private List<BookDTO> books;
}
