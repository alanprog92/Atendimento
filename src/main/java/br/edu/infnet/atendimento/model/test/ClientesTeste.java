package br.edu.infnet.atendimento.model.test;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atendimento.model.domain.Clientes;
import br.edu.infnet.atendimento.model.domain.Endereco;
import br.edu.infnet.atendimento.model.service.ClientesService;

@Component
public class ClientesTeste implements ApplicationRunner {
	
	@Autowired
	ClientesService clientesService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String dir = "c:/atendimento/";
		String arq = "clientes.txt";
		
		FileReader filereader = new FileReader(dir+arq);
		BufferedReader leitura = new BufferedReader(filereader);
		
		String linha = leitura.readLine();
		
		while(linha != null) {
			
			try {
				
				String[] campos = linha.split(";");
				
				Clientes c1 = new Clientes();		
				c1.setNome(campos[0]);
				c1.setIdade( Integer.valueOf(campos[1]));
				c1.setSexo(campos[2].charAt(0));
				c1.setCPF(campos[3]);
		        Endereco e1 = new Endereco();
		        e1.setCidade(campos[4]);
		        e1.setCEP( Integer.valueOf(campos[5]));    				
				c1.setResidencial(e1);		    	
				clientesService.incluir(c1);    	
			}catch (Exception e) {
				System.out.println("[ERRO]: "+e.getMessage());
			}
			
			linha = leitura.readLine();
		}
		
		leitura.close();
        
	}

}
