package TrabalhoFaculdade.A3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Projeto;
import com.example.demo.service.ProjetoService;

import java.util.List;

@RestController
@RequestMapping("/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping("/submeter")
    public ResponseEntity<Projeto> submeter(@RequestBody Projeto projeto, @RequestParam String username) {
        return ResponseEntity.ok(projetoService.submeter(projeto, username));
    }

    @PutMapping("/{id}/aprovar")
    public ResponseEntity<Projeto> aprovar(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.aprovar(id));
    }

    @PutMapping("/{id}/rejeitar")
    public ResponseEntity<Projeto> rejeitar(@PathVariable Long id) {
        return ResponseEntity.ok(projetoService.rejeitar(id));
    }

    @GetMapping("/cliente/{username}")
    public ResponseEntity<List<Projeto>> listarProjetosCliente(@PathVariable String username) {
        return ResponseEntity.ok(projetoService.listarProjetosCliente(username));
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> listarTodos() {
        return ResponseEntity.ok(projetoService.listarTodos());
    }
}

