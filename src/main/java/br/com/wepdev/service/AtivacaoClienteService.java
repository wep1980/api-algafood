package br.com.wepdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;
import br.com.wepdev.notificacao.Notificador;

@Component // Definindo a classe como um Bean spring, o spring gerencia, instancia , configura e injeta objetos dessa classe em outros beans
public class AtivacaoClienteService {
	
	@Autowired(required = false) // Dessa forma e informado que a dependencia dessa classe não e obrigatoria
	private Notificador notificador;
	
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		if(notificador != null) {
			this.notificador.notificar(cliente, "Seu cadastro no sistema esta ativo!");
		} else {
			System.out.println("Não existe notificador, mas cliente foi ativado");
		}
	}
	
	
	
	
	
	
	

}
