package factories;

import model.Jogador;
import model.Rodada;

public interface RodadaFactory {
	
	public Rodada getRodada(Jogador jogador);

}
