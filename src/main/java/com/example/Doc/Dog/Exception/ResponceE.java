package com.example.Doc.Dog.Exception;

import lombok.Data;
import org.springframework.validation.ObjectError;

import java.util.List;

@Data
public class ResponceE {

    String codigo;
    String mensagem;
    List<ObjectError> errors;

}
