package factories;

import models.Boneco;
import models.Letra;

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