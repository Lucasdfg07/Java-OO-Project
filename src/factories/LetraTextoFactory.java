package factories;

import models.Letra;
import models.LetraTexto;

public class LetraTextoFactory extends LetraFactoryImpl {
  
  private static LetraTextoFactory soleInstance;

  public static LetraTextoFactory getSoleInstance() {
	  
    if (soleInstance == null) {
    	
    	soleInstance = new LetraTextoFactory();
    }

    return soleInstance;
  }

  private LetraTextoFactory() {
	  
  }

  protected Letra criarLetra(char codigo) {
	
    return new LetraTexto(codigo);
  }
}