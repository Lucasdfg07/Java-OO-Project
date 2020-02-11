package models;

import java.util.ArrayList;
import java.util.List;

public class Item extends ObjetoDominioImpl {
    
	private List<Boolean> posicoesDescobertas;
  	private String palavraArriscada = null;
  	private Palavra palavra;

  	static Item criar(int id, Palavra palavra) {
  		Item item = new Item(id, palavra);
  		return item;
  	}

  	public static Item reconstituir(int id, Palavra palavra, List<Integer> posicoesDescobertas, String palavraArriscada) {
  		Item item = new Item(id, palavra, posicoesDescobertas, palavraArriscada);
  		return item;
  	}

  	private Item(int id, Palavra palavra) {
  		super(Long.valueOf(id));
  		
  		this.palavra = palavra;
  		
  		this.posicoesDescobertas = new ArrayList<>(palavra.getTamanho());
  		
  		int i;
  		
  		for (i = 0; i < palavra.getTamanho(); i++) {
  			boolean identificador = false;
  			this.posicoesDescobertas.add(identificador);
  		}
  	}

  	private Item(int id, Palavra palavra, List<Integer> posicoesDescobertas, String palavraArriscada) {
  		super(Long.valueOf(id));
  		
  		this.palavra = palavra;
  		this.palavraArriscada = palavraArriscada;
  		
  		this.posicoesDescobertas = new ArrayList<>(palavra.getTamanho());
  		
  		for (Integer i: posicoesDescobertas) {
  			boolean identificador = true;
  			this.posicoesDescobertas.add(i, identificador);
  		}
  	}

  	public Palavra getPalavra() {
  		return this.palavra;
  	}

  public List<Letra> getLetrasDescobertas() {
	  List<Letra> descobertas = new ArrayList<>();

	  for (int i = 0; i < posicoesDescobertas.size(); i++) {
		  if (posicoesDescobertas.get(i)) {
			  descobertas.add(palavra.getLetra(i));
		  }
	  }

	  return descobertas;
  }

  public List<Letra> getLetrasEncobertas() {
	  List<Letra> palavrasEncobertas = new ArrayList<>();

	  for (int i = 0; i < posicoesDescobertas.size(); i++) {
		  if (posicoesDescobertas.get(i) == false) {
			  palavrasEncobertas.add(palavra.getLetra(i));
		  }
	  }

	  return palavrasEncobertas;
  }

  public int qtdeLetrasEncobertas() {
	  return getLetrasEncobertas().size();
  }

  public int calcularPontosLetrasEncobertas(int valorPorLetraEncoberta) {
	  return valorPorLetraEncoberta * qtdeLetrasEncobertas();
  }
  
  public boolean descobriu() {
	  return acertou();
  }
  
  public void exibir(Object contexto) {
	  palavra.exibir(contexto, posicoesDescobertas);
  }
  
  boolean tentar(char codigo) {
	  List<Integer> posicoes = palavra.tentar(codigo);

	  if (posicoes.size() == 0) {
		  return false; 
	  }
    
	  for (Integer p: posicoes) {
		  posicoesDescobertas.set(p, true);
	  }

	  return true;
  }
  
  void arriscar(String palavra) {
	  this.palavraArriscada = palavra;
  }
  
  public String getPalavraArriscada() {
	  return this.palavraArriscada;
  }

  public boolean arriscou() {
	  return palavraArriscada != null;
  }

  public boolean acertou() {
	  return (this.palavraArriscada != null) && (this.palavra.comparar(this.palavraArriscada));
  }
  
}