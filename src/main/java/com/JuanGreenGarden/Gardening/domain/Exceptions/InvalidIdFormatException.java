package com.JuanGreenGarden.Gardening.domain.Exceptions;

public class InvalidIdFormatException extends RuntimeException {
    
    public InvalidIdFormatException(String message){
        super(message);
    }
}
