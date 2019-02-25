package com.erick.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.wallet.domain.Cartao;

public interface CartaoRepository extends JpaRepository<Cartao, Integer>{

}
