package TrabalhoFaculdade.A3.model; // Pacote correto

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
    private String cargo;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}