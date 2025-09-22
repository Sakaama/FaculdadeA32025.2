package TrabalhoFaculdade.A3.model; // Pacote correto

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "equipe")
    private List<Funcionario> membros;
}