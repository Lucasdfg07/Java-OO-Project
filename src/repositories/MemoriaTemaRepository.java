package repositories;

import model.Tema;

public class MemoriaTemaRepository implements TemaRepository {
	
	private static MemoriaTemaRepository soleInstance;
	
	private MemoriaTemaRepository() {
		
	}
	
	public static MemoriaTemaRepository getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new MemoriaTemaRepository();
		
		return soleInstance;	
	}

	@Override
	public long getProximoId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tema getPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tema[] getPorNome(Tema tema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tema[] getTodas() {
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
