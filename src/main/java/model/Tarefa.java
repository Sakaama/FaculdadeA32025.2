package TrabalhoFaculdade.A3.model;

// IMPORTS QUE ESTAVAM FALTANDO
import jakarta.persistence.*;
import java.time.LocalDate;
import lombok.Data;
import TrabalhoFaculdade.A3.model.Projeto; // Este import é crucial
import TrabalhoFaculdade.A3.model.Funcionario; // Este import é crucial

@Entity
@Data
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusTarefa status;

    private LocalDate dataCriacao;
    private LocalDate prazo;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
}