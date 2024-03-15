package com.JuanGreenGarden.Gardening.domain.Exceptions;

public class DifferentDataTypeException extends RuntimeException {
    
    public DifferentDataTypeException(String message){
        super(message);
    }
}
