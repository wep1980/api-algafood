package br.com.wepdev.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.wepdev.notificacao.NivelUrgencia;
import br.com.wepdev.notificacao.Notificador;
import br.com.wepdev.notificacao.TipoDoNotificador;
import br.com.wepdev.service.ClienteAtivadoEvent;

/**
 * Classe que tem interesse em escutar os eventos
 * @author Waldir
 *
 */
@Component
public class NotificacaoService {

	
	@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
	@Autowired
	private Notificador notificador;
	
	
	@EventListener // Esse metodo e um ouvinte de um evento
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		notificador.notificar(event.getCliente(), "Seu cadastro no sistema está ativo!");
	}
}
