package com.erick.wallet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.wallet.domain.Usuario;
import com.erick.wallet.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	public Usuario buscarUsuario(Integer id) {
		return repo.findById(id).orElseThrow(() -> new IllegalStateException("Erro ao buscar usuario"));
	}
	
	public List<Usuario> getUsuarios(){
		return repo.findAll();
	}
	
	public Usuario alterarUsuario(Usuario Usuario) {
		buscarUsuario(Usuario.getId());
		return repo.save(Usuario);
	}
	
	public Usuario salvarUsuario(Usuario Usuario) {
		buscarUsuario(Usuario.getId());
		return repo.save(Usuario);
	}

	public void deletarUsuario(Usuario Usuario) {
		repo.delete(Usuario);
	}
	
	
}
