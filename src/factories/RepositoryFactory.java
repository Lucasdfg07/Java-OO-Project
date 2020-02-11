package factories;

import repositories.JogadorRepository;
import repositories.PalavraRepository;
import repositories.RodadaRepository;
import repositories.TemaRepository;

public interface RepositoryFactory {
	
  public PalavraRepository getPalavraRepository();
  public TemaRepository getTemaRepository();
  public RodadaRepository getRodadaRepository();
  public JogadorRepository getJogadorRepository();
}