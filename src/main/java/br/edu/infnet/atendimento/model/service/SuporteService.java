package br.edu.infnet.atendimento.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Suporte;
import br.edu.infnet.atendimento.model.repository.SuporteRepository;
import br.edu.infnet.atendimento.model.test.AppImpressao;

@Service
public class SuporteService {
   
	@Autowired
	SuporteRepository suporteRepository;

	public void incluir(Suporte suporte) {
		
		suporteRepository.save(suporte);
		
		AppImpressao.relatorio("Inclusão do Suporte ", suporte);
		
	}
	
	public Collection<Suporte> obterLista(){
		return (Collection<Suporte>) suporteRepository.findAll();
	}
	
	public void excluir(Integer id) {
		System.out.println("ID = "+id);
		suporteRepository.deleteById(id);
	}

}
