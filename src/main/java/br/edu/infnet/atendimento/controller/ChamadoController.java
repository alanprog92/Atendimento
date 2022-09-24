package br.edu.infnet.atendimento.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.request.WebRequest;

import br.edu.infnet.atendimento.model.domain.Chamado;
import br.edu.infnet.atendimento.model.domain.Clientes;
import br.edu.infnet.atendimento.model.domain.Profissional;
import br.edu.infnet.atendimento.model.domain.Usuario;
import br.edu.infnet.atendimento.model.service.ChamadoService;
import br.edu.infnet.atendimento.model.service.ClientesService;
import br.edu.infnet.atendimento.model.service.ProfissionalService;

@Controller
public class ChamadoController {
	
	@Autowired
	ChamadoService chamadoService;
	
	@Autowired
	ClientesService clienteService;
	
	@Autowired
	ProfissionalService profissionalService;	
	
	@GetMapping(value= "/chamado/lista")
	public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {
		
		model.addAttribute("listagem", chamadoService.obterLista());
		
		return "chamado/lista";
	}
	
	@GetMapping(value= "/chamado/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		chamadoService.excluir(id);
		
		return "redirect:/chamado/lista";
	}
	
	@PostMapping(value= "/chamado/cadastro")
	public String inclusao(Model model, WebRequest request, @SessionAttribute("user") Usuario usuario) {
		
		String dataini = request.getParameterValues("dataini")[0];
		String datafim = request.getParameterValues("datafim")[0];
		String problema = request.getParameterValues("problema")[0];
		String solucao = request.getParameterValues("solucao")[0];
		String cliente = request.getParameterValues("cliente")[0];
		 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate datainiaux = LocalDate.parse(dataini,formatter);
		
		LocalDate datafimaux = LocalDate.parse(datafim,formatter);

		Chamado chamado = new Chamado();
		chamado.setUsuario(usuario);
		chamado.setDataini( datainiaux );
		chamado.setDatafim( datafimaux );
		chamado.setProblema(problema);
		chamado.setSolucao(solucao);
		
		Optional<Clientes> cli = clienteService.buscaCliente( Integer.parseInt(cliente) );
		chamado.setCliente(cli.get());
		
		List<Profissional> prof = new ArrayList<Profissional>();
		
		for (String item : request.getParameterValues("profissionais")) {						
			
			Optional<Profissional> profissional = profissionalService.buscaProfissional( Integer.parseInt(item));
			prof.add(profissional.get());
			
		} 
		
		chamado.setProfissionais(prof);

		chamadoService.incluir(chamado);
		
		return "redirect:/chamado/lista";
	}
	
	@GetMapping(value= "/chamado/cadastro")
	public String telaCadastro(Model model) {
		
		List<Profissional> profissionais = new ArrayList<Profissional>();
		
		for (Profissional profissional : profissionalService.obterLista()) {
			profissionais.add(profissional);
		}
		
		model.addAttribute("profissionais", profissionais);
		
		model.addAttribute("clientes", clienteService.obterLista());
		
		return "chamado/cadastro";
	}


}
