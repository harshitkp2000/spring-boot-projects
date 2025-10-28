package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.AuthorEntity;
import com.example.LibraryManagementSystem.Entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
}
