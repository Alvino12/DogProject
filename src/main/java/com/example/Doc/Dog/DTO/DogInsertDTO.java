package com.example.Doc.Dog.DTO;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class DogInsertDTO {
        @NotNull
        @NotEmpty
        private String nome;
        @NotNull
        private String origem;
        @NotNull

        private Integer idade;

        public DogInsertDTO() {
        }

        public DogInsertDTO(String nome, String origem, Integer idade) {
                this.nome = nome;
                this.origem = origem;
                this.idade = idade;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getOrigem() {
                return origem;
        }

        public void setOrigem(String origem) {
                this.origem = origem;
        }

        public Integer getIdade() {
                return idade;
        }

        public void setIdade(Integer idade) {
                this.idade = idade;
        }
}


