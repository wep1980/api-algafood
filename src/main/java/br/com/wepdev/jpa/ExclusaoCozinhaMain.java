package br.com.wepdev.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.wepdev.ApiAlgafoodApplication;
import br.com.wepdev.domain.model.Cozinha;
import br.com.wepdev.domain.repository.CozinhaRepository;

public class ExclusaoCozinhaMain {

public static void main(String[] args) {
		
	
		ApplicationContext applicationContext = new SpringApplicationBuilder(ApiAlgafoodApplication.class)
				.web(WebApplicationType.NONE) // Não é nenhuma aplicação WEB
				.run(args);

		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class); // Pegando um Bean do tipo CadastroCozinha
		
        Cozinha cozinha1 = new Cozinha();
        cozinha1.setId(1L);
        
        cozinhaRepository.remover(cozinha1);
        
        
		}
		
	}



