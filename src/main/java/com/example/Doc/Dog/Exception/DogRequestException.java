package com.example.Doc.Dog.Exception;

import lombok.Data;


public class DogRequestException extends RuntimeException {

    public DogRequestException(String message) {
        super(message);
    }

    public DogRequestException(String message, Throwable cause){
        super(message, cause);
    }


}