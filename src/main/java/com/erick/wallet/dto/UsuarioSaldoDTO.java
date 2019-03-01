package com.erick.wallet.dto;

import java.io.Serializable;

import com.erick.wallet.domain.Usuario;

public class UsuarioSaldoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Double saldo;
	
	public UsuarioSaldoDTO() {
		
	}
	
	public UsuarioSaldoDTO(Usuario usuario) {
		this.saldo = usuario.getContaAtiva().getSaldo();
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	

	
}
