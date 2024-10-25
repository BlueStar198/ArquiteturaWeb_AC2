package com.example.demo.services;

import com.example.demo.dto.SetorDTO;
import com.example.demo.dto.DadosSetorDTO;
import com.example.demo.models.Setor;
import com.example.demo.Repositories.FuncionarioRepository;
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


    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void adicionarSetor(SetorDTO setorDTO) {
        Setor setor = new Setor(setorDTO.getNome());
        setorRepository.save(setor);
    }

    public DadosSetorDTO buscarSetorPorId(Integer idSetor) {
        Setor setor = setorRepository.findAllSetoresComFuncionarios(idSetor);
        List<Funcionario> funcionarios = setor.getFuncionarios();
        return new DadosSetorDTO(setor.getId(), setor.getNome(), funcionarios);
    }

    public List<DadosSetorDTO> listarSetoresComFuncionarios() {
        List<Setor> setores = setorRepository.findAll();
        return setores.stream()
            .map(setor -> new DadosSetorDTO(setor.getId(), setor.getNome(), setor.getFuncionarios()))
            .collect(Collectors.toList());
    }

    public void vincularFuncionariosAoSetor(Integer idSetor, List<Integer> funcionariosIds) {
        Setor setor = setorRepository.findById(idSetor)
            .orElseThrow(() -> new RuntimeException("Setor não encontrado."));
        
        List<Funcionario> funcionarios = funcionarioRepository.findAllById(funcionariosIds);
        for (Funcionario funcionario : funcionarios) {
            funcionario.setSetor(setor);
            funcionarioRepository.save(funcionario);
        }
        //setor.getFuncionarios().addAll(funcionarios);
        //setor.setFuncionarios(funcionarios);
        //setorRepository.save(setor);
    }
}
