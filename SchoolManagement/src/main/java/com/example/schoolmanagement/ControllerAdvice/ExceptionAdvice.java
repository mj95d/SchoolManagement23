package com.example.schoolmanagement.ControllerAdvice;

import com.example.schoolmanagement.ApiException.ApiException;
import com.example.schoolmanagement.ApiResponse.ApiResponse;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ConcurrentModificationException;

@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse> handelExceptionApiResponse(ApiException e){
        ApiResponse error = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiException> MethodArgumentNotValidException(MethodArgumentNotValidException ex){
        ApiException error = new ApiResponse(ex.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(value = ConcurrentModificationException.class)
    public ResponseEntity<ApiException> ConstraintViolationException(ConcurrentModificationException e) {
        ApiException error = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(value = SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ApiException> SQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        ApiException error = new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(value = HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiException> HttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        ApiException error = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(value = InvalidDataAccessResourceUsageException.class )
    public ResponseEntity<ApiException> InvalidDataAccessResourceUsageException(InvalidDataAccessResourceUsageException e){
        ApiException error = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(value = HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<ApiException> HttpMessageNotReadableException(HttpMessageNotReadableException e) {
        ApiException error = new ApiResponse(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}