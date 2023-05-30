package com.example.schoolmanagement.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DtoAddressInsert {


        @NotEmpty(message = "teacher_id must be not null")
        private Integer teacher_id;
        @NotEmpty(message = "area must be not empty")
        private String area;
        @NotEmpty(message = "street must be not empty")
        private String street;
        @NotNull(message = "buildingNumber must be not null")
        private Integer buildingNumber;

}
