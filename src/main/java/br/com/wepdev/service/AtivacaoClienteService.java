package br.com.wepdev.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;
import br.com.wepdev.notificacao.NivelUrgencia;
import br.com.wepdev.notificacao.Notificador;
import br.com.wepdev.notificacao.TipoDoNotificador;

//@Component 
public class AtivacaoClienteService {
	
	@TipoDoNotificador(NivelUrgencia.NORMAL)
	@Autowired
	private Notificador notificador;

		
	public void ativar(Cliente cliente) {
		cliente.ativar();
	
		notificador.notificar(cliente, "Seu cadastro no sistema esta ativo!");
	}
	
	/**
	 * @PostConstruct -> Metodo que se inicia apos a fase de inicialização de todas as injeções e construtores 
	 */
	//@PostConstruct
	public void init() {
		System.out.println("Metodo INIT iniciado " + notificador);
	}
	
	/**
	 * @PreDestroy -> Metodo que se inicia depois da finalização de todos os beans
	 */
	//@PreDestroy
	public void destroy() {
		System.out.println("Metodo DESTROY chamado");
	}
	
	
	
	

}
