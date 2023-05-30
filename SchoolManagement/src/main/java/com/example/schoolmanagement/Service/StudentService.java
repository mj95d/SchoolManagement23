package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.Repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {




        private final StudentRepository studentRepository;
        private final CourseRepository courseRepository;

        public List<S> getAll(){
            return studentRepository.findAll();
        }

        public void add(Teacher teacher, Errors errors){
            if(errors.hasErrors())
                throw new ExceptionApiResponse(errors.getFieldError().getDefaultMessage());

            teacherRepository.save(teacher);
        }

        public void update(int id, Teacher teacher, Errors errors){
            if(errors.hasErrors())
                throw new ExceptionApiResponse(errors.getFieldError().getDefaultMessage());

            Teacher findTeacher = teacherRepository.findById(id).
                    orElseThrow(() -> new ExceptionApiResponse("id not found"));

            findTeacher.setName(teacher.getName());
            findTeacher.setEmail(teacher.getEmail());
            findTeacher.setAge(teacher.getAge());
            findTeacher.setSalary(teacher.getSalary());
            teacherRepository.save(findTeacher);
        }

        public void delete(int id){
            Teacher findTeacher = teacherRepository.findById(id).
                    orElseThrow(() -> new ExceptionApiResponse("id not found"));
            teacherRepository.delete(findTeacher);
        }

        public Teacher getById(int teacher_id){
            Teacher teacher = teacherRepository.findById(teacher_id)
                    .orElseThrow(() -> new ExceptionApiResponse("id not found"));

            return teacher;
        }

        public String getByCourse(int courseId){
            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new ExceptionApiResponse("id not found"));

            return course.getTeacher().getName();
        }


    }