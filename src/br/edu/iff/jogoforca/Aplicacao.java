package br.edu.iff.jogoforca;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactoryImpl;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactoryImpl;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactoryImpl;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactory;
import br.edu.iff.jogoforca.dominio.rodada.sorteio.RodadaSorteioFactory;
import br.edu.iff.jogoforca.emmemoria.MemoriaRepositoryFactory;
import br.edu.iff.jogoforca.texto.ElementoGraficoTextoFactory;

public class Aplicacao {
    private final static String[] TIPOS_REPOSITORY_FACTORY = { "memoria", "relacional" };
    private final static String[] TIPOS_ELEMENTO_GRAFICO_FACTORY = { "texto", "imagem" };
    private final static String[] TIPOS_RODADA_FACTORY = { "sorteio" };
    private String tipoRepositoryFactory = TIPOS_REPOSITORY_FACTORY[0];
    private String tipoElementoGraficoFactory = TIPOS_ELEMENTO_GRAFICO_FACTORY[0];
    private String tipoRodadaFactory = TIPOS_RODADA_FACTORY[0];

    private MemoriaRepositoryFactory repo;
    private ElementoGraficoFactory egf;
    private RodadaFactory rodada;

    private static Aplicacao soleInstance = null;

    public static Aplicacao getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new Aplicacao();
        }	

        return soleInstance;
    }

    private Aplicacao() {
        setup();
    }

    public void setup() {
        if (tipoRepositoryFactory.equals(TIPOS_REPOSITORY_FACTORY[0]) &&
    		tipoElementoGraficoFactory.equals(TIPOS_ELEMENTO_GRAFICO_FACTORY[0]) &&
    		tipoRodadaFactory.equals(TIPOS_RODADA_FACTORY[0])) {
        	
        	repo = MemoriaRepositoryFactory.getSoleInstance();
        	egf = ElementoGraficoTextoFactory.getSoleInstance();
            
            RodadaSorteioFactory.createSoleInstance(repo.getRodadaRepository(), repo.getTemaRepository(), repo.getPalavraRepository());
            rodada = RodadaSorteioFactory.getSoleInstance();
        }

        TemaFactoryImpl.createSoleInstance(repo.getTemaRepository());
        PalavraFactoryImpl.createSoleInstance(repo.getPalavraRepository());
        JogadorFactoryImpl.createSoleInstance(repo.getJogadorRepository());
        
        Palavra.setLetraFactory(egf);
        Rodada.setBonecoFactory(egf);
    }

    public String[] getTiposRepositoryFactory() {
        return TIPOS_REPOSITORY_FACTORY;
    }

    public void setTipoRepositoryFactory(String tipo) {
    	setup();
    	tipoRepositoryFactory = tipo;
    }

    public RepositoryFactory getRepositoryFactory() {
        return repo;
    }

    public String[] getTiposElementoGraficoFactory() {
        return TIPOS_ELEMENTO_GRAFICO_FACTORY;
    }

    public void setTipoElementoGraficoFactory(String tipo) {
    	setup();
        tipoElementoGraficoFactory = tipo;
    }

    public ElementoGraficoFactory getElementoGraficoFactory() {
        return egf;
    }

    public String[] getTiposRodadaFactory() {
        return TIPOS_RODADA_FACTORY;
    }

    public void setTipoRodadaFactory(String tipo) {
    	setup();
        tipoRodadaFactory = tipo;
    }

    public RodadaFactory getRodadaFactory() {
        return rodada;
    }

    public TemaFactory getTemaFactory() {
        return TemaFactoryImpl.getSoleInstance();
    }

    public PalavraFactory getPalavraFactory() {
        return PalavraFactoryImpl.getSoleInstance();
    }

    public JogadorFactory getJogadorFactory() {
        return JogadorFactoryImpl.getSoleInstance();
    }
}