package services;

import application.Aplicacao;
import factories.PalavraFactory;
import factories.TemaFactory;
import models.Palavra;
import models.Tema;
import repositories.PalavraRepository;
import repositories.RepositoryException;

public class PalavraAppService {
	
    private static PalavraAppService soleInstance;

    private PalavraRepository repository;
    private PalavraFactory factory;

    private PalavraAppService(PalavraRepository repository, PalavraFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    public static void createSoleInstance(PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
        soleInstance = new PalavraAppService(palavraRepository, palavraFactory);
    }

    public static PalavraAppService getSoleInstance() {
        if(soleInstance == null) {
            soleInstance = new PalavraAppService(null, null);
          }

        return soleInstance;
    }

    public boolean novaPalavra(String palavra) throws RepositoryException{
        Palavra auxPalavra = repository.getPalavra(palavra);
        Aplicacao aplicacao = Aplicacao.getSoleInstance();
        if (auxPalavra == null) {
            try {
                TemaFactory temaFactory = aplicacao.getTemaFactory();
                Tema tema = temaFactory.getTema("Geral");
                Palavra novaPalavra = factory.getPalavra(palavra, tema);
                repository.inserir(novaPalavra);
                return true;
            } catch (Exception e) {
                System.out.print(e.getMessage());
                return false;
            }
        }
        return true;
    }
}