package br.edu.infnet.atendimento.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import com.google.gson.Gson;

import br.edu.infnet.atendimento.model.domain.Chamado;
import br.edu.infnet.atendimento.model.domain.Clientes;
import br.edu.infnet.atendimento.model.domain.Comercial;
import br.edu.infnet.atendimento.model.domain.Profissional;
import br.edu.infnet.atendimento.model.domain.Programador;
import br.edu.infnet.atendimento.model.domain.Suporte;
import br.edu.infnet.atendimento.model.service.ChamadoService;
import br.edu.infnet.atendimento.model.service.ClientesService;
import br.edu.infnet.atendimento.model.service.ComercialService;
import br.edu.infnet.atendimento.model.service.ProgramadorService;
import br.edu.infnet.atendimento.model.service.SuporteService;

@Controller
public class ChamadoController {
	
	@Autowired
	ChamadoService chamadoService;
	
	@Autowired
	ClientesService clienteService;
	
	@Autowired
	ProgramadorService programadorService;	
	
	@Autowired
	SuporteService suporteService;
	
	@Autowired
	ComercialService comercialService;	
	
	@GetMapping(value= "/chamado/lista")
	public String telaLista(Model model) {
		
		model.addAttribute("listagem", chamadoService.obterLista());
		
		return "chamado/lista";
	}
	
	@GetMapping(value= "/chamado/{id}/excluir")
	public String exclusao(@PathVariable Integer id) {
		
		chamadoService.excluir(id);
		
		return "redirect:/chamado/lista";
	}
	
	@PostMapping(value= "/chamado/cadastro")
	public String inclusao(Model model, WebRequest request) {
		
		String dataini = request.getParameterValues("dataini")[0];
		String datafim = request.getParameterValues("datafim")[0];
		String problema = request.getParameterValues("problema")[0];
		String solucao = request.getParameterValues("solucao")[0];
		String cliente = request.getParameterValues("cliente")[0];
		String pessoa = request.getParameterValues("profissional")[0];
		 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate datainiaux = LocalDate.parse(dataini,formatter);
		
		LocalDate datafimaux = LocalDate.parse(datafim,formatter);

		Chamado chamado = new Chamado();
		chamado.setDataini( datainiaux );
		chamado.setDatafim( datafimaux );
		chamado.setProblema(problema);
		chamado.setSolucao(solucao);
		
		Clientes cli = clienteService.buscaCliente( Integer.parseInt(cliente) );
		chamado.setCliente(cli);
		
		// List<Profissional> profissionais = new ArrayList<Profissional>();
		/*for (String item : request.getParameterValues("profissionais")) {						

			Gson gson = new Gson();
			
			if(item.substring(0, 1).equalsIgnoreCase("P")) {
				String itemAux = item.replace("Programador ", "");
				Programador prog = gson.fromJson(itemAux, Programador.class);		
				System.out.println(prog);
			}
			
		} */

		chamadoService.incluir(chamado);
		
		return "redirect:/chamado/lista";
	}
	
	@GetMapping(value= "/chamado/cadastro")
	public String telaCadastro(Model model) {
		
		List<Profissional> profissionais = new ArrayList<Profissional>();

		for (Programador programador : programadorService.obterLista()) {
			profissionais.add(programador);
		}
		
		for (Suporte suporte : suporteService.obterLista()) {
			profissionais.add(suporte);
		}
		
		for (Comercial comercial : comercialService.obterLista()) {
			profissionais.add(comercial);
		}
		
		model.addAttribute("profissionais", profissionais);
		
		model.addAttribute("clientes", clienteService.obterLista());
		
		return "chamado/cadastro";
	}


}
