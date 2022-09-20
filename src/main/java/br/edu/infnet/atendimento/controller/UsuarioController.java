package br.edu.infnet.atendimento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infnet.atendimento.model.domain.Usuario;
import br.edu.infnet.atendimento.model.service.UsuarioService;
@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping(value= "/usuario/cadastro")
	public String telaCadastro() {

		return "usuario/cadastro";
	}
	
	@GetMapping(value= "/usuario/lista")
	public String telaLista(Model model, String user) {
		
		model.addAttribute("listagem", usuarioService.obterLista());
		model.addAttribute("user", user);
		
		return "usuario/lista";
	}
	
	@GetMapping(value= "/usuario/{email}/excluir")
	public String exclusao(@PathVariable String email) {
		
		usuarioService.excluir(email);
		
		return "redirect:/usuario/lista";
	}
	
	@PostMapping(value= "/usuario/cadastro")
	public String inclusao(Model model, Usuario usuario) {
		
		usuarioService.incluir(usuario);
		
		return "redirect:/";
	}
	

}
