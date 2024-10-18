package com.example.demo.Repositories;

import com.example.demo.models.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Integer> {

    @Query("select p from Projeto p left join fetch p.funcionarios where p.id = :id")
    Projeto findProjetoWithFuncionariosById(@Param("id") Integer id);

    @Query("SELECT p FROM Projeto p WHERE p.dataInicio BETWEEN :dataInicio AND :dataFim")
    List<Projeto> findProjetosBetweenDates(@Param("dataInicio") LocalDate dataInicio, @Param("dataFim") LocalDate dataFim);
}