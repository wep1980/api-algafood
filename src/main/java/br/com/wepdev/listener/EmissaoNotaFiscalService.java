package br.com.wepdev.listener;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.wepdev.service.ClienteAtivadoEvent;

@Component
public class EmissaoNotaFiscalService {

	
	@EventListener // Esse metodo e um ouvinte de um evento
	public void clienteAtivadoListener(ClienteAtivadoEvent event) {
		System.out.println("Emitindo nota fiscal para cliente " + event.getCliente().getNome());
	}
	
}
