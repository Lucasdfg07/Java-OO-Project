package repositories;

import model.Jogador;

public class MemoriaJogadorRepository implements JogadorRepository {
	
	
private static MemoriaJogadorRepository soleInstance;
	
	private MemoriaJogadorRepository() {
		
	}
	
	public static MemoriaJogadorRepository getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new MemoriaJogadorRepository();
		
		return soleInstance;	
	}

	@Override
	public long getProximoId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Jogador getPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Jogador getPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Jogador jogador) throws RepositoryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void atualizar(Jogador jogador) throws RepositoryException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Jogador jogador) throws RepositoryException {
		// TODO Auto-generated method stub

	}

}
