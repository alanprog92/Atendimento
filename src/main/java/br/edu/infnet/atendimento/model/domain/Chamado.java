package br.edu.infnet.atendimento.model.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import br.edu.infnet.atendimento.interfaces.IPrinter;
import br.edu.infnet.atendimento.model.exceptions.ClienteChamadoVazio;

public class Chamado implements IPrinter {
	private int codigo;
    private String problema;
    private LocalDate dataini;
    private LocalDate datafim;
    private String solucao;
    private Clientes cliente;
    private List<Profissional> profissionais;
    
    
    
	public Chamado() {
	}

	public Chamado(Clientes cliente) throws ClienteChamadoVazio {
		
		if(cliente == null) {
			throw new ClienteChamadoVazio("Informe o Cliente para poder incluir o Chamado!");
		}
		
		this.cliente = cliente;
	}
	
	public Chamado(int codigo, String problema, LocalDate dataini, LocalDate datafim, String solucao) {
		this.codigo = codigo;
		this.problema = problema;
		this.dataini = dataini;
		this.datafim = datafim;
		this.solucao = solucao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public LocalDate getDataini() {
		return dataini;
	}

	public void setDataini(LocalDate dataini) {
		this.dataini = dataini;
	}

	public LocalDate getDatafim() {
		return datafim;
	}

	public void setDatafim(LocalDate datafim) {
		this.datafim = datafim;
	}

	public String getSolucao() {
		return solucao;
	}

	public void setSolucao(String solucao) {
		this.solucao = solucao;
	}	
	
	@Override
	public void impressao() {
		System.out.println("#chamado");
		System.out.println(this);
		
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}

	@Override
	public String toString() {
		return "Chamado [codigo=" + codigo + ", problema=" + problema + ", dataini=" + dataini + ", datafim=" + datafim
				+ ", solucao=" + solucao + ", cliente=" + cliente + ", profissionais=" + profissionais + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Chamado other = (Chamado) obj;
		return codigo == other.codigo;
	} 

	
	
    
}
