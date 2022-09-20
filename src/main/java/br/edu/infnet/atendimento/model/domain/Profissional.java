package br.edu.infnet.atendimento.model.domain;

import br.edu.infnet.atendimento.interfaces.IPrinter;

public abstract class Profissional implements IPrinter{

	private Integer id;
    private String nome;
    private int idade;
    private char sexo;
    private String CPF;
    private Endereco residencial;

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

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Endereco getResidencial() {
        return residencial;
    }

    public void setResidencial(Endereco residencial) {
        this.residencial = residencial;
    }

	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", CPF=" + CPF + ", residencial="
				+ residencial + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
    
    
}