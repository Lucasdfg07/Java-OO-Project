package model;

import java.util.HashSet;
import java.util.Iterator;

public class Item extends ObjetoDominioImpl{
    
    private Long id;
    
    private boolean[] posicoesDescobertas;
    
    private String palavraArriscada;
    
    private Palavra palavra;
    
    
    static Item criar(Long id, Palavra palavra) {
		Item i = new Item(id, palavra);
		
		return i;
    }
    
    static Item reconstituir(Long id, Palavra palavra, boolean[] posicoesDescobertas, String palavraArriscada) {
    	Item i = new Item(id, palavra, posicoesDescobertas, palavraArriscada);
		
		return i;	
    }
    
    private Item(Long id, Palavra palavra) {
    	super(id);
    	this.palavra = palavra;
    }
    
    private Item(Long id, Palavra palavra, boolean[] posicoesDescobertas, String palavraArriscada) {
    	super(id);
    	this.palavra = palavra;
		this.posicoesDescobertas = posicoesDescobertas;
		this.palavraArriscada = palavraArriscada;
    }
    
    public Palavra getPalavra() {
		return this.palavra;
    	
    }
    
    public Letra[] getLetrasDescobertas() {
		return this.getStatusLetra(true);
    	
    }
    
    public Letra[] getLetrasEncobertas() {
    	return this.getStatusLetra(false);
    	
    }
    
    public int qtdeLetrasEncobertas() {
    	int quantidade = 0;
    	
    	// Faz um "for" até o número de letras encobertas. 
    	// Se a posição descoberta for false, então itera a quantidade
		for(int i = 0; i < this.posicoesDescobertas.length; i++) {
			if (!this.posicoesDescobertas[i]) {
				quantidade++;
			}
		}	
		
		return quantidade;
    }
    
    // Lembrando:
    // Pontos por letra encoberta: 15
    public int calcularPontosLetrasEncobertas(int valorPorLetraEncoberta) {
		return valorPorLetraEncoberta * this.qtdeLetrasEncobertas();
    	
    }
    
    public boolean descobriu() {
		return this.acertou();
    }
    
    public void exibir(Object context) {
    	this.palavra.exibir(context, posicoesDescobertas);
    }
    
    boolean tentar(char codigo) {
		int[] acertos = this.palavra.tentar(codigo);
		
		for(int i = 0; i < acertos.length; i++) {
			this.posicoesDescobertas[acertos[i]] = true;
		}
		
		return acertos.length > 0;
    }
    
    // Salva palavra Arriscada em lower case se a mesma não for = null
    void arriscar(String palavra) {
    	if (this.arriscou())
    		this.palavraArriscada = palavra.toLowerCase();
    }
    
    public String getPalavraArriscada() {
		return this.palavraArriscada;
    	
    }
    
    public boolean arriscou() {
    	return this.palavraArriscada != null;
    }
    
    public boolean acertou() {
    	return (this.palavraArriscada != null) && (this.palavra.comparar(this.palavraArriscada));
    	
    }
    
    private Letra[] getStatusLetra(Boolean status) {
		HashSet<Letra> escolhidas = new HashSet<Letra>();
		
		for(int i = 0; i < this.palavra.getTamanho(); i++) {
			if(this.posicoesDescobertas[i] == status) {
				escolhidas.add(this.palavra.getLetra(i));
			}
		}	
		
		
		Letra[] letrasEscolhidas = new Letra[escolhidas.size()];
		Iterator<Letra> it = escolhidas.iterator();
		
		int i = 0;
		
		while(it.hasNext()) {
			letrasEscolhidas[i] = it.next();
			i++;
		}
		
		return letrasEscolhidas;
	}

}
