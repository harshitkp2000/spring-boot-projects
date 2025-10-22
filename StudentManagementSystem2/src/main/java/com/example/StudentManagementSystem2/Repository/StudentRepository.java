package com.example.StudentManagementSystem2.Repository;

import com.example.StudentManagementSystem2.DTO.CountStudentDTO;
import com.example.StudentManagementSystem2.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    @Query("select s from StudentEntity s JOIN s.courses c where c.courseName = :courseName")
    public List<StudentEntity> findByCourseName(@Param("courseName") String courseName);

    @Query("SELECT c.courseId, c.courseName, COUNT(s.studentId) " +
            "FROM StudentEntity s " +
            "JOIN s.courses c " +
            "GROUP BY c.courseId")
    List<CountStudentDTO> getStudentCountPerCourse();

    @Query("select s from StudentEntity s JOIN s.courses c where c.courseInstructor = :courseInstructor AND s.city =:city")
    List<StudentEntity> getStudentByCity(@Param("city") String city, @Param("courseInstructor") String courseInstructor);

    @Query("SELECT s FROM StudentEntity s LEFT JOIN s.courses c WHERE c IS NULL")
    List<StudentEntity> getStudentWithoutCourse();
}
