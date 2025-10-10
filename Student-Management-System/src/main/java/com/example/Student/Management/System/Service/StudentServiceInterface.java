package com.example.Student.Management.System.Service;

import com.example.Student.Management.System.Entity.StudentEntity;

import java.util.List;

public interface StudentServiceInterface {
List<StudentEntity> getAllStudents();
StudentEntity getStudentById(Long id);
StudentEntity createStudent(StudentEntity student);
StudentEntity updateStudentById(Long id, StudentEntity student);
void deleteStudentById(Long id);
}
