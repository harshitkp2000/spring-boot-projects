package com.example.LibraryManagementSystem.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "author")
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authorId;
    private String authorName;


    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)

    private List<BookEntity> books;

    public AuthorEntity(){}

    public AuthorEntity(String authorName){
        this.authorName = authorName;
    }

}
