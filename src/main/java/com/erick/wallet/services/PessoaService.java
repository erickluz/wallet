package com.erick.wallet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.wallet.domain.Pessoa;
import com.erick.wallet.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
	
	public Optional<Pessoa> buscarPessoa(Integer id) {
		return repo.findById(id);
	}
	
	public List<Pessoa> getPessoas(){
		return repo.findAll();
	}
	
	public Pessoa alterarPessoa(Pessoa Pessoa) {
		buscarPessoa(Pessoa.getId());
		return repo.save(Pessoa);
	}
	
	public Pessoa salvarPessoa(Pessoa Pessoa) {
		buscarPessoa(Pessoa.getId());
		return repo.save(Pessoa);
	}

	public void deletarPessoa(Pessoa Pessoa) {
		repo.delete(Pessoa);
	}
}
