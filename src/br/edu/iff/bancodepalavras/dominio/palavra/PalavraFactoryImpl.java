package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

public class PalavraFactoryImpl extends EntityFactory implements PalavraFactory {

  private static PalavraFactoryImpl soleInstance;
  
  public static void createSoleInstance(PalavraRepository repository) {
	  soleInstance = new PalavraFactoryImpl(repository);
  }

  public static PalavraFactoryImpl getSoleInstance() {
	  
    if (soleInstance == null) {
      throw new RuntimeException("Palavra Factory não foi iniciado!");
    }

    return soleInstance;
  }

  private PalavraFactoryImpl(PalavraRepository repository) {
    super(repository);
  }

  private PalavraRepository getPalavraRepository() {
	  
    return (PalavraRepository) getRepository();
  
  }

  @Override
  public Palavra getPalavra(String palavra, Tema tema) {
    Palavra aux = Palavra.criar(getProximoId(), palavra, tema);

    try {
      getPalavraRepository().inserir(aux);
    } catch (RepositoryException repositoryException) {
      throw new RuntimeException("Erro! Palavra não foi salva no Repository!");
    }

    return aux;
  }
  
}