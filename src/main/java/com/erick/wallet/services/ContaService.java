package com.erick.wallet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.wallet.domain.Conta;
import com.erick.wallet.domain.Usuario;
import com.erick.wallet.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repo;
	
	@Autowired
	private UsuarioService usuarioService;

	public Conta buscarConta(Integer id) {
		return repo.findById(id).orElseThrow(() -> new IllegalStateException("Erro ao buscar usuario"));
	}
	
	public List<Conta> getContas(){
		return repo.findAll();
	}
	
	public Conta alterarConta(Conta conta) {
		buscarConta(conta.getId());
		return repo.save(conta);
	}
	
	public Conta salvarConta(Conta conta) {
		buscarConta(conta.getId());
		return repo.save(conta);
	}
	
	public void deletarConta(Conta conta) {
		repo.delete(conta);
	}

	public Conta buscarContaPorUsuario(Integer id) {
		Usuario usu = usuarioService.buscarUsuario(id);
		return repo.findByUsuarioAndStatus(usu, true);
	}
	
}
