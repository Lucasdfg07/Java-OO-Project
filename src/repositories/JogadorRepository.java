package repositories;

import models.Jogador;

public interface JogadorRepository extends Repository {

  public Jogador getPorId(Long id);

  public Jogador getPorNome(String nome);

  public void inserir(Jogador jogador) throws RepositoryException;

  public void atualizar(Jogador jogador) throws RepositoryException;
  
  public void remover(Jogador jogador) throws RepositoryException;
}