package br.com.wepdev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.wepdev.notificacao.Notificador;
import br.com.wepdev.service.AtivacaoClienteService;

@Configuration
public class ServiceConfig {
	
	
	@Bean
	public AtivacaoClienteService ativacaoClienteService(Notificador notificador) {
		return new AtivacaoClienteService(notificador);
	}

}
