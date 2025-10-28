package com.example.LibraryManagementSystem.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "book")
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long bookId;
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "author_id")
    @JsonIgnore
    private AuthorEntity author;
    private int stock;

    @ManyToMany(mappedBy = "borrowedBooks")
        @JsonIgnore
    private Set<MemberEntity> members;

    public BookEntity() {}
}
