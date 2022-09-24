package br.edu.infnet.atendimento.model.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "suporte")
public class Suporte extends Profissional{
	
    private String sopreferido;
    private char sabeformatar;
    private char saberedes;
    
	public Suporte() {
		
	}    
    
	public Suporte( String nome, String CPF, char sexo, Integer idade, Endereco residencial, String sopreferido, char sabeformatar, char saberedes) {
		super();
		this.sopreferido = sopreferido;
		this.sabeformatar = sabeformatar;
		this.saberedes = saberedes;
	}

	public String getSopreferido() {
		return sopreferido;
	}

	public void setSopreferido(String sopreferido) {
		this.sopreferido = sopreferido;
	}

	public char getSabeformatar() {
		return sabeformatar;
	}

	public void setSabeformatar(char sabeformatar) {
		this.sabeformatar = sabeformatar;
	}

	public char getSaberedes() {
		return saberedes;
	}

	public void setSaberedes(char saberedes) {
		this.saberedes = saberedes;
	}

	@Override
	public String toString() {
		return "Suporte [sopreferido=" + sopreferido + ", sabeformatar=" + sabeformatar + ", saberedes=" + saberedes+
				", "+ super.toString()+ "]";
	}
	
	@Override
	public void impressao() {
		System.out.println("#suporte");
		System.out.println(this);
		
	} 

}
