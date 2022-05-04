package br.com.wepdev.notificacao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.SEM_URGENCIA) // Anotação customizada
@Component
public class NotificadorEmail implements Notificador {
	
	@Value("${notificador.email.host-servidor}") // pegando os valores que foram definidos no application.properties
	private String host;
	
	@Value("${notificador.email.porta-servidor}") // pegando os valores que foram definidos no application.properties
	private Integer porta;

	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.println("Host: " + host);
		System.out.println("Porta: " + porta);
		
		System.out.printf("Notificando %s atrav�s do e-mail %s: %s\n", 
				cliente.getNome(), 
				cliente.getEmail(), 
				mensagem);
	}


}
