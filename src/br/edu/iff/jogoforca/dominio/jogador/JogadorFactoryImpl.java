package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

public class JogadorFactoryImpl extends EntityFactory implements JogadorFactory {
  
  private static JogadorFactoryImpl soleInstance;
  
  private JogadorFactoryImpl(JogadorRepository repository) {
    super(repository);
    
  }

  public static JogadorFactoryImpl getSoleInstance() {
	  
    if (soleInstance == null) {
      throw new RuntimeException("Erro! Jogador Factory não foi inicializada.");
    }

    return soleInstance;
  }
  
  public static void createSoleInstance(JogadorRepository repository) {
    soleInstance = new JogadorFactoryImpl(repository);
  }

  private JogadorRepository getJogadorRepository() {
    return (JogadorRepository) getRepository();
  }

  @Override
  public Jogador getJogador(String nome) {
	  
    Jogador j1 = Jogador.criar(getProximoId(), nome);

    try {
      getJogadorRepository().inserir(j1);
    } catch (RepositoryException repositoryException) {
      throw new RuntimeException("Erro! Jogador não foi salvo no repository.");
    }

    return j1;
  }
}