package repositories;

import factories.PalavraFactory;

public interface RepositoryFactory {
	
	public PalavraRepository getPalavraRepository();
	public TemaRepository getTemaRepository();
	public RodadaRepository getRodadaRepository();
	public JogadorRepository getJogadorRepository();
	public PalavraFactory getPalavraFactory();

}
