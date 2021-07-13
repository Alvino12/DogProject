package com.example.Doc.Dog;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
public class DogDTO {

        private String nome;
        private String origem;
        private Integer idade;

}


