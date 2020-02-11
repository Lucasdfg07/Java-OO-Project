package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.factory.EntityFactory;

public abstract class RodadaFactoryImpl extends EntityFactory implements RodadaFactory {
  
  private TemaRepository temaRepo;
  private PalavraRepository palavraRepo;
  

  protected RodadaFactoryImpl(RodadaRepository repository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
    super(repository);
    
    this.temaRepo = temaRepository;
    this.palavraRepo = palavraRepository;
  }

  protected RodadaRepository getRodadaRepository() {
    return (RodadaRepository) getRepository();
  }

  protected TemaRepository getTemaRepository() {
    return temaRepo;
  }

  protected PalavraRepository getPalavraRepository() {
    return palavraRepo;
  }
}