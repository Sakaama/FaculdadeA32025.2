package TrabalhoFaculdade.A3.controller;

import TrabalhoFaculdade.A3.model.Funcionario;
import TrabalhoFaculdade.A3.model.Projeto;
import TrabalhoFaculdade.A3.model.StatusTarefa;
import TrabalhoFaculdade.A3.model.Tarefa;
import TrabalhoFaculdade.A3.repository.FuncionarioRepository;
import TrabalhoFaculdade.A3.repository.ProjetoRepository;
import TrabalhoFaculdade.A3.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    // --- MÉTODOS DA API (RETORNAM JSON) ---

    @GetMapping("/api/tarefas/projeto/{projetoId}")
    @ResponseBody
    public ResponseEntity<List<Tarefa>> buscarPorProjeto(@PathVariable Long projetoId) {
        List<Tarefa> tarefas = tarefaService.buscarTarefasPorProjeto(projetoId);
        return ResponseEntity.ok(tarefas);
    }
    
    @GetMapping("/api/tarefas/funcionario/{funcionarioId}")
    @ResponseBody
    public ResponseEntity<List<Tarefa>> buscarPorFuncionario(@PathVariable Long funcionarioId) {
        List<Tarefa> tarefas = tarefaService.buscarTarefasPorFuncionario(funcionarioId);
        return ResponseEntity.ok(tarefas);
    }

    @PostMapping("/api/tarefas")
    @ResponseBody
    public ResponseEntity<Tarefa> criarNovaTarefa(@RequestBody Tarefa tarefa) {
        Tarefa novaTarefa = tarefaService.criarTarefa(tarefa);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }

    @PutMapping("/api/tarefas/{tarefaId}/status")
    @ResponseBody
    public ResponseEntity<Tarefa> atualizarStatus(
            @PathVariable Long tarefaId,
            @RequestParam StatusTarefa novoStatus) {

        Tarefa tarefaAtualizada = tarefaService.atualizarStatusTarefa(tarefaId, novoStatus);
        return ResponseEntity.ok(tarefaAtualizada);
    }


    // --- MÉTODOS PARA AS PÁGINAS WEB (RETORNAM HTML) ---

    @GetMapping("/minhas-tarefas/{funcionarioId}")
    public String exibirMinhasTarefas(@PathVariable Long funcionarioId, Model model) {
        List<Tarefa> tarefasDoFuncionario = tarefaService.buscarTarefasPorFuncionario(funcionarioId);
        model.addAttribute("tarefas", tarefasDoFuncionario);
        return "minhas-tarefas";
    }

    @GetMapping("/projetos/{projetoId}/tarefas/nova")
    public String exibirFormularioNovaTarefa(@PathVariable Long projetoId, Model model) {
        model.addAttribute("tarefa", new Tarefa());
        model.addAttribute("projetoId", projetoId);
        return "formulario-tarefa";
    }

    @PostMapping("/projetos/{projetoId}/tarefas")
    public String salvarNovaTarefa(@PathVariable Long projetoId, @ModelAttribute Tarefa tarefa) {
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new IllegalArgumentException("Projeto inválido Id:" + projetoId));

        Funcionario funcionario = funcionarioRepository.findById(1L)
                .orElseThrow(() -> new IllegalArgumentException("Funcionário padrão não encontrado Id: 1"));

        tarefa.setProjeto(projeto);
        tarefa.setFuncionario(funcionario);

        tarefaService.criarTarefa(tarefa);

        return "redirect:/minhas-tarefas/" + funcionario.getId();
    }

    // --- MÉTODO NOVO ADICIONADO AGORA ---
    @PostMapping("/tarefas/{tarefaId}/status")
    public String atualizarStatusPeloFormulario(@PathVariable Long tarefaId, @RequestParam StatusTarefa novoStatus) {
        // 1. Usa o service que já está pronto para atualizar o status
        Tarefa tarefaAtualizada = tarefaService.atualizarStatusTarefa(tarefaId, novoStatus);

        // 2. Pega o ID do funcionário da tarefa para saber para qual página redirecionar
        Long funcionarioId = tarefaAtualizada.getFuncionario().getId();

        // 3. Redireciona o usuário de volta para a sua própria página de "Minhas Tarefas"
        return "redirect:/minhas-tarefas/" + funcionarioId;
    }
}