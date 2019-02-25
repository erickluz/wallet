package com.erick.wallet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.wallet.domain.Cartao;
import com.erick.wallet.repositories.CartaoRepository;

@Service
public class CartaoService {

	@Autowired
	private CartaoRepository repo;
	
	public Optional<Cartao> buscarCartao(Integer id) {
		return repo.findById(id);
	}
	
	public List<Cartao> getCartoes(){
		return repo.findAll();
	}
	
	public Cartao alterarCartao(Cartao cartao) {
		buscarCartao(cartao.getId());
		return repo.save(cartao);
	}
	
	public Cartao salvarCartao(Cartao cartao) {
		buscarCartao(cartao.getId());
		return repo.save(cartao);
	}
	
	public void deletarCartao(Cartao cartao) {
		repo.delete(cartao);
	}
}
