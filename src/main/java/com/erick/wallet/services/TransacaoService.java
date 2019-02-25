package com.erick.wallet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.wallet.domain.Transacao;
import com.erick.wallet.repositories.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository repo;
	
	public Optional<Transacao> buscarTransacao(Integer id) {
		return repo.findById(id);
	}
	
	public List<Transacao> getTransacaos(){
		return repo.findAll();
	}
	
	public Transacao alterarTransacao(Transacao Transacao) {
		buscarTransacao(Transacao.getId());
		return repo.save(Transacao);
	}
	
	public Transacao salvarTransacao(Transacao Transacao) {
		buscarTransacao(Transacao.getId());
		return repo.save(Transacao);
	}

	public void deletarTransacao(Transacao Transacao) {
		repo.delete(Transacao);
	}
	
	
}
