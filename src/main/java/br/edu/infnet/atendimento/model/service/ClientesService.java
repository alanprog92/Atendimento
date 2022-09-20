package br.edu.infnet.atendimento.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Clientes;
import br.edu.infnet.atendimento.model.test.AppImpressao;

@Service
public class ClientesService {
	private static Map<Integer, Clientes> mapaCliente = new HashMap<Integer, Clientes>();
	public static Integer id = 1;
	
	public void incluir(Clientes cliente) {
		
		cliente.setId(id++);
		
		mapaCliente.put(cliente.getId(), cliente);
		
		AppImpressao.relatorio("Inclusão do Cliente "+id, cliente);
		
	}
	
	public Clientes buscaCliente( Integer id) {
		return mapaCliente.get(id);
	}
	
	public Collection<Clientes> obterLista(){
		return mapaCliente.values();
	}
	
	public void excluir(Integer id) {
		System.out.println("ID = "+id);
		mapaCliente.remove(id);
	}

}
