package com.example.demo.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrorResponse handleEntityNotFoundException(EntityNotFoundException exception) {
        return new ApiErrorResponse(ErrorCode.NOT_FOUND, exception.getMessage());
    }

    /*@ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ApiErrorResponse handleRuntime(RuntimeException exception) {
        return new ApiErrorResponse(ErrorCode.CONFLICT, " Sorry i am Runtime Exception");
    }*/

}
