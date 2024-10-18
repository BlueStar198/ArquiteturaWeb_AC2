package com.example.demo.services;

import com.example.demo.dto.ProjetoDTO;
import com.example.demo.dto.DadosProjetoDTO;
import com.example.demo.models.Funcionario;
import com.example.demo.models.Projeto;
import com.example.demo.Repositories.FuncionarioRepository;
import com.example.demo.Repositories.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjetoService {
    
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // Adicionar Projeto
    public void adicionarProjeto(ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto(projetoDTO.getDescricao(), projetoDTO.getDataInicio(), projetoDTO.getDataFim());
        projetoRepository.save(projeto);
    }

    // Buscar Projeto por ID com funcionários vinculados
    public DadosProjetoDTO buscarProjetoPorId(Integer idProjeto) {
        Projeto projeto = projetoRepository.findById(idProjeto)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado."));
        List<Funcionario> funcionarios = projeto.getFuncionarios();
        return new DadosProjetoDTO(projeto.getId(), projeto.getDescricao(), projeto.getDataInicio(), projeto.getDataFim(), funcionarios);
    }

    // Vincular Funcionário ao Projeto
    public void vincularFuncionarioAoProjeto(Integer idProjeto, Integer idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto)
            .orElseThrow(() -> new RuntimeException("Projeto não encontrado."));
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
            .orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));
        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }

    public List<DadosProjetoDTO> buscarProjetosPorDatas(LocalDate dataInicio, LocalDate dataFim) {
    List<Projeto> projetos = projetoRepository.findProjetosBetweenDates(dataInicio, dataFim);
    return projetos.stream()
        .map(projeto -> new DadosProjetoDTO(projeto.getId(), projeto.getDescricao(), projeto.getDataInicio(), projeto.getDataFim(), projeto.getFuncionarios()))
        .toList();
}
}
