package br.edu.infnet.atendimento.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Comercial;
import br.edu.infnet.atendimento.model.domain.Usuario;
import br.edu.infnet.atendimento.model.repository.ComercialRepository;
import br.edu.infnet.atendimento.model.test.AppImpressao;

@Service
public class ComercialService {
	
	@Autowired
	ComercialRepository comercialRepository;
	
	public void incluir(Comercial comercial) {
		
		comercialRepository.save(comercial);
		
		AppImpressao.relatorio("Inclusão do Comercial ", comercial);
		
	}
	
	public Collection<Comercial> obterLista(){
		return (Collection<Comercial>) comercialRepository.findAll();
	}
	
	public Collection<Comercial> obterLista(Usuario usuario){
		return (Collection<Comercial>) comercialRepository.findAll(usuario.getId());
	}		
	
	public void excluir(Integer id) {
		System.out.println("ID = "+id);
		comercialRepository.deleteById(id);
	}

}
