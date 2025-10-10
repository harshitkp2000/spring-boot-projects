package com.example.Student.Management.System.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "StudentTable")
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;

    public StudentEntity() {

    }
    public StudentEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }


}
