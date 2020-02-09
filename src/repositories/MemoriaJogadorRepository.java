package repositories;

import java.util.HashMap;
import model.Jogador;
import model.Rodada;

public class MemoriaJogadorRepository implements JogadorRepository {
	
	
	private static MemoriaJogadorRepository soleInstance;
	
	private HashMap<Long, Jogador> pool = new HashMap<Long, Jogador>();
	
	private Jogador[] jogador;
	
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
		return pool.get(id);
	}

	@Override
	public Jogador[] getPorNome(String nome) {
		// TODO Auto-generated method stub
		jogador = null;
		
		int i=0;
		
		for (Jogador r : pool.values()) {
			if(r.getNome().equals(nome))
				jogador[i] = r;
				i++;
		    }
		
		return jogador;
	}

	@Override
	public void inserir(Jogador jogador) throws RepositoryException {
		// TODO Auto-generated method stub
		this.pool.put(jogador.getId(), jogador);
	}

	@Override
	public void atualizar(Jogador jogador) throws RepositoryException {
		// TODO Auto-generated method stub
		this.pool.remove(jogador.getId());
		this.pool.put(jogador.getId(), jogador);
	}

	@Override
	public void remover(Jogador jogador) throws RepositoryException {
		// TODO Auto-generated method stub
		this.pool.remove(jogador.getId());
	}

}
