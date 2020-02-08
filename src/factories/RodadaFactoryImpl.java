package factories;

import model.Rodada;
import repositories.PalavraRepository;
import repositories.RodadaRepository;
import repositories.TemaRepository;

public abstract class RodadaFactoryImpl implements RodadaFactory {
	
	protected static RodadaRepository repository;
	protected static TemaRepository temaRepository;
	protected static PalavraRepository palavraRepository;
	
	protected Rodada rodada;
	
	protected RodadaFactoryImpl(RodadaRepository repository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		RodadaFactoryImpl.repository = repository;
		RodadaFactoryImpl.temaRepository = temaRepository;
		RodadaFactoryImpl.palavraRepository = palavraRepository;
		
	}

	protected RodadaRepository getRodadaRepository() {
		return repository;
	}
	
	protected TemaRepository getTemaRepository() {
		return temaRepository;
	}
	
	protected PalavraRepository getPalavraRepository() {
		return palavraRepository;
	}
	
	

}
