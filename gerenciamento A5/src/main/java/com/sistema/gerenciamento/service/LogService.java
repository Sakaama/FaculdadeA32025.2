package com.sistema.gerenciamento.service;

import com.sistema.gerenciamento.log.LogAtividade;
import com.sistema.gerenciamento.log.LogAtividadeRepository;
import com.sistema.gerenciamento.model.Projeto;
import com.sistema.gerenciamento.model.Tarefa;
import com.sistema.gerenciamento.repository.ProjetoRepository;
import com.sistema.gerenciamento.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogAtividadeRepository logAtividadeRepository;
    
    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private TarefaRepository tarefaRepository;

    public LogAtividade registrarEvento(String evento, String usuario) {
        LogAtividade novoLog = new LogAtividade(evento, usuario);
        return logAtividadeRepository.save(novoLog);
    }

    public List<LogAtividade> buscarTodosOsLogs() {
        return logAtividadeRepository.findAll();
    }
    
    public double calcularPercentualConclusao(Long projetoId) {
        Projeto projeto = projetoRepository.findById(projetoId).orElse(null);

        if (projeto == null) {
            return 0.0;
        }

        List<Tarefa> tarefasDoProjeto = tarefaRepository.findByProjeto(projeto);
        long totalTarefas = tarefasDoProjeto.size();

        if (totalTarefas == 0) {
            return 0.0;
        }

        long tarefasConcluidas = tarefasDoProjeto.stream()
                .filter(tarefa -> "CONCLUIDA".equalsIgnoreCase(tarefa.getStatus()))
                .count();

        return (double) tarefasConcluidas / totalTarefas * 100;
    }
}