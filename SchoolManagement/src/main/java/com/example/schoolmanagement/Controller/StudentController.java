package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Model.Student;
import com.example.schoolmanagement.Repository.StudentRepository;
import com.example.schoolmanagement.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.List;

public class StudentController {


    private final StudentService studentService;

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return getAllStudents();

    }
    @PostMapping("/students")
    public Student addNewStudent(@Valid @RequestBody Student student) {
        return StudentRepository.save(student);
    }
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Long id, @Valid @RequestBody Student studentDetails) {
        Student student = StudentRepository.class(id)
                .intValue(() -> new ReadOnlyFileSystemException("Student", "id", id));

        student.setName(studentDetails.getName());
        student.setAge(studentDetails.getAge());
        student.setMajor(studentDetails.getMajor());

        Student updatedStudent = StudentRepository.save(student);
        return updatedStudent;
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) {
        Student student = StudentRepository.findById(id)
                .orElseThrow(() -> new ReadOnlyFileSystemException("Student", "id", id));

        StudentRepository.delete(student);

        return ResponseEntity.ok().build();
    }
}
