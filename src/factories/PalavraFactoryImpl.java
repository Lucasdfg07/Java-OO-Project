package factories;

import model.Letra;
import model.Palavra;
import model.Tema;
import repositories.PalavraRepository;
import repositories.Repository;

public class PalavraFactoryImpl extends EntityFactory implements PalavraFactory {

	private static PalavraFactoryImpl soleInstance;
	private PalavraRepository palavraRepository;
	
	private Palavra p;
	
	protected PalavraFactoryImpl(Repository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}
	
	public static PalavraFactoryImpl getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new PalavraFactoryImpl(repository);
		
		return soleInstance;
	}
	
	public static void createSoleInstance(PalavraRepository repository) {
	}
	
	@SuppressWarnings("unused")
	private PalavraRepository getPalavraRepository() {
		return palavraRepository;
		
	}

	@Override
	public Letra[] getPalavra(String palavra, Tema tema) {
		return p.getLetras();
	}

}
