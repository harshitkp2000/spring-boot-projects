package com.example.LibraryManagementSystem.DTO;

import lombok.Data;
import java.util.List;

@Data
public class AuthorResponseDTO {
    private Long authorId;
    private String authorName;
    private List<BookForAuthorAndMemberDTO> books;
}
