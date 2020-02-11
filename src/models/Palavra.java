package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import factories.ElementoGraficoFactory;


public class Palavra extends ObjetoDominioImpl {

  private static ElementoGraficoFactory egf;
  
  // Lista de letras
  private List<Letra> palavra;
  private Tema tema;

  public static void setLetraFactory(ElementoGraficoFactory elementoGraficoFactory) {
	  	egf = elementoGraficoFactory;
  }

  public static ElementoGraficoFactory getLetraFactory() {
	  return egf;
  }

  public static Palavra criar(Long id, String palavra, Tema tema) {
	  Palavra p = new Palavra(id, palavra, tema);
	  return p;
  }

  public static Palavra reconstituir(Long id, String palavra, Tema tema) {
	  Palavra p = new Palavra(id, palavra, tema);
	  return p;
  }

  private Palavra(Long id, String palavra, Tema tema) {
      super(id);
      this.tema = tema;
      this.palavra = new ArrayList<>();
      
      ElementoGraficoFactory elementoGrafico = getLetraFactory();

      if (elementoGrafico == null) {
        throw new RuntimeException("Letra Factory não inicializada");
      }

      for (int i = 0; i < palavra.length(); i++) {
        this.palavra.add(
    		elementoGrafico.getLetra(palavra.charAt(i))
    	);
      }
  }

  public List<Letra> getLetras() {
    return Collections.unmodifiableList(this.palavra);
  }

  public Letra getLetra(int posicao) {
    return this.palavra.get(posicao);
  }

  public void exibir(Object contexto) {
	  
    for (Letra l: palavra) {
      l.exibir(null);
    }
    
  }

  public void exibir(Object contexto, List<Boolean> posicoes) {
	  ElementoGraficoFactory letraFactory = getLetraFactory();
	  Letra letra = letraFactory.getLetraEncoberta();
	    
	  if (posicoes.size() != palavra.size()) {
	      throw new RuntimeException("Erro! Posição não é compatível com o tamanho da palavra!");
	  }
	
	  for (int i = 0; i < palavra.size(); i++) {
	      //Sempre passar Null para exibir todos os caracteres encobertos na primeira rodada!
		  if (posicoes.get(i)) {
	        palavra.get(i).exibir(null);
	      } else {
	    	  letra.exibir(null);
	      }
	  }
  }

  public List<Integer> tentar(char codigo) {
	  
    List<Integer> encontradas = new ArrayList<>();

    for (int i = 0; i < palavra.size(); i++) {
    	
      if (palavra.get(i).getCodigo() == codigo) {
    	  encontradas.add(i);
      }
      
    }
    
    return encontradas;
  }

  public Tema getTema() {
	  return this.tema;
  }

  public boolean comparar(String palavra) {
    
	for (int i = 0; i < this.palavra.size(); i++) {
      
		if (this.palavra.get(i).getCodigo() != palavra.charAt(i)) {
			return false;
		}
    }
	
    return true;
  }

  public int getTamanho() {
	  return this.palavra.size();
  }

  @Override
  public String toString() {
	  return palavra + "\n" + tema;
  }
}