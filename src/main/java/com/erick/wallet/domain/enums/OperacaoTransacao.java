package com.erick.wallet.domain.enums;

public enum OperacaoTransacao {
	CREDITO(1), DEBITO(2), TRANSFERENCIA(3);

	private Integer cod; 
	
	private OperacaoTransacao(Integer cod) {
		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public static OperacaoTransacao toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(OperacaoTransacao x : OperacaoTransacao.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido: " + cod);
	}

}
