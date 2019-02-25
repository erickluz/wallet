package com.erick.wallet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.wallet.domain.Conta;
import com.erick.wallet.repositories.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository repo;

	public Optional<Conta> buscarConta(Integer id) {
		return repo.findById(id);
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
	
}
