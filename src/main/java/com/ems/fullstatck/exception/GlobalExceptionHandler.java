package com.ems.fullstatck.exception;

import com.ems.fullstatck.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(value = EmployeeAlreadyExistException.class)
    public @ResponseBody ErrorResponse handlerEmployeeAlreadyExistException(EmployeeAlreadyExistException exception){
        return new ErrorResponse(HttpStatus.CONFLICT.value(), exception.getMessage(), LocalDateTime.now().toString());

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = EmployeeNotFoundException.class)
    @ResponseBody ErrorResponse handlerEmployeeNotFoundException(EmployeeNotFoundException exception){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), LocalDateTime.now().toString());
    }
}
