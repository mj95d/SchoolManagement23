package com.example.schoolmanagement.ApiException;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

    public class ApiException extends RuntimeException {

        private final HttpStatus httpStatus;
        private final String message;
        private final ZonedDateTime timestamp;

        public ApiException(HttpStatus httpStatus, String message, ZonedDateTime timestamp) {
            super(message);
            this.httpStatus = httpStatus;
            this.message = message;
            this.timestamp = timestamp;
        }
    }
