package com.erick.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.erick.wallet.domain.Conta;
import com.erick.wallet.domain.Usuario;

public interface ContaRepository extends JpaRepository<Conta, Integer>{

	@Transactional(readOnly=true)
	Conta findByUsuarioAndStatus(Usuario usuario, boolean status);
	
}
