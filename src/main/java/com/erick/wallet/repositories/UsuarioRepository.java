package com.erick.wallet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.erick.wallet.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
