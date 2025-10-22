package com.example.StudentManagementSystem2.Controller;

import com.example.StudentManagementSystem2.DTO.CourseStudentCountDTO;
import com.example.StudentManagementSystem2.Entity.CourseEntity;
import com.example.StudentManagementSystem2.Entity.StudentEntity;
import com.example.StudentManagementSystem2.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<CourseEntity> getCourses(){
        return courseService.getAllCourses();
    }
    @PostMapping("/create")
    public CourseEntity createStudent(@RequestBody CourseEntity student) {
        System.out.println(student.toString());
        return courseService.addCourse(student);
    }
    @GetMapping("/{id}")
    public CourseEntity getStudentById(@PathVariable long id) {
        return courseService.getCourseById(id);
    }
    @PutMapping("/update/{id}")
    public CourseEntity updateStudent(@PathVariable long id, @RequestBody CourseEntity course) {
        return courseService.updateCourse(id, course);
    }
    @GetMapping("/delete/{id}")
    public void deleteStudent(@PathVariable int id) {
        courseService.deleteCourse(id);
    }

    @GetMapping("/withoutStudent")
    public List<CourseEntity> getCourseWithoutStudent(){
        return courseService.getCourseWithoutStudent();
    }

    @PutMapping("/{courseId}/updateInstructor")
    public ResponseEntity<CourseEntity> updateInstructor(@PathVariable Long courseId, @RequestParam String courseInstructor) {

        return ResponseEntity.ok(courseService.updateCourseInstructor(courseId, courseInstructor));
    }

    @GetMapping("/withStudentCount")
    public ResponseEntity<List<CourseStudentCountDTO>> getCoursesWithStudentCount() {
        List<CourseStudentCountDTO> courses = courseService.getCoursesWithStudentCount();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/top")
    public ResponseEntity<List<CourseStudentCountDTO>> getTopCourses(@RequestParam int n) {
        return ResponseEntity.ok(courseService.getTopCourses(n));
    }

}
