package model;

public class LetraTexto extends Letra {
	
	public LetraTexto(char codigo) {
		super(codigo);
	}
	
	public void exibir(Object contexto) {
		System.out.println(this.toString());
	}

}