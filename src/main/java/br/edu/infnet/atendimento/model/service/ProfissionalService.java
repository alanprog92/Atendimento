package br.edu.infnet.atendimento.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Profissional;
import br.edu.infnet.atendimento.model.repository.ProfissionalRepository;

@Service
public class ProfissionalService {
	
	@Autowired
	ProfissionalRepository profissionalRepository;
	
	public void incluir(Profissional profissional) {
		
		profissionalRepository.save(profissional);
		
	}
	
	public Optional<Profissional> buscaProfissional( Integer id) {
		return profissionalRepository.findById(id); 
	}
	
	public Collection<Profissional> obterLista(){
		return (Collection<Profissional>) profissionalRepository.findAll();
	}
	
	public void excluir(Integer id) {
		profissionalRepository.deleteById(id);
	}

}
