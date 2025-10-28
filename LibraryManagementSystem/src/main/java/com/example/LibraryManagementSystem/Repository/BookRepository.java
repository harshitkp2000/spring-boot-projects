package com.example.LibraryManagementSystem.Repository;

import com.example.LibraryManagementSystem.Entity.AuthorEntity;
import com.example.LibraryManagementSystem.Entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity,Long> {
}
