package TrabalhoFaculdade.A3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;

    // --- Campo útil que veio do Projeto ALUNO2 ---
    @Enumerated(EnumType.STRING)
    private StatusProjeto status; // Precisaremos criar o Enum StatusProjeto

    // --- Relacionamentos corretos que já tínhamos ---
    @JsonIgnore
    @OneToMany(mappedBy = "projeto")
    private List<Tarefa> tarefas;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}