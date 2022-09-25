package br.edu.infnet.atendimento.model.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.atendimento.model.domain.Comercial;
import br.edu.infnet.atendimento.model.domain.Endereco;
import br.edu.infnet.atendimento.model.domain.Usuario;
import br.edu.infnet.atendimento.model.repository.UsuarioRepository;
import br.edu.infnet.atendimento.model.service.ComercialService;
@Component
public class ComercialTeste implements ApplicationRunner {
	
	@Autowired
	ComercialService comercialService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		String dir = "c:/atendimento/";
		String arq = "comercial.txt";
		
		FileReader filereader = new FileReader(dir+arq);
		BufferedReader leitura = new BufferedReader(filereader);
		
		String linha = leitura.readLine();
		
		while(linha != null) {	
			
			try {		
				
				String[] campos = linha.split(";");		
				
		    	Comercial c1 = new Comercial();    	
		    	c1.setNome(campos[0]);
		    	c1.setCPF(campos[1]);
		    	c1.setSexo(campos[2].charAt(0));
		    	c1.setIdade( Integer.parseInt(campos[3]));  	
		    	c1.setBomdevenda(campos[4].charAt(0));
		    	c1.setMetamensal( Double.parseDouble(campos[5]));
		    	c1.setDtultmavenda( LocalDate.now() );
		    	
		        Endereco e1 = new Endereco();
		        e1.setCidade(campos[6]);
		        e1.setCEP( Integer.parseInt(campos[7]));    	
		    	
		        c1.setResidencial(e1);    	
		        
				Usuario usuario = usuarioRepository.validaUsuario("admin@teste.com");
				c1.setUsuario(usuario);
		        
		        comercialService.incluir(c1);
			}catch (Exception e) {
				System.out.println("[ERRO]: "+e.getMessage());
			}
			
			linha = leitura.readLine();
		}
		
		leitura.close();

	}
}
