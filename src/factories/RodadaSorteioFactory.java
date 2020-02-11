package factories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import models.Jogador;
import models.Palavra;
import models.Rodada;
import models.Tema;
import repositories.PalavraRepository;
import repositories.RepositoryException;
import repositories.RodadaRepository;
import repositories.TemaRepository;

public class RodadaSorteioFactory extends RodadaFactoryImpl {

	
	private static RodadaSorteioFactory soleInstance;

	
	private RodadaSorteioFactory(RodadaRepository repository, TemaRepository temaRepository, PalavraRepository palavraRepository) {	
		super(repository, temaRepository, palavraRepository);
	}

	
    public static void createSoleInstance(RodadaRepository repository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
    	// TODO Auto-generated method stub
    	soleInstance = new RodadaSorteioFactory(repository, temaRepository, palavraRepository);
    }

    public static RodadaSorteioFactory getSoleInstance() {
        if (soleInstance == null) {
        	
            throw new RuntimeException("Sorteio Factory não inicializado!");
        }

        return soleInstance;
    }

    @Override
    public Rodada getRodada(Jogador jogador) {
        Random numeroRandomico = new Random();
        List<Palavra> sorteioPalavra = new ArrayList();
        
        List<Tema> temas = getTemaRepository().getTodos();
        Tema sorteioTema = temas.get(numeroRandomico.nextInt(temas.size()));
        
        List<Palavra> palavras = getPalavraRepository().getPorTema(sorteioTema);
        
        Palavra auxPalavra = null;
        
        while (sorteioPalavra.size() != 3) {
            auxPalavra = palavras.get(numeroRandomico.nextInt(palavras.size()));
            
            if (!sorteioPalavra.contains(auxPalavra) 
        		&& sorteioPalavra.size() != 3) {
            	
            	sorteioPalavra.add(auxPalavra);
            }
        }

        Rodada r = Rodada.criar(getProximoId(), sorteioPalavra, jogador);

        try{
          getRodadaRepository().inserir(r);
        } catch (RepositoryException repositoryException) {
          throw new RuntimeException("Erro em salvar rodada!");
        }

        return r;
    }

  
}