package br.com.wepdev.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.wepdev.ApiAlgafoodApplication;
import br.com.wepdev.domain.model.Cozinha;
import br.com.wepdev.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {

public static void main(String[] args) {
		
	
		ApplicationContext applicationContext = new SpringApplicationBuilder(ApiAlgafoodApplication.class)
				.web(WebApplicationType.NONE) // Não é nenhuma aplicação WEB
				.run(args);

		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class); // Pegando um Bean do tipo CadastroCozinha
		
		List<Cozinha> todasCozinhas = cozinhas.listar();
		
		for(Cozinha cozinha : todasCozinhas) {
			System.out.println(cozinha.getNome());
			
		}
		
	}


}
