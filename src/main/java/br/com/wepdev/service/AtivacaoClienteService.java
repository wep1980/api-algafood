package br.com.wepdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;
import br.com.wepdev.notificacao.Notificador;

@Component // Definindo a classe como um Bean spring, o spring gerencia, instancia , configura e injeta objetos dessa classe em outros beans
public class AtivacaoClienteService {
	
	@Autowired
	private Notificador notificador;
	
	/*
	 * O Construtor e sempre uma opção de ponto de injeção.
	 * Em alguns lugares essa opção e bastante utilizada, pois facilita bastante nos testes
	 */
//	@Autowired
//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//	}
//	
//	/*
//	 * Ao gerar um novo construtor o spring gera um erro, pois ele não sabe qual construtor utilizar,
//	 * para resolver o problema foi utilizado a anotação @Autowired no construtor acima
//	 */
//	public AtivacaoClienteService(String qualquerCoisa) {
//		
//	}

//	@Autowired
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}

	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		this.notificador.notificar(cliente, "Seu cadastro no sistema esta ativo!");
	}
	
	
	
	
	
	
	

}
