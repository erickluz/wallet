package com.erick.wallet.domain.enums;

public enum TipoUsuario {

	ADMINISTRADOR(1), CLIENTE(2);

	private Integer cod; 
	
	private TipoUsuario(Integer cod) {
		this.cod = cod;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}
	
	public static TipoUsuario toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(TipoUsuario x : TipoUsuario.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id invalido: " + cod);
	}
	
}
