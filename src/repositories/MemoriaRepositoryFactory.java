package repositories;

import factories.PalavraFactory;

public class MemoriaRepositoryFactory implements RepositoryFactory {
	
	
	private static MemoriaRepositoryFactory soleInstance;
	
	private MemoriaRepositoryFactory() {
		
	}
	
	public static MemoriaRepositoryFactory getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new MemoriaRepositoryFactory();
		
		return soleInstance;	
	}

	@Override
	public PalavraRepository getPalavraRepository() {
		// TODO Auto-generated method stub
		return MemoriaPalavraRepository.getSoleInstance();
	}

	@Override
	public TemaRepository getTemaRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RodadaRepository getRodadaRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JogadorRepository getJogadorRepository() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PalavraFactory getPalavraFactory() {
		// TODO Auto-generated method stub
		return null;
	}

}
