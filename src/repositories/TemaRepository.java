package repositories;

import model.Tema;

public interface TemaRepository extends Repository {
	
	public Tema getPorId(long id);
	public Tema[] getPorNome(Tema tema);
	public Tema[] getTodas();
	public void inserir(Tema tema) throws RepositoryException;
	public void atualizar(Tema tema) throws RepositoryException;
	public void remover(Tema tema) throws RepositoryException;

}
