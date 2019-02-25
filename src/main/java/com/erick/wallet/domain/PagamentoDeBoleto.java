package com.erick.wallet.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PagamentoDeBoleto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String numeroBoleto;
	
	public PagamentoDeBoleto() {
		
	}

	public PagamentoDeBoleto(Integer id, String numeroBoleto) {
		super();
		this.id = id;
		this.numeroBoleto = numeroBoleto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumeroBoleto() {
		return numeroBoleto;
	}

	public void setNumeroBoleto(String numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
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
		PagamentoDeBoleto other = (PagamentoDeBoleto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
