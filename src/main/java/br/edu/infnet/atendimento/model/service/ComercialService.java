package br.edu.infnet.atendimento.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Comercial;
import br.edu.infnet.atendimento.model.test.AppImpressao;

@Service
public class ComercialService {
	private static Map<Integer, Comercial> mapaComercial = new HashMap<Integer, Comercial>();
	public static Integer id = 1;
	
	public void incluir(Comercial comercial) {
		
		comercial.setId(id++);
		
		mapaComercial.put(comercial.getId(), comercial);
		
		AppImpressao.relatorio("Inclusão do Comercial "+id, comercial);
		
	}
	
	public Collection<Comercial> obterLista(){
		return mapaComercial.values();
	}
	
	public void excluir(Integer id) {
		System.out.println("ID = "+id);
		mapaComercial.remove(id);
	}

}
