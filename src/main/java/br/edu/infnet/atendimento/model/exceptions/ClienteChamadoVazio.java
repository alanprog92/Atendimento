package br.edu.infnet.atendimento.model.exceptions;

public class ClienteChamadoVazio extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ClienteChamadoVazio(String mensagem) {
		super(mensagem);
	}

}
