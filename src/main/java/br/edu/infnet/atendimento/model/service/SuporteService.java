package br.edu.infnet.atendimento.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Suporte;
import br.edu.infnet.atendimento.model.test.AppImpressao;

@Service
public class SuporteService {
	private static Map<Integer, Suporte> mapaSuporte = new HashMap<Integer, Suporte>();
	public static Integer id = 1;
	
	public void incluir(Suporte suporte) {
		
		suporte.setId(id++);
		
		mapaSuporte.put(suporte.getId(), suporte);
		
		AppImpressao.relatorio("Inclusão do Suporte "+id, suporte);
		
	}
	
	public Collection<Suporte> obterLista(){
		return mapaSuporte.values();
	}
	
	public void excluir(Integer id) {
		System.out.println("ID = "+id);
		mapaSuporte.remove(id);
	}

}
