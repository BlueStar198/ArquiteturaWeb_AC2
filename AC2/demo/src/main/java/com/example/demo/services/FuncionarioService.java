package com.example.demo.services;

import com.example.demo.dto.FuncionarioDTO;
import com.example.demo.dto.DadosFuncionarioDTO;
import com.example.demo.models.Funcionario;
import com.example.demo.models.Projeto;
import com.example.demo.Repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Adicionar Funcionario
    public void adicionarFuncionario(FuncionarioDTO funcionarioDTO) {
        Funcionario funcionario = new Funcionario(funcionarioDTO.getNome());
        funcionarioRepository.save(funcionario);
    }

    // Buscar projetos vinculados ao funcionário
    public List<DadosFuncionarioDTO> buscarProjetosPorFuncionario(Integer idFuncionario) {
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
            .orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));
        List<Projeto> projetos = funcionario.getProjetos();
        return List.of(new DadosFuncionarioDTO(funcionario.getId(), funcionario.getNome(), projetos));
    }
}
