package factories;

import model.Jogador;
import model.Rodada;

public interface RodadaFactory {
	
	public int getRodada(Jogador[] retorno);
	public int getRodada(Jogador retorno);

}
