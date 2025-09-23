package TrabalhoFaculdade.A3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; // <-- ADICIONE ESTE IMPORT
import org.springframework.data.jpa.repository.config.EnableJpaRepositories; // <-- ADICIONE ESTE IMPORT

@SpringBootApplication
@EnableJpaRepositories("TrabalhoFaculdade.A3.repository") // <-- ADICIONE ESTA LINHA
@EntityScan("TrabalhoFaculdade.A3.model") // <-- ADICIONE ESTA LINHA
public class TrabalhoFaculdadeA3Application {

    public static void main(String[] args) {
        SpringApplication.run(TrabalhoFaculdadeA3Application.class, args);
    }

}