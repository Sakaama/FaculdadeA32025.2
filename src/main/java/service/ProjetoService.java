package TrabalhoFaculdade.A3.service;

import TrabalhoFaculdade.A3.model.Equipe;
import TrabalhoFaculdade.A3.model.Projeto;
import TrabalhoFaculdade.A3.model.StatusProjeto;
import TrabalhoFaculdade.A3.repository.EquipeRepository;
import TrabalhoFaculdade.A3.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired // INJEÇÃO ADICIONADA
    private EquipeRepository equipeRepository;

    public Projeto submeter(Projeto projeto) {
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

    // --- NOVO MÉTODO ADICIONADO AGORA ---
    public Projeto alocarEquipe(Long projetoId, Long equipeId) {
        // 1. Busca o projeto no banco de dados
        Projeto projeto = projetoRepository.findById(projetoId)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
        
        // 2. Busca a equipe no banco de dados
        Equipe equipe = equipeRepository.findById(equipeId)
                .orElseThrow(() -> new RuntimeException("Equipe não encontrada"));

        // 3. Associa a equipe ao projeto e atualiza o status
        projeto.setEquipe(equipe);
        projeto.setStatus(StatusProjeto.EM_ANDAMENTO);
        
        // 4. Salva o projeto atualizado no banco
        return projetoRepository.save(projeto);
    }
}