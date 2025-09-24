package TrabalhoFaculdade.A3;

import TrabalhoFaculdade.A3.model.Equipe;
import TrabalhoFaculdade.A3.model.Funcionario;
import TrabalhoFaculdade.A3.model.Projeto;
import TrabalhoFaculdade.A3.repository.EquipeRepository;
import TrabalhoFaculdade.A3.repository.FuncionarioRepository;
import TrabalhoFaculdade.A3.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private EquipeRepository equipeRepository;

    @Override
    public void run(String... args) throws Exception {
        // Limpa os dados antigos para evitar duplicatas a cada reinicialização
        // (Opcional, mas bom para testes)
        // equipeRepository.deleteAll();
        // funcionarioRepository.deleteAll();
        // projetoRepository.deleteAll();

        // Cria as equipes de exemplo
        Equipe equipeAlpha = new Equipe();
        equipeAlpha.setNome("Equipe Alpha");
        equipeRepository.save(equipeAlpha);

        Equipe equipeBeta = new Equipe();
        equipeBeta.setNome("Equipe Beta");
        equipeRepository.save(equipeBeta);

        // Cria um funcionário de exemplo
        Funcionario func1 = new Funcionario();
        func1.setNome("Funcionário Padrão");
        func1.setEmail("funcionario@email.com");
        func1.setCargo("Desenvolvedor");
        func1.setEquipe(equipeAlpha); // Associa o funcionário à Equipe Alpha
        funcionarioRepository.save(func1);

        // Cria um projeto de exemplo
        Projeto proj1 = new Projeto();
        proj1.setNome("Projeto Piloto");
        proj1.setDescricao("Este é o primeiro projeto do sistema.");
        projetoRepository.save(proj1);

        System.out.println(">>> Dados iniciais inseridos com sucesso! <<<");
    }
}