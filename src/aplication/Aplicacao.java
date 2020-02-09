package aplication;

import factories.ElementoGraficoFactory;
import factories.ElementoGraficoImagemFactory;
import factories.ElementoGraficoTextoFactory;
import factories.JogadorFactory;
import factories.JogadorFactoryImpl;
import factories.PalavraFactory;
import factories.PalavraFactoryImpl;
import factories.RodadaFactory;
import factories.RodadaSorteioFactory;
import factories.TemaFactory;
import factories.TemaFactoryImpl;
import model.Palavra;
import model.Rodada;
import repositories.BDRRepositoryFactory;
import repositories.MemoriaRepositoryFactory;
import repositories.RepositoryFactory;
import services.PalavraAppService;

public class Aplicacao {
	
	private final String[] TIPOS_REPOSITORY_FACTORY = {"memoria", "relacional"};
	private final String[] TIPOS_ELEMENTO_GRAFICO_FACTORY = {"texto","imagem"};
	private final String[] TIPOS_RODADA_FACTORY = {"sorteio"};
	
	private static Aplicacao soleInstance;
	
	private String tipoRepositoryFactory = TIPOS_REPOSITORY_FACTORY[0];
	private String tipoElementoGraficoFactory = TIPOS_ELEMENTO_GRAFICO_FACTORY[0];
	private String tipoRodadaFactory = TIPOS_RODADA_FACTORY[0];
	
	private Aplicacao() {
		
	}
	
	public static Aplicacao getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new Aplicacao();
		
		return soleInstance;
	}
	
	public void setup() {
		RepositoryFactory repo = this.getRepositoryFactory();
		
		TemaFactoryImpl.createSoleInstance(repo.getTemaRepository());
		
		PalavraFactoryImpl.createSoleInstance(repo.getPalavraRepository());
		
		JogadorFactoryImpl.createSoleInstance(repo.getJogadorRepository());
		
		RodadaSorteioFactory.createSoleInstance(repo.getRodadaRepository(), repo.getPalavraRepository(), repo.getTemaRepository());
		
		PalavraAppService.createSoleInstance(repo.getPalavraRepository(), repo.getPalavraFactory());
		
		ElementoGraficoFactory elemento = this.getElementoGraficoFactory();
		
		Palavra.setLetraFactory(elemento);
		
		Rodada.setBonecoFactory(elemento);
	}
	
	public String[] getTiposRepositoryFactory() {
		return TIPOS_REPOSITORY_FACTORY;
	}
	
	public void setTipoRepositoryFactory(String tipo) {
		this.setup();
		this.tipoRepositoryFactory = tipo;
	}
	
	public RepositoryFactory getRepositoryFactory() {
		RepositoryFactory factory = null;
		
		String tipo = this.tipoRepositoryFactory;
		
		if (tipo.equals("memoria")) {
			factory = MemoriaRepositoryFactory.getSoleInstance();
		} else {
			factory = BDRRepositoryFactory.getSoleInstance();
		}
		
		return factory;
	}
	
	public String[] getTiposElementoGraficoFactory() {
		return TIPOS_ELEMENTO_GRAFICO_FACTORY;
	}
	
	public void setTipoElementoGraficoFactory(String stipo) {
		this.setup();
		this.tipoElementoGraficoFactory = stipo;
	}
	
	public ElementoGraficoFactory getElementoGraficoFactory() {
		ElementoGraficoFactory factory = null;
		
		String tipo = this.tipoElementoGraficoFactory;
		
		if(tipo.equals("texto")) {
			factory = ElementoGraficoTextoFactory.getSoleInstance();
		} else {
			factory = ElementoGraficoImagemFactory.getSoleInstance();
		}
		
		return factory;
	}
	
	public String[] getTiposRodadaFactory() {
		return TIPOS_RODADA_FACTORY;
	}
	
	public void setTipoRodadaFactory(String tipo) {
		this.setup();
		tipoRodadaFactory = tipo;
	}
	
	public RodadaFactory getRodadaFactory() {
		RodadaFactory factory = null;
		
		if (this.tipoRodadaFactory.equals("sorteio")) {
			factory = RodadaSorteioFactory.getSoleInstance();
		};
		
		return factory;
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
