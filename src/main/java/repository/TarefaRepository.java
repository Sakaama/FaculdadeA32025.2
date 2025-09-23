package TrabalhoFaculdade.A3.repository;

import TrabalhoFaculdade.A3.model.Tarefa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {

    // O Spring Data JPA cria a busca no banco de dados automaticamente
    // apenas pelo nome do método.
    List<Tarefa> findByProjetoId(Long projetoId);

    List<Tarefa> findByFuncionarioId(Long funcionarioId);
}