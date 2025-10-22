package com.example.StudentManagementSystem2.Service;

import com.example.StudentManagementSystem2.DTO.CourseStudentCountDTO;
import com.example.StudentManagementSystem2.Entity.CourseEntity;

import java.util.List;

public interface CourseServiceInterface {
    List<CourseEntity> getAllCourses();
    CourseEntity getCourseById(long id);
    CourseEntity addCourse(CourseEntity course);
    CourseEntity updateCourse(long id, CourseEntity course);
    void deleteCourse(long id);
    List<CourseEntity> getCourseWithoutStudent();
    CourseEntity updateCourseInstructor(long id,String courseInstructor);
    public List<CourseStudentCountDTO> getCoursesWithStudentCount();
    public List<CourseStudentCountDTO> getTopCourses(int n);
}
