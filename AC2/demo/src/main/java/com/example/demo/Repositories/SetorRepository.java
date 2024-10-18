package com.example.demo.Repositories;

import com.example.demo.models.Setor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Integer> {

    @Query("SELECT s FROM Setor s JOIN FETCH s.funcionarios")
    List<Setor> findAllSetoresComFuncionarios();
}