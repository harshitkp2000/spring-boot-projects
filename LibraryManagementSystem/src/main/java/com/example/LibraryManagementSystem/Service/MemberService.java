package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.DTO.*;
import com.example.LibraryManagementSystem.Entity.*;
import com.example.LibraryManagementSystem.Repository.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MemberService implements MemberServiceInterface {

    @Autowired private MemberRepository memberRepository;
    @Autowired private BookRepository bookRepository;

    @Override
    public MemberResponseDTO addMember(MemberDTO memberDTO) {
        MemberEntity member = new MemberEntity();
        member.setMemberName(memberDTO.getMemberName());

        Set<BookEntity> borrowedBooks = new HashSet<>();
        if (memberDTO.getBorrowedBookIds() != null) {
            for (Long id : memberDTO.getBorrowedBookIds()) {
                BookEntity book = bookRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Book not found"));
                borrowedBooks.add(book);
            }
        }

        member.setBorrowedBooks(borrowedBooks);
        MemberEntity saved = memberRepository.save(member);

        MemberResponseDTO dto = new MemberResponseDTO();
        dto.setMemberId(saved.getMemberId());
        dto.setMemberName(saved.getMemberName());
        dto.setBorrowedBooks(saved.getBorrowedBooks().stream().map(book -> {
            BookForAuthorAndMemberDTO b = new BookForAuthorAndMemberDTO();
            b.setBookId(book.getBookId());
            b.setBookName(book.getBookName());
            b.setStock(book.getStock());
            return b;
        }).collect(Collectors.toList()));
        return dto;
    }

    @Override
    @Transactional
    public MemberResponseDTO borrowBook(Long memberId, Long bookId) {
        MemberEntity member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        BookEntity book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getStock() <= 0) {
            throw new RuntimeException("Book out of stock");
        }


        if (!member.getBorrowedBooks().contains(book)) {
            member.getBorrowedBooks().add(book);
            book.getMembers().add(member);
            book.setStock(book.getStock() - 1);
        }

        memberRepository.save(member);
        bookRepository.save(book);


        MemberResponseDTO dto = new MemberResponseDTO();
        dto.setMemberId(member.getMemberId());
        dto.setMemberName(member.getMemberName());
        dto.setBorrowedBooks(member.getBorrowedBooks().stream().map(b -> {
            BookForAuthorAndMemberDTO x = new BookForAuthorAndMemberDTO();
            x.setBookId(b.getBookId());
            x.setBookName(b.getBookName());
            x.setStock(b.getStock());
            return x;
        }).collect(Collectors.toList()));

        return dto;
    }


    @Override
    public List<MemberResponseDTO> getAllMembers() {
        return memberRepository.findAll().stream().map(member -> {
            MemberResponseDTO dto = new MemberResponseDTO();
            dto.setMemberId(member.getMemberId());
            dto.setMemberName(member.getMemberName());
            dto.setBorrowedBooks(member.getBorrowedBooks().stream().map(book -> {
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
