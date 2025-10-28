package com.example.LibraryManagementSystem.DTO;

import lombok.Data;
import java.util.List;

@Data
public class BookResponseDTO {
    private Long bookId;
    private String bookName;
    private int stock;
    private String authorName;
    private List<String> memberNames;
}
