package factories;

import repositories.JogadorRepository;
import repositories.MemoriaJogadorRepository;
import repositories.MemoriaPalavraRepository;
import repositories.MemoriaRodadaRepository;
import repositories.MemoriaTemaRepository;
import repositories.PalavraRepository;
import repositories.RodadaRepository;
import repositories.TemaRepository;

public class MemoriaRepositoryFactory implements RepositoryFactory {

  private static MemoriaRepositoryFactory soleInstance;

  private MemoriaRepositoryFactory() {
	  
  }

  public static MemoriaRepositoryFactory getSoleInstance() {
	  
    if (soleInstance == null) {
      soleInstance = new MemoriaRepositoryFactory();
    }
    
    
    return soleInstance;
  }

  public PalavraRepository getPalavraRepository() {
    return MemoriaPalavraRepository.getSoleInstance();
  }

  
  public TemaRepository getTemaRepository() {
    return MemoriaTemaRepository.getSoleInstance();
  }

  
  public RodadaRepository getRodadaRepository() {
    return MemoriaRodadaRepository.getSoleInstance();
  }

  
  public JogadorRepository getJogadorRepository() {
    return MemoriaJogadorRepository.getSoleInstance();
  }

}