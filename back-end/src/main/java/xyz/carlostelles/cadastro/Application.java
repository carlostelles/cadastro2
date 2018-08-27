package xyz.carlostelles.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("xyz.carlostelles.cadastro.persistence")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
