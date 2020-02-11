package factories;

import models.Letra;
import models.LetraImagem;

public class LetraImagemFactory extends LetraFactoryImpl {
  
  private static LetraImagemFactory soleInstance;

  public static LetraImagemFactory getSoleInstance() {
	  
    if (soleInstance == null) {
      soleInstance = new LetraImagemFactory();
    }
 
    return soleInstance;
  }

  private LetraImagemFactory() {
	  
  }

  protected Letra criarLetra(char codigo) {
    return new LetraImagem(codigo);
  }
}