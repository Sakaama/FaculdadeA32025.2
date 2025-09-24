package TrabalhoFaculdade.A3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Projeto;
import java.util.List;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findByClienteUsername(String username);
}
