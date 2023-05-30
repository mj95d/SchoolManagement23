package com.example.schoolmanagement.Repository;



import com.example.schoolmanagement.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

}
