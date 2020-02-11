package repositories;

import java.util.List;

import models.Tema;

public class BDRTemaRepository implements TemaRepository {
  
  private static BDRTemaRepository soleInstance = null;

  public static BDRTemaRepository getSoleInstance() {
    
    if (soleInstance == null) {
      soleInstance = new BDRTemaRepository();
    }

    return soleInstance;
  }

  private BDRTemaRepository() {
  }

  @Override
  public long getProximoId() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Tema getPorId(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Tema> getPorNome(String nome) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Tema> getTodos() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void inserir(Tema tema) throws RepositoryException {
    // TODO Auto-generated method stub

  }

  @Override
  public void atualizar(Tema tema) throws RepositoryException {
    // TODO Auto-generated method stub

  }

  @Override
  public void remover(Tema tema) throws RepositoryException {
    // TODO Auto-generated method stub

  }
}