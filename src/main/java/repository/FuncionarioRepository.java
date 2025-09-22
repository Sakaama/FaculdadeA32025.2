package TrabalhoFaculdade.A3.repository;

import TrabalhoFaculdade.A3.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
