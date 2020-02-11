package factories;

import models.Boneco;
import models.Letra;

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