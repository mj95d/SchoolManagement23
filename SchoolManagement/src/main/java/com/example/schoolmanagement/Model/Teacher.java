package com.example.schoolmanagement.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


    public class Teacher {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(columnDefinition = "string")
        @NotBlank
        private String name;
        @Column(columnDefinition = "int")
        @Positive
        private int age;

        @Column(columnDefinition = "varchar(10) unique")
        @Email
        private String email;


        @Positive
        @Column(columnDefinition = "int")
        private Integer salary;
        @OneToOne(cascade = CascadeType.ALL, mappedBy = "teacher")
        @PrimaryKeyJoinColumn
        private Address address;


        @PrimaryKeyJoinColumn
        @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
        private List<Course> courses ;






}



