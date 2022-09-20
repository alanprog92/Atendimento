package br.edu.infnet.atendimento.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Chamado;
import br.edu.infnet.atendimento.model.test.AppImpressao;

@Service
public class ChamadoService {
	private static Map<Integer, Chamado> mapaChamado = new HashMap<Integer, Chamado>();
	public static Integer id = 1;
	
	public void incluir(Chamado chamado) {
		
		chamado.setCodigo(id++);
		
		mapaChamado.put(chamado.getCodigo(), chamado);
		
		AppImpressao.relatorio("Inclusão do Chamado "+id, chamado);
		
	}
	
	public Collection<Chamado> obterLista(){
		return mapaChamado.values();
	}
	
	public void excluir(Integer id) {
		System.out.println("ID = "+id);
		mapaChamado.remove(id);
	}

}
