package com.example.Doc.Dog;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class DogInsertDTO {
        @NotEmpty
        private String nome;
        @NotEmpty
        private String origem;
        @NotEmpty
        @Max(2)
        private Integer idade;

}


