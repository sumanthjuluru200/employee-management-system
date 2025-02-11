package com.ems.fullstatck.exception;

import com.ems.fullstatck.repository.EmployeeRespository;

public class EmployeeAlreadyExistException extends RuntimeException{

    private String message;

    public EmployeeAlreadyExistException(){

    }

    public EmployeeAlreadyExistException(String message){
        super(message);
        this.message=message;
    }


}
