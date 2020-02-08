package factories;

import model.Letra;
import model.LetraImagem;

public class LetraImagemFactory extends LetraFactoryImpl {
	
private static LetraImagemFactory soleInstance;
	
	private LetraImagemFactory() {
		
	}
	
	public static LetraImagemFactory getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new LetraImagemFactory();
		
		return soleInstance;
	}
	
	protected Letra criarLetra(char codigo) {
		return new LetraImagem(codigo);
		
	}

}
