package com.example.LibraryManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String memberName;
    private Set<Long> borrowedBookIds;
}
