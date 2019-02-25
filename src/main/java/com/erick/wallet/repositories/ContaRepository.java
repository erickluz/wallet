package com.erick.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.wallet.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Integer>{

}
