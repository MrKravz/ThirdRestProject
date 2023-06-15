package com.example.thirdProject.exceptions;

public class MeasurementNotValidException extends RuntimeException{
    public MeasurementNotValidException(String message){
        super(message);
    }
}
