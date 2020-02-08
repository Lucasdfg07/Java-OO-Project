package repositories;

public class MemoriaRepositryFactory implements RepositoryFactory {
	
	
	private static MemoriaRepositryFactory soleInstance;
	
	private MemoriaRepositryFactory() {
		
	}
	
	public static MemoriaRepositryFactory getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new MemoriaRepositryFactory();
		
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

}
