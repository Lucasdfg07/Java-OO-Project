package repositories;

import model.Jogador;

public interface JogadorRepository extends Repository {
	
	public Jogador getPorId(long id);
	public Jogador getPorNome(String nome);
	public void inserir(Jogador jogador) throws RepositoryException;
	public void atualizar(Jogador jogador) throws RepositoryException;
	public void remover(Jogador jogador) throws RepositoryException;

}
