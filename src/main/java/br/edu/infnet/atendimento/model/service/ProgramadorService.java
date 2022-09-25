package br.edu.infnet.atendimento.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Programador;
import br.edu.infnet.atendimento.model.domain.Usuario;
import br.edu.infnet.atendimento.model.repository.ProgramadorRepository;
import br.edu.infnet.atendimento.model.test.AppImpressao;

@Service
public class ProgramadorService {

    @Autowired
    ProgramadorRepository programadorRepository;
	
	public void incluir(Programador programador) {
		
		programadorRepository.save(programador);
		
		AppImpressao.relatorio("Inclusão do Programador ", programador);
		
	}
	
	public Collection<Programador> obterLista(){
		return (Collection<Programador>) programadorRepository.findAll();
	}
	
	public Collection<Programador> obterLista(Usuario usuario){
		return (Collection<Programador>) programadorRepository.findAll(usuario.getId());
	}			
	
	public void excluir(Integer id) {
		System.out.println("ID = "+id);
		programadorRepository.deleteById(id);
	}

}
