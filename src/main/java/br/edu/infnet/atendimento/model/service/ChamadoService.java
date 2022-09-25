package br.edu.infnet.atendimento.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Chamado;
import br.edu.infnet.atendimento.model.domain.Usuario;
import br.edu.infnet.atendimento.model.repository.ChamadoRepository;
import br.edu.infnet.atendimento.model.test.AppImpressao;

@Service
public class ChamadoService {

    @Autowired
    ChamadoRepository chamadoreposRepository;
    
	public void incluir(Chamado chamado) {
		
		chamadoreposRepository.save(chamado);
		
		AppImpressao.relatorio("Inclusão do Chamado ", chamado);
		
	}
	
	public Collection<Chamado> obterLista(){
		return (Collection<Chamado>) chamadoreposRepository.findAll();
	}
	
	public Collection<Chamado> obterLista(Usuario usuario){
		return (Collection<Chamado>) chamadoreposRepository.findAll(usuario.getId());
	}	
	
	public void excluir(Integer id) {
		System.out.println("ID = "+id);
		chamadoreposRepository.deleteById(id);
	}

}
