package TrabalhoFaculdade.A3.service;

import TrabalhoFaculdade.A3.model.StatusTarefa;
import TrabalhoFaculdade.A3.model.Tarefa;
import TrabalhoFaculdade.A3.repository.TarefaRepository;
import jakarta.persistence.EntityNotFoundException; // Import novo e importante
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    // --- MÉTODOS QUE JÁ FUNCIONAVAM ---
    public List<Tarefa> buscarTarefasPorProjeto(Long projetoId) {
        return tarefaRepository.findByProjetoId(projetoId);
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        tarefa.setStatus(StatusTarefa.A_FAZER);
        tarefa.setDataCriacao(LocalDate.now());
        return tarefaRepository.save(tarefa);
    }

    // --- MÉTODO NOVO QUE ESTAMOS ADICIONANDO ---
    public Tarefa atualizarStatusTarefa(Long tarefaId, StatusTarefa novoStatus) {
        // 1. Busca a tarefa no banco de dados. Se não encontrar, lança um erro.
        Tarefa tarefaExistente = tarefaRepository.findById(tarefaId)
                .orElseThrow(() -> new EntityNotFoundException("Tarefa não encontrada com o id: " + tarefaId));

        // 2. Atualiza o status da tarefa que encontramos.
        tarefaExistente.setStatus(novoStatus);

        // 3. Salva a tarefa atualizada de volta no banco.
        return tarefaRepository.save(tarefaExistente);
    }


    // --- MÉTODO QUE AINDA VAMOS IMPLEMENTAR ---
    public List<Tarefa> buscarTarefasPorFuncionario(Long funcionarioId) {
    // A lógica é simplesmente chamar o método que já definimos na interface TarefaRepository.
    // O Spring Data JPA cuida de toda a complexidade para nós.
    return tarefaRepository.findByFuncionarioId(funcionarioId);
}
}