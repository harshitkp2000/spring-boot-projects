package com.example.LibraryManagementSystem.DTO;

import lombok.Data;

@Data
public class BookForAuthorAndMemberDTO {
    private Long bookId;
    private String bookName;
    private int stock;
}
