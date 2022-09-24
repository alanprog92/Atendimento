package br.edu.infnet.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import br.edu.infnet.atendimento.model.domain.Comercial;
import br.edu.infnet.atendimento.model.domain.Usuario;
import br.edu.infnet.atendimento.model.service.ComercialService;

@Controller
public class ComercialController {
	
	@Autowired
	ComercialService comercialService;
	
	@GetMapping(value= "/comercial/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("listagem", comercialService.obterLista());
		
		return "comercial/lista";
	}
	
	@GetMapping(value= "/comercial/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		comercialService.excluir(id);
		
		return "redirect:/comercial/lista";
	}
	
	@PostMapping(value= "/comercial/cadastro")
	public String inclusao(Model model, Comercial comercial, @SessionAttribute("user") Usuario usuario) {
		
		comercial.setUsuario(usuario);
		
		comercialService.incluir(comercial);
		
		return "redirect:/comercial/lista";
	}
	
	@GetMapping(value= "/comercial/cadastro")
	public String telaCadastro() {

		return "comercial/cadastro";
	}
	
	
}
