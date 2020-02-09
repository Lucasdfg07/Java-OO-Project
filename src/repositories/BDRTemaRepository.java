package repositories;

import model.Tema;

public class BDRTemaRepository implements TemaRepository {

	private static BDRTemaRepository soleInstance;
	
	private BDRTemaRepository() {}
	
	public static BDRTemaRepository getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BDRTemaRepository();
		}
		return soleInstance;
	}

	
	@Override
	public void remover(Tema tema) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Tema tema) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserir(Tema tema) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tema getPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getProximoId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Tema[] getPorNome(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Tema[] getTodas() {
		// TODO Auto-generated method stub
		return null;
	}
}
