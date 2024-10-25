package com.example.demo.controllers;

import com.example.demo.dto.ProjetoDTO;
import com.example.demo.dto.DadosProjetoDTO;
import com.example.demo.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/projetos")
public class ProjetoController {
    
    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody ProjetoDTO projetoDTO) {
        projetoService.adicionarProjeto(projetoDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosProjetoDTO> buscarProjetoPorId(@PathVariable Integer id) {
        DadosProjetoDTO projeto = projetoService.buscarProjetoPorId(id);
        return ResponseEntity.ok(projeto);
    }

    @PostMapping("/{idProjeto}/vincular/{idFuncionario}")
    public ResponseEntity<Void> vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionarioAoProjeto(idProjeto, idFuncionario);
        return ResponseEntity.ok().build();
    }
}
