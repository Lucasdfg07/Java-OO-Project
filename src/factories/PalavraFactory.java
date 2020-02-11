package factories;

import models.Palavra;
import models.Tema;

public interface PalavraFactory {

  public Palavra getPalavra(String palavra, Tema tema);
  
}