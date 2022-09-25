package br.edu.infnet.atendimento.model.test;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.atendimento.model.domain.Usuario;
import br.edu.infnet.atendimento.model.service.UsuarioService;

@Component
@Order(1)
public class UsuarioTeste implements ApplicationRunner {
	
	@Autowired
	UsuarioService usuarioService;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String dir = "c:/atendimento/";
		String arq = "usuarios.txt";
		
		FileReader filereader = new FileReader(dir+arq);
		BufferedReader leitura = new BufferedReader(filereader);
		
		String linha = leitura.readLine();
		
		while(linha != null) {
			
			try {
				
				String[] campos = linha.split(";");
				
				Usuario u1 = new Usuario();		
				u1.setNome(campos[0]);
				u1.setEmail(campos[1]);
				u1.setSenha(campos[2]);	    	
				usuarioService.incluir(u1);    	
			}catch (Exception e) {
				System.out.println("[ERRO]: "+e.getMessage());
			}
			
			linha = leitura.readLine();
		}
		
		leitura.close();
        
	}

}
