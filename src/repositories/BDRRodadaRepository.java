package repositories;

import java.util.List;

import models.Jogador;
import models.Rodada;

public class BDRRodadaRepository implements RodadaRepository {
  
  private static BDRRodadaRepository soleInstance = null;

  public static BDRRodadaRepository getSoleInstance() {
    if (soleInstance == null) {
      soleInstance = new BDRRodadaRepository();
    }

    return soleInstance;
  }

  private BDRRodadaRepository() {
  }

  @Override
  public long getProximoId() {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public Rodada getPorId(Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Rodada> getPorJogador(Jogador jogador) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void inserir(Rodada rodada) throws RepositoryException {
    // TODO Auto-generated method stub

  }

  @Override
  public void atualizar(Rodada rodada) throws RepositoryException {
    // TODO Auto-generated method stub

  }

  @Override
  public void remover(Rodada rodada) throws RepositoryException {
    // TODO Auto-generated method stub

  }

 
}