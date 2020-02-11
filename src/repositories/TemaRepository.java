package repositories;

import java.util.List;

import models.Tema;

public interface TemaRepository extends Repository {

  public Tema getPorId(Long id);

  public List<Tema> getPorNome(String nome);

  public List<Tema> getTodos();

  public void inserir(Tema tema) throws RepositoryException;

  public void atualizar(Tema tema) throws RepositoryException;
  
  public void remover(Tema tema) throws RepositoryException;
}