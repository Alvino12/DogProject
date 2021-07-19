package com.example.Doc.Dog.Exception;


public class DogNotFound extends RuntimeException{

    public DogNotFound(String message) {

        super(message);
    }

    public DogNotFound() {

    }

}
