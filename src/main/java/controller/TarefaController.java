package TrabalhoFaculdade.A3.controller;

import TrabalhoFaculdade.A3.model.StatusTarefa;
import TrabalhoFaculdade.A3.model.Tarefa;
import TrabalhoFaculdade.A3.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*; // Alterado para incluir tudo de web.bind.annotation

import java.util.List;

@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    // --- MÉTODO EXISTENTE ---
    // GET /api/tarefas/projeto/{projetoId}
    @GetMapping("/projeto/{projetoId}")
    public ResponseEntity<List<Tarefa>> buscarPorProjeto(@PathVariable Long projetoId) {
        List<Tarefa> tarefas = tarefaService.buscarTarefasPorProjeto(projetoId);
        return ResponseEntity.ok(tarefas);
    }
    
    // --- MÉTODO EXISTENTE ---
    // POST /api/tarefas
    @PostMapping
    public ResponseEntity<Tarefa> criarNovaTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    // --- MÉTODO NOVO QUE ESTAMOS ADICIONANDO ---
    // PUT /api/tarefas/{tarefaId}/status?novoStatus=EM_ANDAMENTO
    // Este método será acionado por uma requisição GET para, por exemplo, /api/tarefas/funcionario/1
@GetMapping("/funcionario/{funcionarioId}")
public ResponseEntity<List<Tarefa>> buscarPorFuncionario(@PathVariable Long funcionarioId) {
    List<Tarefa> tarefas = tarefaService.buscarTarefasPorFuncionario(funcionarioId);
    return ResponseEntity.ok(tarefas);
}
}   