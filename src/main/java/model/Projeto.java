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

    @Enumerated(EnumType.STRING)
    private StatusProjeto status;

    @JsonIgnore
    @OneToMany(mappedBy = "projeto")
    private List<Tarefa> tarefas;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
        
    // --- NOVO RELACIONAMENTO ADICIONADO AGORA ---
    @ManyToOne
    @JoinColumn(name = "equipe_id") // Isso criará uma coluna equipe_id na tabela de projeto
    private Equipe equipe;
}