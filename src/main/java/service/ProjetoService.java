package TrabalhoFaculdade.A3.service;

import TrabalhoFaculdade.A3.model.Projeto;
import TrabalhoFaculdade.A3.model.StatusProjeto;
import TrabalhoFaculdade.A3.repository.ProjetoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional; // É uma boa prática importar Optional

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto submeter(Projeto projeto) {
        // A lógica de username foi removida, pois agora lidamos com o objeto Cliente
        projeto.setStatus(StatusProjeto.AGUARDANDO_APROVACAO);
        return projetoRepository.save(projeto);
    }

    public Projeto aprovar(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com id: " + id));
        projeto.setStatus(StatusProjeto.APROVADO);
        return projetoRepository.save(projeto);
    }

    public Projeto rejeitar(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado com id: " + id));
        projeto.setStatus(StatusProjeto.REJEITADO);
        return projetoRepository.save(projeto);
    }

    public List<Projeto> listarTodos() {
        return projetoRepository.findAll();
    }
}