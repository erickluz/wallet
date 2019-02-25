package com.erick.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.wallet.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
