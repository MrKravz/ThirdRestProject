package com.example.thirdProject.exceptions;

public class SensorNotValidException extends RuntimeException{
    public SensorNotValidException(String message){
        super(message);
    }
}
