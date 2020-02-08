package repositories;

import java.util.HashMap;
import java.util.Iterator;

import model.Palavra;
import model.Tema;

public class MemoriaPalavraRepository implements PalavraRepository {
	
	private static MemoriaPalavraRepository soleInstance;
	
	private HashMap<Long, Palavra> pool = new HashMap<Long, Palavra>();
	
	private MemoriaPalavraRepository() {
		
	}
	
	public static MemoriaPalavraRepository getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new MemoriaPalavraRepository();
		
		return soleInstance;	
	}

	@Override
	public long getProximoId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Palavra getPorId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Palavra[] getPorTema(Tema tema) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Palavra[] getTodas() {
		return (Palavra[]) this.pool.values().toArray();
	}

	@Override
	public Palavra getPalavra(String palavra) {
		Palavra resultado = null;
		
		Iterator<Palavra> palavras = this.pool.values().iterator();
		
		while(palavras.hasNext()) {
			Palavra p = palavras.next();
			
			if(p.comparar(palavra)) {
				resultado = p;
				break;
			}
		}
		
		return resultado;
	}

	@Override
	public void inserir(Palavra palavra) throws RepositoryException {
		try {
			if(!pool.containsValue(palavra))
				this.pool.put(palavra.getId(), palavra);
			
		} catch(Exception e){
			
			e.getMessage();
			
			System.out.println("Palavra ja existe");
		}
		

	}

	@Override
	public void atualizar(Palavra palavra) throws RepositoryException {
		remover(palavra);
		inserir(palavra);
	}


	@Override
	public void remover(Palavra palavra) throws RepositoryException {
		this.pool.remove(palavra.getId());
	}

}
