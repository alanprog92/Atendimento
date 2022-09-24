package br.edu.infnet.atendimento.model.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atendimento.model.domain.Chamado;
import br.edu.infnet.atendimento.model.domain.Clientes;
import br.edu.infnet.atendimento.model.domain.Comercial;
import br.edu.infnet.atendimento.model.domain.Endereco;
import br.edu.infnet.atendimento.model.domain.Profissional;
import br.edu.infnet.atendimento.model.exceptions.ClienteChamadoVazio;
import br.edu.infnet.atendimento.model.service.ChamadoService;

@Component
public class ChamadoTeste implements ApplicationRunner {
	
	@Autowired
	ChamadoService chamadoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		List<Profissional> profissionais = new ArrayList<>();

        Endereco end1 = new Endereco();
        end1.setCidade("BOA ESPERANCA");
        end1.setCEP(37170000);  		
    	Comercial comercial1 = new Comercial("HENRRIQUE", "1234567890", 'M', 23, end1, LocalDate.now(), 1000, 'S');    	

        Endereco end2 = new Endereco();
        end2.setCidade("BOA ESPERANCA");
        end2.setCEP(37170000);  		
    	Comercial comercial2 = new Comercial("LIDIANE", "64674637683", 'F', 30, end2, LocalDate.now(), 1000, 'S');    	

        Endereco end3 = new Endereco();
        end3.setCidade("BOA ESPERANCA");
        end3.setCEP(37170000);  		
    	Comercial comercial3 = new Comercial("DENISE", "7845467363", 'F', 40, end3, LocalDate.now(), 1000, 'S');    	
    	
		profissionais.add(comercial1);
		profissionais.add(comercial2);
		profissionais.add(comercial3);
		
		
		
		String dir = "c:/atendimento/";
		String arq = "chamado.txt";
		
		FileReader filereader = new FileReader(dir+arq);
		BufferedReader leitura = new BufferedReader(filereader);
		
		String linha = leitura.readLine();
		
		while(linha != null) {
			
			try {
				
					String[] campos = linha.split(";");		
					
					LocalDate dataini = LocalDate.parse(campos[8], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
					LocalDate datafim = LocalDate.parse(campos[9], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			        Endereco e1 = new Endereco();
			        e1.setCidade(campos[0]);
			        e1.setCEP( Integer.parseInt(campos[1]));    						
					Clientes c1 = new Clientes(campos[2], Integer.parseInt(campos[3]), campos[4].charAt(0), campos[5], e1);			

					Chamado chamado1 = new Chamado(c1);    	
			    	chamado1.setId(Integer.parseInt(campos[6]));
			    	chamado1.setProblema(campos[7]);
			    	chamado1.setDataini(dataini);
			    	chamado1.setDatafim(datafim);
			    	chamado1.setSolucao(campos[10]);    
			    	chamado1.setProfissionais(profissionais);
			    	chamadoService.incluir(chamado1);
				}catch (ClienteChamadoVazio e) {
					System.out.println("[ERRO] : "+e.getMessage());
				}catch (Exception e) {
					System.out.println("[ERRO] : "+e.getMessage());
				}
    	
		        linha = leitura.readLine();
	    }
	
	leitura.close();	
		
		
		
	}
}
