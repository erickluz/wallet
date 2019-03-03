package com.erick.wallet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.wallet.domain.Pessoa;
import com.erick.wallet.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repo;
	
	public Pessoa buscarPessoa(Integer id) {
		return repo.findById(id).orElseThrow(() -> new IllegalStateException("Erro ao buscar pessoa"));
	}
	
	public List<Pessoa> getPessoas(){
		return repo.findAll();
	}
	
	public Pessoa alterarPessoa(Pessoa Pessoa) {
		buscarPessoa(Pessoa.getId());
		return repo.save(Pessoa);
	}
	
	public Pessoa salvarPessoa(Pessoa Pessoa) {
		return repo.save(Pessoa);
	}

	public void deletarPessoa(Pessoa Pessoa) {
		repo.delete(Pessoa);
	}
}
