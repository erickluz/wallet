package com.erick.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.wallet.domain.Banco;

public interface BancoRepository extends JpaRepository<Banco, Integer>{

}
