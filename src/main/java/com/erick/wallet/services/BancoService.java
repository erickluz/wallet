package com.erick.wallet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.wallet.domain.Banco;
import com.erick.wallet.repositories.BancoRepository;

@Service
public class BancoService {

	@Autowired
	private BancoRepository repo;
	
	public Optional<Banco> getBanco(Integer id) {
		return repo.findById(id);
	}
	
	public List<Banco> getBancos(){
		return repo.findAll();
	}
	
	public Banco alterarBanco(Banco banco) {
		getBanco(banco.getId());
		return repo.save(banco);
	}
	
	public Banco salvarBanco(Banco banco) {
		getBanco(banco.getId());
		return repo.save(banco);
	}
	
	public void deletarBanco(Banco banco) {
		repo.delete(banco);
	}
	
}