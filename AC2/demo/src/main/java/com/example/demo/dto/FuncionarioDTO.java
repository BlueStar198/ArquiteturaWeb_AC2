package com.example.demo.dto;

public class FuncionarioDTO {
    private String nome;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
