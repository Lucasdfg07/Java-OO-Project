package factories;

import model.Letra;
import model.Tema;

public interface PalavraFactory {
	
	public Letra[] getPalavra(String palavra, Tema tema);

}
