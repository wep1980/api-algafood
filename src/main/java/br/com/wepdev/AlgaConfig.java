package br.com.wepdev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.wepdev.notificacao.NotificadorEmail;
import br.com.wepdev.service.AtivacaoClienteService;

//@Configuration // Anotacão que tem e um @Component que tem como objetivo a definição de beans
public class AlgaConfig {
	
	
	@Bean // Indica que esse metodo sera gerenciado pelo container spring
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
		notificador.setCaixaAlta(true);
		
		return notificador;
	}
	
	@Bean
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService(notificadorEmail());
	}

}
