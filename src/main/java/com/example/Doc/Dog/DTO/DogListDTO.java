package com.example.Doc.Dog.DTO;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DogListDTO {
        private Long id;
        private String nome;
        private String origem;
        private Integer idade;

}


