package br.edu.infnet.atendimento.model.domain;

import br.edu.infnet.atendimento.interfaces.IPrinter;

public class Usuario  implements IPrinter {
	
	private String nome;
	private String email;
	private String senha;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", email=" + email + ", senha=" + senha + "]";
	}
	@Override
	public void impressao() {
		System.out.println("#usuarios");
		System.out.println(this);		
	}
	
	

}
