package com.example.Doc.Dog.DTO;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

@Data
public class DogPutDTO {

        private String nome;

        private String origem;

        @Max(2)
        private Integer idade;

}


