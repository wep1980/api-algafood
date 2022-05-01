package br.com.wepdev.service;

import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;
import br.com.wepdev.notificacao.NotificadorEmail;

@Component // Definindo a classe como um Bean spring, o spring gerencia, instancia , configura e injeta objetos dessa classe em outros beans
public class AtivacaoClienteService {
	
	
	private NotificadorEmail notificador;
	

	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		this.notificador.notificar(cliente, "Seu cadastro no sistema esta ativo!");
	}
	
	
	
	
	
	
	

}
