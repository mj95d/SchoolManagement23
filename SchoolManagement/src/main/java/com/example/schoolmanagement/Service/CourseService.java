package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiResponse.ApiResponse;
import com.example.schoolmanagement.Model.Course;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.CourseRepository;
import com.example.schoolmanagement.Repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;


    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public void addCourse(Course course, Errors errors) {
        if (errors.hasErrors())
            throw new ApiResponse(errors.getFieldError().getDefaultMessage());

        courseRepository.save(course);
    }

    public void updateCourse(int id, Course course, Error errors) {
        if (errors.hasErrors())
            throw new ApiResponse(errors.getFieldError().getDefaultMessage());

        Course findCourse = courseRepository.findById(id).
                orElseThrow(() -> new ApiResponse("not found"));

        findCourse.setName(course.getName());
        courseRepository.save(findCourse);
    }



    public void deleteCourse(int id) {
        Course findCourse = courseRepository.findById(id).
                orElseThrow(() -> new ApiResponse("id not found"));
        courseRepository.delete(findCourse);
    }



    public void assignCourseToTeacher(int course_id, int teacher_id) {
        Course findCourse = courseRepository.findById(course_id).
                orElseThrow(() -> new ApiResponse(" id is not found"));

        Teacher findTeacher = teacherRepository.findById(teacher_id).
                orElseThrow(() -> new ApiResponse(" id is not found"));

        findCourse.setTeacher(findTeacher);

        courseRepository.save(findCourse);

    }
}
