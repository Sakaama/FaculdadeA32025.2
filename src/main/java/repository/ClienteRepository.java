package TrabalhoFaculdade.A3.repository;

import TrabalhoFaculdade.A3.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}