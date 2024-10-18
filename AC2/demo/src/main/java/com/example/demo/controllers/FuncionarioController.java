package com.example.demo.controllers;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.dto.DadosFuncionarioDTO;
import com.example.demo.services.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService funcionarioService;

    // Adicionar Funcionário
    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody FuncionarioDTO funcionarioDTO) {
        funcionarioService.adicionarFuncionario(funcionarioDTO);
        return ResponseEntity.ok().build();
    }

    // Buscar projetos vinculados ao Funcionário
    @GetMapping("/{id}/projetos")
    public ResponseEntity<List<DadosFuncionarioDTO>> buscarProjetos(@PathVariable Integer id) {
        List<DadosFuncionarioDTO> projetos = funcionarioService.buscarProjetosPorFuncionario(id);
        return ResponseEntity.ok(projetos);
    }
}
