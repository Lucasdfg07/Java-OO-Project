package aplication;

import factories.ElementoGraficoFactory;
import factories.JogadorFactory;
import factories.PalavraFactory;
import factories.RodadaFactory;
import factories.TemaFactory;
import repositories.RepositoryFactory;

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
		
	}
	
	public String[] getTiposRepositoryFactory() {
		return TIPOS_REPOSITORY_FACTORY;
	}
	
	public void setTipoRepositoryFactory(String tipo) {
		this.tipoRepositoryFactory = tipo;
		
	}
	
	public RepositoryFactory getRepositoryFactory() {
		return null;
	}
	
	public String[] getTiposElementoGraficoFactory() {
		return TIPOS_ELEMENTO_GRAFICO_FACTORY;
	}
	
	public void setTipoElementoGraficoFactory(String stipo) {
		this.tipoElementoGraficoFactory = stipo;
	}
	
	public ElementoGraficoFactory getElementoGraficoFactory() {
		return null;
	}
	
	public String[] getTiposRodadaFactory() {
		return TIPOS_RODADA_FACTORY;
	}
	
	public void setTipoRodadaFactory(String tipo) {
		tipoRodadaFactory = tipo;
	}
	
	public RodadaFactory getRodadaFactory() {
		return null;
	}
	
	public TemaFactory getTemaFactory() {
		return null;
	}
	
	public PalavraFactory getPalavraFactory() {
		return null;
	}
	
	public JogadorFactory getJogadorFactory() {
		return null;
	}
}
