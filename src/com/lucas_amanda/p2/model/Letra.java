package com.lucas_amanda.p2.model;

import java.io.Serializable;

public abstract class Letra implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private char codigo;
	
	protected Letra(char codigo) {
		
	}

	public char getCodigo() {
		
	}
	
	public abstract void exibir(Object contexto) {
		
	}
	
	public boolean equals(Object o) {
	
		if (!(o instanceof Letra)) return false;
		
		Letra outra = (Letra) o;
		
		return this.codigo == outra.codigo && this.getClass().equals(outra.getClass());
	}
	
	public int hashcode() {
		return this.char+this.getClass().hashCode();
		
	}
	
	public String final toString() {
		
	}

}
