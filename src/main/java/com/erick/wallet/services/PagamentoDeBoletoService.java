package com.erick.wallet.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erick.wallet.domain.PagamentoDeBoleto;
import com.erick.wallet.repositories.PagamentoDeBoletoRepository;

@Service
public class PagamentoDeBoletoService {

	@Autowired
	private PagamentoDeBoletoRepository repo; 
	
	public Optional<PagamentoDeBoleto> buscarPagamentoDeBoleto(Integer id) {
		return repo.findById(id);
	}
	
	public List<PagamentoDeBoleto> getPagamentoDeBoletos(){
		return repo.findAll();
	}
	
	public PagamentoDeBoleto alterarPagamentoDeBoleto(PagamentoDeBoleto PagamentoDeBoleto) {
		buscarPagamentoDeBoleto(PagamentoDeBoleto.getId());
		return repo.save(PagamentoDeBoleto);
	}
	
	public PagamentoDeBoleto salvarPagamentoDeBoleto(PagamentoDeBoleto PagamentoDeBoleto) {
		buscarPagamentoDeBoleto(PagamentoDeBoleto.getId());
		return repo.save(PagamentoDeBoleto);
	}

	public void deletarPagamentoDeBoleto(PagamentoDeBoleto PagamentoDeBoleto) {
		repo.delete(PagamentoDeBoleto);
	}
	
}
