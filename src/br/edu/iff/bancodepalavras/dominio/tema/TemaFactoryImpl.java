package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public class TemaFactoryImpl extends EntityFactory implements TemaFactory {

  private static TemaFactoryImpl soleInstance = null;
  
  private TemaFactoryImpl(Repository repository) {
	// TODO Auto-generated constructor stub
	super(repository);	
  }

  public static void createSoleInstance(TemaRepository repository) {
    soleInstance = new TemaFactoryImpl(repository);
  }

  public static TemaFactoryImpl getSoleInstance() {
    if (soleInstance == null) {
    	
      throw new RuntimeException("Fábrica Tema não inicializada!");
    
    }

    return soleInstance;
  }

  private TemaRepository getTemaRepository() {
    return (TemaRepository) getRepository();
  }

  @Override
  public Tema getTema(String nome) {
    
    Tema tema = Tema.criar(getProximoId(), nome);

    try {
    	getTemaRepository().inserir(tema);
    } catch (RepositoryException re) {
    	throw new RuntimeException("Erro ao salvar tema");
    }

    return tema;
  }
}