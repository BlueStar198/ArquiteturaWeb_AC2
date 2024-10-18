package com.example.demo.controllers;

import com.example.demo.dto.SetorDTO;
import com.example.demo.dto.DadosSetorDTO;
import com.example.demo.services.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/setores")
public class SetorController {
    
    @Autowired
    private SetorService setorService;

    // Adicionar Setor
    @PostMapping
    public ResponseEntity<Void> adicionar(@RequestBody SetorDTO setorDTO) {
        setorService.adicionarSetor(setorDTO);
        return ResponseEntity.ok().build();
    }

    // Buscar Setor por ID
    @GetMapping("/{id}")
    public ResponseEntity<DadosSetorDTO> buscarSetorPorId(@PathVariable Integer id) {
        DadosSetorDTO setor = setorService.buscarSetorPorId(id);
        return ResponseEntity.ok(setor);
    }

    // Listar todos os setores com funcionários vinculados
    @GetMapping
    public ResponseEntity<List<DadosSetorDTO>> listarSetoresComFuncionarios() {
        List<DadosSetorDTO> setores = setorService.listarSetoresComFuncionarios();
        return ResponseEntity.ok(setores);
    }
}
