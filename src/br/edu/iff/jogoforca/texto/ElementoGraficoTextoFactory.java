package br.edu.iff.jogoforca.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.texto.LetraTextoFactory;
import br.edu.iff.jogoforca.ElementoGraficoFactory;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.texto.BonecoTextoFactory;

public class ElementoGraficoTextoFactory implements ElementoGraficoFactory {

  private static ElementoGraficoTextoFactory soleInstance;
  
  private BonecoTextoFactory boneco;
  private LetraTextoFactory letra;

  private ElementoGraficoTextoFactory() {
	  letra = LetraTextoFactory.getSoleInstance();
	  boneco = BonecoTextoFactory.getSoleInstance();
  }

  public static ElementoGraficoTextoFactory getSoleInstance() {
	  
    if (soleInstance == null) {
      soleInstance = new ElementoGraficoTextoFactory();
    }

    return soleInstance;
  }

  public Boneco getBoneco() {
    return boneco.getBoneco();
  }

  public Letra getLetra(char codigo) {
    return letra.getLetra(codigo);
  }

  @Override
  public Letra getLetraEncoberta() {
    return letra.getLetraEncoberta();
  }

}