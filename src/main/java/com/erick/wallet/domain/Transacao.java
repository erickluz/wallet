package com.erick.wallet.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Transacao implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Double valor;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="dd/MM/yyyy HH:mm")
	private Date data;
	
	private String numeroContaOrigem;
	private String numeroContaDestino;
	private String operacao; //Alterar o tipo para OperacaoTransacao
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="conta_id")
	private Conta conta;
	
	@OneToOne(mappedBy="transacao")
	private PagamentoDeBoleto pagamentoDeBoleto;
	
	public Transacao() {
		
	}

	public Transacao(Integer id, Double valor, Date data, String numeroContaOrigem, String numeroContaDestino,
			String operacao) {
		super();
		this.id = id;
		this.valor = valor;
		this.data = data;
		this.numeroContaOrigem = numeroContaOrigem;
		this.numeroContaDestino = numeroContaDestino;
		this.operacao = operacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public PagamentoDeBoleto getPagamentoDeBoleto() {
		return pagamentoDeBoleto;
	}

	public void setPagamentoDeBoleto(PagamentoDeBoleto pagamentoDeBoleto) {
		this.pagamentoDeBoleto = pagamentoDeBoleto;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNumeroContaOrigem() {
		return numeroContaOrigem;
	}

	public void setNumeroContaOrigem(String numeroContaOrigem) {
		this.numeroContaOrigem = numeroContaOrigem;
	}

	public String getNumeroContaDestino() {
		return numeroContaDestino;
	}

	public void setNumeroContaDestino(String numeroContaDestino) {
		this.numeroContaDestino = numeroContaDestino;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transacao other = (Transacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	

}
