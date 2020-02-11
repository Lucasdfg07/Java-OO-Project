package br.edu.iff.jogoforca.imagem;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.imagem.LetraImagemFactory;
import br.edu.iff.jogoforca.ElementoGraficoFactory;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.imagem.BonecoImagemFactory;

public class ElementoGraficoImagemFactory implements ElementoGraficoFactory {
  
  private static ElementoGraficoImagemFactory soleInstance = null;
  
  private BonecoImagemFactory boneco;
  private LetraImagemFactory letra;

  public static ElementoGraficoImagemFactory getSoleInstance() {
	  
    if (soleInstance == null) {
      soleInstance = new ElementoGraficoImagemFactory();
    }

    return soleInstance;
  }

  private ElementoGraficoImagemFactory() {
	  boneco = BonecoImagemFactory.getSoleInstance();
	  
	  letra = LetraImagemFactory.getSoleInstance();
  }

  @Override
  public Boneco getBoneco() {
      return boneco.getBoneco();
  }

  @Override
  public Letra getLetra(char codigo) {
      return letra.getLetra(codigo);
  }

  @Override
  public Letra getLetraEncoberta() {
      return letra.getLetraEncoberta();
  }
}