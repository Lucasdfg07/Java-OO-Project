package repositories;

import model.Jogador;
import model.Rodada;

public class BDRRodadaRepository implements RodadaRepository {

	private static BDRRodadaRepository soleInstance;
	
	private BDRRodadaRepository() {}
	
	public static BDRRodadaRepository getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BDRRodadaRepository();
		}
		return soleInstance;
	}
	
	@Override
	public void remover(Rodada rodada) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Rodada rodada) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inserir(Rodada rodada) throws RepositoryException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rodada[] getPorJogador(Jogador jogador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rodada getPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getProximoId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
