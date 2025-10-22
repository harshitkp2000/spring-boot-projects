package com.example.StudentManagementSystem2.Repository;

import com.example.StudentManagementSystem2.DTO.CourseStudentCountDTO;
import com.example.StudentManagementSystem2.Entity.CourseEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.util.List;

public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
    @Query("SELECT c FROM CourseEntity c LEFT JOIN c.students s WHERE s IS NULL")
    List<CourseEntity> getCourseWithoutStudent();

    @Modifying
    @Transactional
    @Query("UPDATE CourseEntity c SET c.courseInstructor = :courseInstructor WHERE c.courseId = :courseId")
    int updateCourseInstructor(@Param("courseId") Long courseId,
                               @Param("courseInstructor") String courseInstructor);


        @Query("SELECT new com.example.StudentManagementSystem2.DTO.CourseStudentCountDTO(" +
                "c.courseId, c.courseName, c.courseInstructor, COUNT(s)) " +
                "FROM CourseEntity c " +
                "LEFT JOIN c.students s " +
                "GROUP BY c.courseId, c.courseName, c.courseInstructor")
        List<CourseStudentCountDTO> findAllCoursesWithStudentCount();



        @Query("SELECT new com.example.StudentManagementSystem2.DTO.CourseStudentCountDTO(" +
                "c.courseId, c.courseName, c.courseInstructor, COUNT(s)) " +
                "FROM CourseEntity c " +
                "LEFT JOIN c.students s " +
                "GROUP BY c.courseId, c.courseName, c.courseInstructor " +
                "ORDER BY COUNT(s) DESC")
        List<CourseStudentCountDTO> findTopCourses();


}
