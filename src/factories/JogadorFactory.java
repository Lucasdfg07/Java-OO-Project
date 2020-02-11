package factories;

import models.Jogador;

public interface JogadorFactory {
	
  public Jogador getJogador(String nome);
  
}