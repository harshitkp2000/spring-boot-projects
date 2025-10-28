package com.example.LibraryManagementSystem.Controller;

import com.example.LibraryManagementSystem.DTO.*;
import com.example.LibraryManagementSystem.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    @Autowired private MemberService memberService;

    @PostMapping("/create")
    public ResponseEntity<MemberResponseDTO> createMember(@RequestBody MemberDTO memberDTO) {
        return ResponseEntity.ok(memberService.addMember(memberDTO));
    }

    @PostMapping("/{memberId}/borrow/{bookId}")
    public ResponseEntity<MemberResponseDTO> borrowBook(@PathVariable Long memberId, @PathVariable Long bookId) {
        return ResponseEntity.ok(memberService.borrowBook(memberId, bookId));
    }

    @GetMapping
    public List<MemberResponseDTO> getAllMembers() {
        return memberService.getAllMembers();
    }
}
