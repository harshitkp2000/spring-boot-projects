package com.example.Student.Management.System.Service;

import com.example.Student.Management.System.Entity.StudentEntity;
import com.example.Student.Management.System.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceInterface {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public StudentEntity createStudent(StudentEntity student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentEntity getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public StudentEntity updateStudentById(Long id, StudentEntity student) {
        StudentEntity existingStudent = studentRepository.findById(id).orElse(null);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setEmail(student.getEmail());
            return studentRepository.save(existingStudent);
        }
        return null;

    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

}
