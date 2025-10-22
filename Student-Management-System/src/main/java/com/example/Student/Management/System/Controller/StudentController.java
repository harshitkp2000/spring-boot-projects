package com.example.Student.Management.System.Controller;

import com.example.Student.Management.System.Entity.StudentEntity;
import com.example.Student.Management.System.Service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.example.Student.Management.System.Repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
    // @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // StudentController(StudentService studentService) {
    // this.studentService = studentService;
    // }

    @GetMapping
    public List<StudentEntity> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/create")
    public StudentEntity createStudent(@RequestBody StudentEntity student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public StudentEntity getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentEntity updateStudentById(@PathVariable long id, @RequestBody StudentEntity student) {
        return studentService.updateStudentById(id, student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable long id) {
        studentService.deleteStudentById(id);
        return "Student deleted";
    }

}
