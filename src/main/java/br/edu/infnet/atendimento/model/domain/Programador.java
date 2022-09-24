package br.edu.infnet.atendimento.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "programador")
public class Programador extends Profissional {
    private String linguagem;
    private char sabeoo;
    private char bebecafe;
    
	public Programador() {
	}
    
	public Programador( String nome, String CPF, char sexo, Integer idade, Endereco residencial, String linguagem, char sabeoo, char bebecafe) {
		super();
		this.linguagem = linguagem;
		this.sabeoo = sabeoo;
		this.bebecafe = bebecafe;
	}
	
	public String getLinguagem() {
		return linguagem;
	}
	public void setLinguagem(String linguagem) {
		this.linguagem = linguagem;
	}
	public char getSabeoo() {
		return sabeoo;
	}
	public void setSabeoo(char sabeoo) {
		this.sabeoo = sabeoo;
	}
	public char getBebecafe() {
		return bebecafe;
	}
	public void setBebecafe(char bebecafe) {
		this.bebecafe = bebecafe;
	}

	@Override
	public String toString() {
		return "Programador [linguagem=" + linguagem + ", sabeoo=" + sabeoo + ", bebecafe=" + bebecafe+", " + super.toString()+ "]";
	}

	@Override
	public void impressao() {
		System.out.println("#programador");
		System.out.println(this);
		
	} 

}
