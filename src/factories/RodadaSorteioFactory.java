package factories;

import model.Jogador;
import model.Rodada;
import repositories.PalavraRepository;
import repositories.RodadaRepository;
import repositories.TemaRepository;

public class RodadaSorteioFactory extends RodadaFactoryImpl {
	
	private static RodadaSorteioFactory soleInstance;

	private RodadaSorteioFactory(RodadaRepository repository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		super(repository, temaRepository, palavraRepository);
	}
	
	public static void createSoleInstance(RodadaRepository repository, TemaRepository temaRepository)
	{			
		new RodadaSorteioFactory(repository, temaRepository, palavraRepository);
	}
	
	public static RodadaSorteioFactory getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new RodadaSorteioFactory(repository, temaRepository, palavraRepository);
		
		return soleInstance;
	}
	
	public Rodada getRodada(Jogador jogador) {
		return null;
	}

}
