package TrabalhoFaculdade.A3.controller;

import TrabalhoFaculdade.A3.model.Projeto;
import TrabalhoFaculdade.A3.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes; // IMPORTANTE: Adicione este import

import java.util.List;

@Controller
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    // --- MÉTODOS DA API (RETORNAM JSON) ---

    @PostMapping("/submeter")
    @ResponseBody
    public ResponseEntity<Projeto> submeter(@RequestBody Projeto projeto) {
        return ResponseEntity.ok(projetoService.submeter(projeto));
    }

    @PutMapping("/{id}/aprovar")
    @ResponseBody
    public ResponseEntity<Projeto> aprovarApi(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.aprovar(id));
    }

    @PutMapping("/{id}/rejeitar")
    @ResponseBody
    public ResponseEntity<Projeto> rejeitarApi(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.rejeitar(id));
    }

    @GetMapping("/api/todos")
    @ResponseBody
    public ResponseEntity<List<Projeto>> listarTodosApi() {
        return ResponseEntity.ok(projetoService.listarTodos());
    }


    // --- MÉTODOS PARA AS PÁGINAS WEB (RETORNAM HTML) ---

    // Exibe a página com o formulário para criar um novo projeto
    @GetMapping("/novo")
    public String exibirFormularioNovoProjeto(Model model) {
        model.addAttribute("projeto", new Projeto());
        return "formulario-projeto";
    }

    // Processa o envio do formulário e salva o novo projeto
    @PostMapping
    public String salvarNovoProjeto(@ModelAttribute Projeto projeto, RedirectAttributes redirectAttributes) { // Adicionado RedirectAttributes
        projetoService.submeter(projeto);
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Novo projeto submetido com sucesso!"); // Adicionada mensagem
        return "redirect:/projetos";
    }

    // Exibe a página que lista todos os projetos
    @GetMapping
    public String listarTodos(Model model) {
        List<Projeto> todosOsProjetos = projetoService.listarTodos();
        model.addAttribute("projetos", todosOsProjetos);
        return "lista-projetos";
    }

    // --- MÉTODOS ATUALIZADOS COM MENSAGEM DE FEEDBACK ---

    // Processa a ação do botão "Aprovar" do formulário
    @PostMapping("/{id}/aprovar")
    public String aprovarProjeto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        projetoService.aprovar(id);
        // Adiciona uma mensagem de sucesso que estará disponível após o redirecionamento
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Projeto aprovado com sucesso!");
        return "redirect:/projetos";
    }

    // Processa a ação do botão "Rejeitar" do formulário
    @PostMapping("/{id}/rejeitar")
    public String rejeitarProjeto(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        projetoService.rejeitar(id);
        // Adiciona uma mensagem de sucesso que estará disponível após o redirecionamento
        redirectAttributes.addFlashAttribute("mensagemSucesso", "Projeto rejeitado com sucesso!");
        return "redirect:/projetos";
    }
}