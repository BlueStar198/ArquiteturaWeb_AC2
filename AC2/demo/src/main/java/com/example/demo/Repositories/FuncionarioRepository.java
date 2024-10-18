package com.example.demo.Repositories;

import com.example.demo.models.Funcionario;
import com.example.demo.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

    @Query("select f.projetos from Funcionario f where f.id = :id")
    List<Projeto> findProjetosByFuncionarioId(@Param("id") Integer id);
}