package br.edu.infnet.atendimento.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Programador;
import br.edu.infnet.atendimento.model.test.AppImpressao;

@Service
public class ProgramadorService {
	private static Map<Integer, Programador> mapaProgramador = new HashMap<Integer, Programador>();
	public static Integer id = 1;
	
	public void incluir(Programador programador) {
		
		programador.setId(id++);
		
		mapaProgramador.put(programador.getId(), programador);
		
		AppImpressao.relatorio("Inclusão do Programador "+id, programador);
		
	}
	
	public Collection<Programador> obterLista(){
		return mapaProgramador.values();
	}
	
	public void excluir(Integer id) {
		System.out.println("ID = "+id);
		mapaProgramador.remove(id);
	}

}
