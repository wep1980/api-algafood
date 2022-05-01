package br.com.wepdev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.wepdev.notificacao.NotificadorEmail;

@Configuration
public class NotificacaoConfig {

	
	@Bean // Indica que esse metodo sera gerenciado pelo container spring
	public NotificadorEmail notificadorEmail() {
		NotificadorEmail notificador = new NotificadorEmail("smtp.algamail.com.br");
		notificador.setCaixaAlta(true);
		
		return notificador;
	}
}
