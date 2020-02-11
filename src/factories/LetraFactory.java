package factories;

import models.Letra;

public interface LetraFactory {

  public Letra getLetra(char codigo);
  public Letra getLetraEncoberta();
  
}