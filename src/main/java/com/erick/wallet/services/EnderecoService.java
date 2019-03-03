package com.erick.wallet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.wallet.domain.Endereco;
import com.erick.wallet.repositories.EnderecoRepository;

@Service
public class EnderecoService{

	@Autowired
	private EnderecoRepository repo;
	
	public Endereco buscarEndereco(Integer id) {
		return repo.findById(id).orElseThrow(() -> new IllegalStateException("Erro ao buscar endereco"));
	}
	
	public List<Endereco> getEnderecos(){
		return repo.findAll();
	}
	
	public Endereco alterarEndereco(Endereco endereco) {
		buscarEndereco(endereco.getId());
		return repo.save(endereco);
	}
	
	public Endereco salvarEndereco(Endereco endereco) {
		return repo.save(endereco);
	}

	public void deletarEndereco(Endereco endereco) {
		repo.delete(endereco);
	}
	
}
