package br.edu.infnet.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.atendimento.model.domain.Clientes;
import br.edu.infnet.atendimento.model.service.ClientesService;
@Controller
public class ClientesController {
	
	@Autowired
	ClientesService clientesService;
		
	@GetMapping(value= "/clientes/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("listagem", clientesService.obterLista());
		
		return "clientes/lista";
	}
	
	@GetMapping(value= "/clientes/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		clientesService.excluir(id);
		
		return "redirect:/clientes/lista";
	}
	
	@PostMapping(value= "/clientes/cadastro")
	public String inclusao(Model model, Clientes cliente) {
		
		clientesService.incluir(cliente);
		
		return "redirect:/clientes/lista";
	}
	
	@GetMapping(value= "/clientes/cadastro")
	public String telaCadastro() {

		return "clientes/cadastro";
	}
	

}
