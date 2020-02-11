package repositories;

import java.util.List;

import models.Jogador;
import models.Rodada;

public interface RodadaRepository extends Repository {

  public Rodada getPorId(Long id);

  public List<Rodada> getPorJogador(Jogador jogador);

  public void inserir(Rodada rodada) throws RepositoryException;

  public void atualizar(Rodada rodada) throws RepositoryException;
  
  public void remover(Rodada rodada) throws RepositoryException;
}