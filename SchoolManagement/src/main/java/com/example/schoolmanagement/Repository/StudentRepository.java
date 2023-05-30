package com.example.schoolmanagement.Repository;


import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Course, Integer> {

    static Student save(Student student) {
        return student;
    }

    static Optional<Object> findById(Long id) {
        return null;
    }
}