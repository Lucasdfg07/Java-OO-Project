package factories;

import model.Jogador;
import model.Rodada;
import repositories.PalavraRepository;
import repositories.RodadaRepository;
import repositories.TemaRepository;

public class RodadaSorteioFactory extends RodadaFactoryImpl {
	
	private Rodada r;
	
	private static RodadaSorteioFactory soleInstance;

	private RodadaSorteioFactory(RodadaRepository repository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		super(repository, temaRepository, palavraRepository);
	}
	
	public static void createSoleInstance(RodadaRepository rodadaRepository, PalavraRepository palavraRepository, TemaRepository temaRepository) {
		// TODO Auto-generated method stub
		soleInstance = new RodadaSorteioFactory(repository, temaRepository, palavraRepository);
	}
	
	public static RodadaSorteioFactory getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new RodadaSorteioFactory(repository, temaRepository, palavraRepository);
		
		return soleInstance;
	}
	
	public int getRodada(Jogador jogador) {
		return r.getQtdeTentativas();
	}

	@Override
	public int getRodada(Jogador[] retorno) {
		// TODO Auto-generated method stub
		return 0;
	}

}
