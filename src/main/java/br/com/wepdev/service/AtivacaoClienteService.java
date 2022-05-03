package br.com.wepdev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;
import br.com.wepdev.notificacao.NivelUrgencia;
import br.com.wepdev.notificacao.Notificador;
import br.com.wepdev.notificacao.TipoDoNotificador;

@Component // Definindo a classe como um Bean spring, o spring gerencia, instancia , configura e injeta objetos dessa classe em outros beans
public class AtivacaoClienteService {
	
	//@Qualifier("urgente")
	@TipoDoNotificador(NivelUrgencia.NORMAL)
	@Autowired//(required = false) // Dessa forma e informado que a dependencia dessa classe não e obrigatoria
	private Notificador notificador;
	
//	@Autowired
//	private List<Notificador> notificadores;
	
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
	
		notificador.notificar(cliente, "Seu cadastro no sistema esta ativo!");

//		for(Notificador notificador : notificadores) {
//			notificador.notificar(cliente, "Seu cadastro no sistema esta ativo!");
//		}
	}
	
	
	
	
	
	
	

}
