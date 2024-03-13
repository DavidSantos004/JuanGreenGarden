package com.JuanGreenGarden.Gardening.domain.Exceptions;

public class NotFoundEndPoint extends RuntimeException {
    
    public NotFoundEndPoint(String message){
        super(message);
    }
}
