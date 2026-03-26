package com.bridgelabz.EmployeePayrollApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeePayrollException.class)
    public ResponseEntity<String> handleEmployeeException(EmployeePayrollException e) {

        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

    }

}