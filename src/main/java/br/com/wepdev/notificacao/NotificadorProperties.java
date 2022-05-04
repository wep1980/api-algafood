package br.com.wepdev.notificacao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("notificador.email") // Afirma que essa classe representa um arquivo de configuracão de propriedades 
public class NotificadorProperties {
	
	/**
	 * Hosto do servidor de email
	 */
	private String hostServidor;
	
	/**
	 * Porta do servidor de email
	 */
	private Integer portaServidor;

	
	
	public String getHostServidor() {
		return hostServidor;
	}

	public void setHostServidor(String hostServidor) {
		this.hostServidor = hostServidor;
	}

	public Integer getPortaServidor() {
		return portaServidor;
	}

	public void setPortaServidor(Integer portaServidor) {
		this.portaServidor = portaServidor;
	}
	
	
	

}
