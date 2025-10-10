package com.example.Student.Management.System.Repository;

import com.example.Student.Management.System.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

}
