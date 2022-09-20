package br.edu.infnet.atendimento.model.domain;

import java.util.Objects;

import br.edu.infnet.atendimento.interfaces.IPrinter;

public class Clientes implements IPrinter {
    private Integer id;
	private String nome;
    private int idade;
    private char sexo;
    private String CPF;
    private Endereco residencial;
    
	public Clientes() {
	}    
    
	public Clientes(String nome, int idade, char sexo, String cPF, Endereco residencial) {
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.CPF = cPF;
		this.residencial = residencial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		this.CPF = cPF;
	}

	public Endereco getResidencial() {
		return residencial;
	}

	public void setResidencial(Endereco residencial) {
		this.residencial = residencial;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	} 	

	@Override
	public String toString() {
		return "Clientes [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", CPF=" + CPF + ", residencial="
				+ residencial + "]";
	}
	
	@Override
	public void impressao() {
		System.out.println("#clientes");
		System.out.println(this);
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clientes other = (Clientes) obj;
		return Objects.equals(id, other.id);
	}
	
	
    
}
