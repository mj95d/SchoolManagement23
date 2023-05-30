package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/getAll")
    public ResponseEntity getAll(){
        List<Course> courseList = courseService.getAll();
        return ResponseEntity.status(200).body(courseList);
    }


    @PostMapping("/add")
    public ResponseEntity addCourse(@Valid @RequestBody Course course, Error errors){
        courseService.addCourse(course, (Errors) errors);
        return ResponseEntity.status(200).body("course added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCourse(@PathVariable Integer id, @Valid @RequestBody Course course, Error errors){
        courseService.updateCourse(id, course, errors);
        return ResponseEntity.status(200).body("course Updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCourse(@PathVariable Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(200).body("course deleted");
    }

    @PutMapping("/teacher/course/{teacher_id}/{course_id}")
    public ResponseEntity assignCourseToTeacher(@PathVariable int teacher_id, @PathVariable int course_id){
        courseService.assignCourseToTeacher(course_id, teacher_id);
        return ResponseEntity.status(200).body("assign course to teacher success");
    }
}


