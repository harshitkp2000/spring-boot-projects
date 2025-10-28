package com.example.LibraryManagementSystem.DTO;

import lombok.Data;
import java.util.List;

@Data
public class MemberResponseDTO {
    private Long memberId;
    private String memberName;
    private List<BookForAuthorAndMemberDTO> borrowedBooks;
}
