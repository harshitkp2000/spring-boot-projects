package com.example.StudentManagementSystem2.DTO;

import lombok.Data;
import java.util.Set;

@Data
public class StudentDTO {
    private String name;
    private String email;
    private String address;
    private String city;
    private Set<Long> courseId;
}
