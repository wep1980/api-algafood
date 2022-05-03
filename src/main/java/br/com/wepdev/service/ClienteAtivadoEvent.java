package br.com.wepdev.service;

import br.com.wepdev.modelo.Cliente;

public class ClienteAtivadoEvent {

	
	private Cliente cliente;

	
	public ClienteAtivadoEvent(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	
	public Cliente getCliente() {
		return cliente;
	}


	
	
	
}
