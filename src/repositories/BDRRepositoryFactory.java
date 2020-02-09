package repositories;

import factories.PalavraFactory;

public class BDRRepositoryFactory implements RepositoryFactory {

	private static BDRRepositoryFactory soleInstance;
	
	private BDRRepositoryFactory() {}
	
	public static BDRRepositoryFactory getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BDRRepositoryFactory();
		}
		return soleInstance;
	}
	
	@Override
	public JogadorRepository getJogadorRepository() {
		return BDRJogadorRepository.getSoleInstance();
	}

	@Override
	public RodadaRepository getRodadaRepository() {
		return BDRRodadaRepository.getSoleInstance();
	}

	@Override
	public TemaRepository getTemaRepository() {
		return BDRTemaRepository.getSoleInstance();
	}

	@Override
	public PalavraRepository getPalavraRepository() {
		return BDRPalavraRepository.getSoleInstance();
	}

	@Override
	public PalavraFactory getPalavraFactory() {
		// TODO Auto-generated method stub
		return null;
	}
}
