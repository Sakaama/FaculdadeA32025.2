package TrabalhoFaculdade.A3.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.model.Projeto;
import com.example.demo.model.StatusProjeto;
import com.example.demo.repository.ProjetoRepository;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto submeter(Projeto projeto, String username) {
        projeto.setClienteUsername(username);
        projeto.setStatus(StatusProjeto.AGUARDANDO_APROVACAO);
        return projetoRepository.save(projeto);
    }

    public Projeto aprovar(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        projeto.setStatus(StatusProjeto.APROVADO);
        return projetoRepository.save(projeto);
    }

    public Projeto rejeitar(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        projeto.setStatus(StatusProjeto.REJEITADO);
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarProjetosCliente(String username) {
        return projetoRepository.findByClienteUsername(username);
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }
}
