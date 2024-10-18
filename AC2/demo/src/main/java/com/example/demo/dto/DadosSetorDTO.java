package com.example.demo.dto;

import com.example.demo.models.Funcionario;

import java.util.List;

public class DadosSetorDTO {
    private Integer id;
    private String nome;
    private List<Funcionario> funcionarios;

    public DadosSetorDTO() {
    }

    public DadosSetorDTO(Integer id, String nome, List<Funcionario> funcionarios) {
        this.id = id;
        this.nome = nome;
        this.funcionarios = funcionarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
