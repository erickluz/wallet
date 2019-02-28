package com.erick.wallet.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity // Alteracao aqui
public class Usuario extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String tipo; // Mudar para o tipo TipoUsuario
	
	@ManyToOne
	@JoinColumn(name="banco_id")
	private Banco banco;
	
	@OneToMany(mappedBy="usuario")
	private Conta conta;
	
	@OneToMany(mappedBy="usuario")
	private Cartao cartao;
		
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

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	
}
