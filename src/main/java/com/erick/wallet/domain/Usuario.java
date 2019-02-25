package com.erick.wallet.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity // Alteracao aqui
public class Usuario extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String tipo; // Mudar para o tipo TipoUsuario
	
	public Usuario() {
		
	}

	public Usuario(Integer id, String nome, String cpfOuCnpj, String login, String senha, String numeroCartao, String tipo) {
		super(id, nome, cpfOuCnpj, login, senha);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
