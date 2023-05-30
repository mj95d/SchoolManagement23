package com.example.schoolmanagement.Service;

import com.example.schoolmanagement.ApiResponse.ApiResponse;
import com.example.schoolmanagement.DTO.DtoAddressInsert;
import com.example.schoolmanagement.Model.Address;
import com.example.schoolmanagement.Model.Teacher;
import com.example.schoolmanagement.Repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

@RequiredArgsConstructor

@Service

public class AddressService {

    private final AddressRepository addressRepository;
    private final AddressRepository teacherRepository;
    public void addAddress(DtoAddressInsert dto, Error errors){

        if(errors.hasErrors())
            throw new ApiResponse(errors.getFieldError().getDefaultMessage());

        Teacher findTeacher = teacherRepository.findById(dto.getTeacher_id()).orElseThrow(() -> new ApiResponse("id not found"));

        Address address = new Address(findTeacher.getId(), dto.getArea(), dto.getStreet(), dto.getBuildingNumber(), findTeacher);

        addressRepository.save(address);
    }

    public void updateAddress(int id, DtoAddressInsert dto, Errors errors){
        if(errors.hasErrors())
            throw new ApiResponse(errors.getFieldError().getDefaultMessage());

        Address address = addressRepository.findById(id).
                orElseThrow(() -> new ApiResponse("id not found"));

        address.setArea(dto.getArea());
        address.setStreet(dto.getStreet());
        address.setBuildingNumber(dto.getBuildingNumber());
        addressRepository.save(address);
    }

    public void deleteAddress(int id){
        Address address = addressRepository.findById(id).
                orElseThrow(() -> new ApiResponse("id not found"));
        addressRepository.delete(address);
    }
}