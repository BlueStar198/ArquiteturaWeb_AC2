package com.example.demo.services;

import com.example.demo.dto.SetorDTO;
import com.example.demo.dto.DadosSetorDTO;
import com.example.demo.models.Setor;
import com.example.demo.Repositories.SetorRepository;
import com.example.demo.models.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetorService {
    
    @Autowired
    private SetorRepository setorRepository;

    // Adicionar Setor
    public void adicionarSetor(SetorDTO setorDTO) {
        Setor setor = new Setor(setorDTO.getNome());
        setorRepository.save(setor);
    }

    // Buscar Setor por ID com funcionários vinculados
    public DadosSetorDTO buscarSetorPorId(Integer idSetor) {
        Setor setor = setorRepository.findById(idSetor)
            .orElseThrow(() -> new RuntimeException("Setor não encontrado."));
        List<Funcionario> funcionarios = setor.getFuncionarios();
        return new DadosSetorDTO(setor.getId(), setor.getNome(), funcionarios);
    }

    // Listar todos os setores com funcionários vinculados
    public List<DadosSetorDTO> listarSetoresComFuncionarios() {
        List<Setor> setores = setorRepository.findAll();
        return setores.stream()
            .map(setor -> new DadosSetorDTO(setor.getId(), setor.getNome(), setor.getFuncionarios()))
            .collect(Collectors.toList());
    }
}
