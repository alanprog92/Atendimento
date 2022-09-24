package br.edu.infnet.atendimento.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.atendimento.model.domain.Usuario;
import br.edu.infnet.atendimento.model.repository.UsuarioRepository;
import br.edu.infnet.atendimento.model.test.AppImpressao;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public void incluir(Usuario usuario) {
		
		usuarioRepository.save(usuario);
		
		AppImpressao.relatorio("Inclusão do Usuário ", usuario);
		
	}
	
	public Collection<Usuario> obterLista(){
		return (Collection<Usuario>) usuarioRepository.findAll();
	}
	
	public void excluir(Integer id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario validar(String email, String senha) {
		Usuario usuario = usuarioRepository.validaUsuario(email);
		if( usuario != null && usuario.getSenha().equals(senha)) {
			return usuario;
		}
		return null;
	}
	
	
}
