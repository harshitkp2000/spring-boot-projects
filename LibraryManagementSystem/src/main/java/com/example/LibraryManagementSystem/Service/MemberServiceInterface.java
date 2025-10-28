package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.DTO.MemberDTO;
import com.example.LibraryManagementSystem.DTO.MemberResponseDTO;
import com.example.LibraryManagementSystem.Entity.MemberEntity;

import java.util.List;

public interface MemberServiceInterface {
    MemberResponseDTO addMember(MemberDTO memberDTO);
    MemberResponseDTO borrowBook(Long memberId, Long bookId);
    List<MemberResponseDTO> getAllMembers();
}
