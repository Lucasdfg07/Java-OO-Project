package services;

import model.Palavra;
import factories.PalavraFactory;
import repositories.PalavraRepository;
import repositories.RepositoryException;

public class PalavraAppService {
	
	private static PalavraAppService soleInstance;
	
	private PalavraRepository palavraRepository;
	private PalavraFactory palavraFactory;
	
	private PalavraAppService(PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
		this.palavraRepository = palavraRepository;
		this.palavraFactory = palavraFactory;
	}
	
	public static void createSoleInstance(PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
		soleInstance = new PalavraAppService(palavraRepository, palavraFactory);
	}
	
	public static PalavraAppService getSoleInstance() {
		if(soleInstance == null) 
			soleInstance = new PalavraAppService(null, null);
		
		return soleInstance;
	}
	
	public void novaPalavra(Palavra palavra) throws RepositoryException{
		try {
			palavraRepository.inserir(palavra);	
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
