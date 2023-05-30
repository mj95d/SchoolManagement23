package com.example.schoolmanagement.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DtoAddressUpdate {



        @NotEmpty(message = "area must be not empty")
        private String area;
        @NotEmpty(message = "street must be not empty")
        private String street;
        @NotNull(message = "Building number must not be null")
        @Min(value = 1, message = "Building number should not be less than 1")
        private Integer buildingNumber;

}
