package br.com.wepdev;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.wepdev.service.AtivacaoClienteService;

@Configuration
public class ServiceConfig {
	
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public AtivacaoClienteService ativacaoClienteService() {
		return new AtivacaoClienteService();
	}

}
