package br.edu.infnet.atendimento.model.test;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atendimento.model.domain.Endereco;
import br.edu.infnet.atendimento.model.domain.Programador;
import br.edu.infnet.atendimento.model.service.ProgramadorService;

@Component
public class ProgramadorTeste implements ApplicationRunner {
	
	@Autowired
	ProgramadorService programadorService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		
		String dir = "c:/atendimento/";
		String arq = "programador.txt";
		
		FileReader filereader = new FileReader(dir+arq);
		BufferedReader leitura = new BufferedReader(filereader);
		
		String linha = leitura.readLine();
		
		while(linha != null) {	
			
			try {		
				
				String[] campos = linha.split(";");			
		    	Programador p1 = new Programador();    	
		    	p1.setNome(campos[0]);
		    	p1.setCPF(campos[1]);
		    	p1.setSexo(campos[2].charAt(0));
		    	p1.setIdade(Integer.parseInt(campos[3]));  	
		    	p1.setLinguagem(campos[4]);
		    	p1.setSabeoo(campos[5].charAt(0));
		    	p1.setBebecafe(campos[6].charAt(0));    	   	
		        Endereco e1 = new Endereco();
		        e1.setCidade(campos[7]);
		        e1.setCEP(Integer.parseInt(campos[8]));    	    	
		        p1.setResidencial(e1);    	
		        programadorService.incluir(p1);
			}catch (Exception e) {
				System.out.println("[ERRO]: "+e.getMessage());
			}
			
			linha = leitura.readLine();
		}
		
		leitura.close();

	}

}
