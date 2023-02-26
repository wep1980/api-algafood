package br.com.wepdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import br.com.wepdev.domain.infrastructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class) // Alterando a raiz do repository base
public class ApiAlgafoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiAlgafoodApplication.class, args);
	}

}
