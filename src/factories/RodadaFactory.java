package factories;

import models.Jogador;
import models.Rodada;

public interface RodadaFactory {
	
  public Rodada getRodada(Jogador jogador);

}