package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiResponse.ApiResponse;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.awt.*;
import java.util.List;

@AllArgsConstructor
@Service
public class TeacherService {




        private final TeacherRepository teacherRepository;
        private final TeacherRepository courseRepository;

        public List<Teacher> getAll(){
            return teacherRepository.findAll();
        }

        public void addTeacher(Teacher teacher, Errors errors){
            if(errors.hasErrors())
                throw new ApiResponse(errors.getFieldError().getDefaultMessage());

            teacherRepository.save(teacher);
        }

        public void updateTeacher(int id, Teacher teacher, Errors errors){
            if(errors.hasErrors())
                throw new ApiResponse(errors.getFieldError().getDefaultMessage());

            Teacher findTeacher = teacherRepository.findById(id).
                    orElseThrow(() -> new ApiResponse("id not found"));

            findTeacher.setName(teacher.getName());
            findTeacher.setEmail(teacher.getEmail());
            findTeacher.setAge(teacher.getAge());
            findTeacher.setSalary(teacher.getSalary());
            teacherRepository.save(findTeacher);
        }

        public void deleteTeacher(int id){
            Teacher findTeacher = teacherRepository.findById(id).
                    orElseThrow(() -> new ApiResponse("id not found"));
            teacherRepository.delete(findTeacher);
        }

        public Teacher getByIdTeacher(int teacher_id){
            Teacher teacher = teacherRepository.findById(teacher_id)
                    .orElseThrow(() -> new ApiResponse("id not found"));

            return teacher;
        }

        public String getByCourse(int courseId){
            Cursor course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new ApiResponse("id not found"));

            return course.getClass().getName();
        }


    }