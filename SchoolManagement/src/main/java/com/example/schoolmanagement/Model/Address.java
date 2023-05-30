package com.example.schoolmanagement.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {



    @Id

    @GeneratedValue(generator = "teacher_id", strategy = GenerationType.SEQUENCE)

    @SequenceGenerator(name = "id", sequenceName = "teacher_id", initialValue = 1, allocationSize = 1)

    private Integer id;

    @NotBlank(message = "Area is mandatory")
    private String area;

    @NotBlank(message = "Street is mandatory")
    private String street;

    @NotBlank(message = "Building number is mandatory")
    private String buildingNumber;
    @OneToOne(mappedBy = "address")
    @MapsId
    @JsonIgnore
    private Teacher teacher;

}

