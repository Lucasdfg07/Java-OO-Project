package services;

import model.Jogador;
import model.Palavra;
import model.Rodada;
import factories.PalavraFactory;
import factories.RodadaFactory;
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
	
	public void createSoleInstance(PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
		
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
