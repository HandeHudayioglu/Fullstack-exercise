package com.handehdy.fullstackexercise.exceptions;

public class CitizenNotFoundException extends RuntimeException {

    public CitizenNotFoundException(){
        super();
    }

    public CitizenNotFoundException(String message){
        super(message);
    }
}
