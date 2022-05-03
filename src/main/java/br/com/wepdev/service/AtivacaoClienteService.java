package br.com.wepdev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;
import br.com.wepdev.notificacao.NivelUrgencia;
import br.com.wepdev.notificacao.Notificador;
import br.com.wepdev.notificacao.TipoDoNotificador;

/*
 * Essa classe possui uma coesão baixa, pois ela tem 2 responsabilidades, ativar e notificar.
 * Quanto mais alta for a coesão melhor(menos responsabilidade), com o Design pattern OBSERVER e possivel fazer isso.
 */
@Component 
public class AtivacaoClienteService {
	
	
	@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA)
	@Autowired
	private Notificador notificador;
	
	@Autowired
	private ApplicationEventPublisher eventPublisher; // Dispara o evento, publica eventos

		
	public void ativar(Cliente cliente) {
		cliente.ativar();
	
		/*
		 * Dispara para todo o sistema que o cliente ja foi ativado, quem tiver interesse pode aproveitar o evento
		 */
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
		
	}
	


}
