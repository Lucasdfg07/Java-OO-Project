package factories;

import model.Jogador;
import repositories.JogadorRepository;
import repositories.Repository;

public class JogadorFactoryImpl extends EntityFactory implements JogadorFactory {
	
	private static JogadorFactoryImpl soleInstance;
	private JogadorRepository jogadorRepository;

	private JogadorFactoryImpl(Repository repository) {
		super(repository);
		
	}
	
	public static JogadorFactoryImpl getSoleInstance() {
		if(soleInstance == null )
			soleInstance = new JogadorFactoryImpl(repository);
		
		return soleInstance;
	}
	
	public static void createSoleInstance(JogadorRepository repository) {
	}
	
	
	
	@SuppressWarnings("unused")
	private JogadorFactory getJogadorFactory() {
		return null;
	}

	@Override
	public Jogador getJogador(String nome) {
		return null;
	}

}
