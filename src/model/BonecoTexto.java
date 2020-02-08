package model;

import testes.Main;

public class BonecoTexto implements Boneco {
	
	private static BonecoTexto soleInstance;
	
	public BonecoTexto() {
		
	}
	
	public static BonecoTexto getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BonecoTexto();
		}
		
		return soleInstance;
	}
	
	@Override
	public void exibir(Object contexto, int partes) {
		// TODO Auto-generated method stub
		
		String retorno = new String();
		
		if (partes == 1) {
			retorno = " O ";
		} else if (partes == 2) {
			retorno = " O \n |";
		} else if (partes == 3) {
			retorno = " O \n | \n | ";
		} else if (partes == 4) {
			retorno = " O \n | \n | \n-";
		} else if (partes == 5) {
			retorno = " O \n | \n | \n- -";
		} else if (partes == 6) {
			retorno = " O \n | \n | \n- - \n |";
		} else if (partes == 7) {
			retorno = " O \n | \n | \n- - \n | \n |";
		} else if (partes == 8) {
			retorno = " O \n | \n | \n- - \n | \n | \n |";
		} else if (partes == 9) {
			retorno = " O \n | \n | \n- - \n | \n | \n | \n|";
		} else if (partes == 10) {
			retorno = " O \n | \n | \n- - \n | \n | \n | \n| |";
		}
		
		Main m = new Main();
		m.adicionar(retorno);
		
		System.out.println(retorno);
	}
}
