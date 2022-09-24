package br.edu.infnet.atendimento.model.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.edu.infnet.atendimento.interfaces.IPrinter;

@Entity
@Table(name = "profissional")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Profissional implements IPrinter{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    private String nome;
    private int idade;
    private char sexo;
    private String CPF;
    
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "residencial")
    private Endereco residencial;
    
    @ManyToMany(mappedBy = "profissionais")
	private List<Chamado> chamados;
    
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;    

    public List<Chamado> getChamados() {
		return chamados;
	}

	public void setChamados(List<Chamado> chamados) {
		this.chamados = chamados;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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