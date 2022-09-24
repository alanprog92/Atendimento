package br.edu.infnet.atendimento.model.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.atendimento.interfaces.IPrinter;
import br.edu.infnet.atendimento.model.exceptions.ClienteChamadoVazio;

@Entity
@Table(name = "chamado")
public class Chamado implements IPrinter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    private String problema;
    private LocalDate dataini;
    private LocalDate datafim;
    private String solucao;
    @OneToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "idCliente")
    private Clientes cliente;
    
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Profissional> profissionais;
    
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
    
    
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Chamado() {
	}

	public Chamado(Clientes cliente) throws ClienteChamadoVazio {
		
		if(cliente == null) {
			throw new ClienteChamadoVazio("Informe o Cliente para poder incluir o Chamado!");
		}
		
		this.cliente = cliente;
	}
	
	public Chamado(int id, String problema, LocalDate dataini, LocalDate datafim, String solucao) {
		this.id = id;
		this.problema = problema;
		this.dataini = dataini;
		this.datafim = datafim;
		this.solucao = solucao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Chamado [id=" + id + ", problema=" + problema + ", dataini=" + dataini + ", datafim=" + datafim
				+ ", solucao=" + solucao + ", cliente=" + cliente + ", profissionais=" + profissionais + "]";
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
		Chamado other = (Chamado) obj;
		return id == other.id;
	} 

	
	
    
}
