package com.example.schoolmanagement.Controller;

import com.example.schoolmanagement.DTO.DtoAddressInsert;
import com.example.schoolmanagement.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @PostMapping("/add")
    public ResponseEntity addaddress(@Valid @RequestBody DtoAddressInsert dto, Error errors){
        addressService.addAddress(dto, errors);
        return ResponseEntity.status(200).body("success");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateaddress(@PathVariable int id, @Valid @RequestBody DtoAddressInsert dto, Error errors){
        addressService.updateAddress(id, dto, (Errors) errors);
        return ResponseEntity.status(200).body("success");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteaddress(@PathVariable int id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body("success");
    }

}