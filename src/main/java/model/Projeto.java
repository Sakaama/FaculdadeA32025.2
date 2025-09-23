package TrabalhoFaculdade.A3.model;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Data
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    // Adicione aqui outros campos se precisar, como data de início, data de fim, etc.

    @JsonIgnore
    @OneToMany(mappedBy = "projeto")
    private List<Tarefa> tarefas;

    // Relacionamento com Cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Futuramente, podemos adicionar um relacionamento com Equipe aqui também.
}