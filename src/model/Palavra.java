package model;

import java.util.ArrayList;
import java.util.List;

public class Palavra extends ObjetoDominioImpl {
    
	private static LetraFactory letraFactory;
	
	private List<Item> item;
	
	private Tema tema;
	private Letra letra_encoberta;
	private Letra[] palavra;
    
    public static void setLetraFactory(LetraFactory factory) {
    	letraFactory = factory;
    }
    
    public static LetraFactory getLetraFactory() {
		return letraFactory;
    	
    }
    
    public static Palavra criar(Long id, String palavra, Tema tema) {
		Palavra p = new Palavra(id, palavra, tema);
    	return p;
    }
    
    public static Palavra reconstituir(Long id, String palavra, Tema tema) {
    	Palavra p = new Palavra(id, palavra, tema);
    	return p;
    }
    
    //Construtor
    private Palavra(Long id, String palavra, Tema tema) {
    	super(id);
		this.tema = tema;
		this.letra_encoberta = letraFactory.getLetraEncoberta();
		this.letra_encoberta.toString();
		this.palavra = new Letra[palavra.length()];
		
		for(int i = 0; i < palavra.length(); i++) {
			this.palavra[i] = letraFactory.getLetra(palavra.charAt(i));
		}
    }
    
    public Letra[] getLetras() {
		return this.palavra;
    	
    }
    
    public Letra getLetra(int posicao) {
		return this.palavra[posicao];
    }
    
    public void exibir(Object context) {
    	for (int i=0; i < this.palavra.length; i++) {
    		Letra letra = this.palavra[i];
    		letra.exibir(context);
    	}
    }
    
    public void exibir(Object context, boolean posicoes[]) {
    	for(int i = 0; i < posicoes.length; i++) {
    		if(posicoes[i]) {
    			Letra l = this.palavra[i];
    			l.exibir(context);
    		} else {
    			this.letra_encoberta.exibir(context);
    		}
    	}
    }
    
    public int[] tentar(char codigo) {
    	ArrayList<Integer> posicoes  = new ArrayList<Integer>();
    	
    	for(int i = 0; i < this.palavra.length; i++) {
    		if(codigo == this.palavra[i].toString().toUpperCase().charAt(0)) {
    			posicoes.add(i);
    		}
    	}
    	
    	int[] posicoesAcertadas = new int[posicoes.size()];
    	
    	for(int i = 0; i < posicoes.size(); i++) {
    		posicoesAcertadas[i] = posicoes.get(i);
    	}
    	
		return posicoesAcertadas;
    }
    
    public Tema getTema() {
		return this.tema;
    	
    }
    
    public boolean comparar(String palavra) {
		String palavra_teste = "";
		
		for(Letra letra : this.palavra) {
			palavra_teste = palavra_teste.concat(String.valueOf(letra.getCodigo()));
		}
    	
		return palavra_teste.toLowerCase().equals(palavra.toLowerCase());
    }
    
    public int getTamanho() {
		return palavra.length;
    	
    }
    
    public String toString() {
		char[] palavra = new char[this.palavra.length];
		for(int i = 0; i < this.palavra.length; i++) {
			palavra[i] = this.palavra[i].getCodigo();
		}
		
		return String.copyValueOf(palavra);
    }
}
