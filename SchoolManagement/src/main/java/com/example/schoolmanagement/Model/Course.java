package com.example.schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


    @Getter
    @Setter
    @Entity
    @NoArgsConstructor
    @AllArgsConstructor

    public class Course {

        @Id
        @GeneratedValue(generator = "id_course_seq", strategy = GenerationType.SEQUENCE)
        private Long id;
        @Column(columnDefinition = "varchar(10) unique")
        @NotBlank(message = "Name is mandatory")
        private String name;
//
//        @ManyToOne
//        @JoinColumn(name = "teacher_id")
//
//
        @ManyToOne
        @JoinColumn(name = "teacher_id", referencedColumnName = "id")
        @JsonIgnore
        private Teacher teacher;



        @JsonIgnore
        @ManyToMany(mappedBy = "courses")
        private List<Student> students ;




}









//
//            @Id
//            @GeneratedValue(strategy = GenerationType.IDENTITY)
//            private Long id;
//
//            @NotBlank
//            private String name;
//
//            @ManyToOne
//            @JoinColumn(name = "teacher_id")
//            private Teacher teacher;
//
//
//
//    }