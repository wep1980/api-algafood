package br.com.wepdev.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.com.wepdev.ApiAlgafoodApplication;
import br.com.wepdev.domain.model.Restaurante;
import br.com.wepdev.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {

public static void main(String[] args) {
		
	
		ApplicationContext applicationContext = new SpringApplicationBuilder(ApiAlgafoodApplication.class)
				.web(WebApplicationType.NONE) // Não é nenhuma aplicação WEB
				.run(args);

		RestauranteRepository restauranteRepository = applicationContext.getBean(RestauranteRepository.class); // Pegando um Bean do tipo CadastroRestaurante
		
		List<Restaurante> todosRestaurantes = restauranteRepository.listar();
		
		for (Restaurante restaurante  :  todosRestaurantes) {
			   System.out.printf("%s - %f - %s\n", 
					   restaurante.getNome() , 
					   restaurante.getTaxaFrete() , 
					   restaurante.getCozinha().getNome());
		}
			
		}
		
	}



