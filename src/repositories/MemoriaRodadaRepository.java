package repositories;

import java.util.HashMap;
import model.Jogador;
import model.Rodada;



public class MemoriaRodadaRepository implements RodadaRepository {
	
	
	private static MemoriaRodadaRepository soleInstance;
	private HashMap<Long, Rodada> pool = new HashMap<Long, Rodada>();
	private Rodada[] resultados;
	
	private MemoriaRodadaRepository() {
		
	}
	
	public static MemoriaRodadaRepository getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new MemoriaRodadaRepository();
		
		return soleInstance;	
	}

	@Override
	public long getProximoId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Rodada getPorId(long id) {
		
		return pool.get(id);
	}

	@Override
	public Rodada[] getPorJogador(Jogador jogador) {
		resultados = null;
		
		int i=0;
		
		for (Rodada r : pool.values()) {
			if(r.getJogador().equals(jogador))
				resultados[i] = r;
				i++;
		    }
		
		return resultados;
	}
	

	@Override
	public void inserir(Rodada rodada) throws RepositoryException {
		this.pool.put(rodada.getId(), rodada);

	}

	@Override
	public void atualizar(Rodada rodada) throws RepositoryException {
		this.pool.remove(rodada.getId());
		this.pool.put(rodada.getId(), rodada);

	}

	@Override
	public void remover(Rodada rodada) throws RepositoryException {
		this.pool.remove(rodada.getId());

	}

}
