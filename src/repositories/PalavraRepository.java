package repositories;

import java.util.List;

import models.Palavra;
import models.Tema;


public interface PalavraRepository extends Repository {

  public Palavra getPorId(long id);
  
  public List<Palavra> getPorTema(Tema tema);
  
  public List<Palavra> getTodas();
  
  public Palavra getPalavra(String palavra);
  
  public void inserir(Palavra palavra) throws RepositoryException;
  
  public void atualizar(Palavra palavra) throws RepositoryException;
  
  public void remover(Palavra palavra) throws RepositoryException;
}