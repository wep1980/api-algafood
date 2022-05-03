package br.com.wepdev.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import br.com.wepdev.modelo.Cliente;

//@Qualifier("normal") // Qualificando esse componente
@Profile("dev") // Esse componente vai ser registrado no spring apenas se o projeto estiver rodando no ambiente de desenvolvimento
@TipoDoNotificador(NivelUrgencia.NORMAL) // Anotação customizada
@Component
public class NotificadorEmailMock implements Notificador {
	
	// com esse construtor eu consigo testar o ambiente que esta funcionando
	public NotificadorEmailMock() {
		System.out.println("Notificado email MOCK - AMBIENTE DE DESENVOLVIMENTO");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
	
		System.out.printf("MOCK: Notificação seria enviada para %s através do e-mail %s: %s\n", 
				cliente.getNome(), 
				cliente.getEmail(), 
				mensagem);
	}


}
