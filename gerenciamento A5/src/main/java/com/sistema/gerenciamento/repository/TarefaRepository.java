package com.sistema.gerenciamento.repository;

import com.sistema.gerenciamento.model.Projeto;
import com.sistema.gerenciamento.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    List<Tarefa> findByProjeto(Projeto projeto);
}