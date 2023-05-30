package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {
    private final TeacherService teacherservice;

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        List<Teacher> teacherList = teacherservice.getAll();
        return ResponseEntity.status(200).body(teacherList);
    }


    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher, Errors errors){
        teacherservice.addTeacher(teacher, errors);
        return ResponseEntity.status(200).body("teacher added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @Valid @RequestBody Teacher teacher, Errors errors){
        teacherservice.updateTeacher(id, teacher, errors);
        return ResponseEntity.status(200).body("teacher updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherservice.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted");

    }

    @GetMapping("/getById/Teacher/{id}")
    public ResponseEntity getByIdTeacher(@PathVariable int id){
        Teacher teacher = teacherservice.getByIdTeacher(id);
        return ResponseEntity.status(200).body(teacher);
    }

    @GetMapping("/getByCourse/Teacher/{id}")
    public ResponseEntity getByCourse(@PathVariable int id){
        Teacher teacherName = teacherservice.getByIdTeacher(id);
        return ResponseEntity.status(200).body(teacherName);
    }
}
