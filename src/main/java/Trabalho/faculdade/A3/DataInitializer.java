package TrabalhoFaculdade.A3;

import TrabalhoFaculdade.A3.model.Funcionario;
import TrabalhoFaculdade.A3.model.Projeto;
import TrabalhoFaculdade.A3.repository.FuncionarioRepository;
import TrabalhoFaculdade.A3.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component // Diz ao Spring para gerenciar esta classe e executá-la
public class DataInitializer implements CommandLineRunner {

    // Injeta os repositórios que precisamos para salvar os dados
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    @Override
    public void run(String... args) throws Exception {
        // Este código aqui dentro roda UMA VEZ, logo após a aplicação iniciar

        // Cria um novo funcionário
        Funcionario func1 = new Funcionario();
        func1.setNome("Funcionário Padrão");
        func1.setEmail("funcionario@email.com");
        func1.setCargo("Desenvolvedor");
        funcionarioRepository.save(func1); // Salva o funcionário no banco (ele receberá o id=1)

        // Cria um novo projeto
        Projeto proj1 = new Projeto();
        proj1.setNome("Projeto Piloto");
        proj1.setDescricao("Este é o primeiro projeto do sistema.");
        projetoRepository.save(proj1); // Salva o projeto no banco (ele receberá o id=1)

        // Mensagem para sabermos que funcionou
        System.out.println(">>> Dados iniciais (1 Funcionário e 1 Projeto) inseridos com sucesso! <<<");
    }
}