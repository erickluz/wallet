package com.erick.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.wallet.domain.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer>{

}
