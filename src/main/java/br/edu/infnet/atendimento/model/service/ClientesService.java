package br.edu.infnet.atendimento.model.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Clientes;
import br.edu.infnet.atendimento.model.repository.ClientesRepository;

@Service
public class ClientesService {
	
	@Autowired
	ClientesRepository clientesRepository;
	
	public void incluir(Clientes cliente) {
		
		clientesRepository.save(cliente);
		
	}
	
	public Optional<Clientes> buscaCliente( Integer id) {
		return clientesRepository.findById(id); 
	}
	
	public Collection<Clientes> obterLista(){
		return (Collection<Clientes>) clientesRepository.findAll();
	}
	
	public void excluir(Integer id) {
		clientesRepository.deleteById(id);
	}

}
