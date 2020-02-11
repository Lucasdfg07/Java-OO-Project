package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class BonecoTexto implements Boneco {

  private static BonecoTexto soleInstance = null;

  	public static BonecoTexto getSoleInstance() {
	  
	  if (soleInstance == null) {
		  soleInstance = new BonecoTexto();
	  }

	  return soleInstance;
  	}

  	private BonecoTexto() {
	  
  	}

  @Override
  public void exibir(Object contexto, int partes) {
	// TODO Auto-generated method stub
		
	String retorno = new String();
	
	if (partes == 1) {
		retorno = "CABECA";
	} else if (partes == 2) {
		retorno = "CABECA, OLHO ESQ";
	} else if (partes == 3) {
		retorno = "CABECA, OLHO ESQ, OLHO DIR";
	} else if (partes == 4) {
		retorno = "CABECA, OLHO ESQ, OLHO DIR, NARIZ";
	} else if (partes == 5) {
		retorno = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA";
	} else if (partes == 6) {
		retorno = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA, TRONCO";
	} else if (partes == 7) {
		retorno = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA, TRONCO, BRAÇO ESQ";
	} else if (partes == 8) {
		retorno = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA, TRONCO, BRAÇO ESQ, BRAÇO DIR";
	} else if (partes == 9) {
		retorno = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA, TRONCO, BRAÇO ESQ, BRAÇO DIR, PERNA ESQ";
	} else if (partes == 10) {
		retorno = "CABECA, OLHO ESQ, OLHO DIR, NARIZ, BOCA, TRONCO, BRAÇO ESQ, BRAÇO DIR, PERNA ESQ, PERNA DIR";
	}
	
	System.out.println(retorno);
  }
}