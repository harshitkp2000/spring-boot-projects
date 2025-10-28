package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorEntity,Long> {
}
