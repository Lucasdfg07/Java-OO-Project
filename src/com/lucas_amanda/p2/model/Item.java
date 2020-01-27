package com.lucas_amanda.p2.model;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private boolean[] posicoesDescobertas;
    
    private String palavraArriscada;
    
    
    private static Item criar(int id, Palavra palavra) {
    	
    }
    
    public static Item reconstituir(int id, Palavra palavra, int[] posicoesDescobertas, String palavraArriscada) {
    	
    }
    
    private Item(int id, Palavra palavra) {
    	
    }
    
    private Item(int id, Palavra palavra, int[] posicoesDescobertas, String palavraArriscada) {
    	
    }
    
    public Palavra getPalavra() {
    	
    }
    
    public Letra[] getLetrasDescobertas() {
    	
    }
    
    public Letra[] getLetrasEncobertas() {
    	
    }
    
    public int qtdeLetrasEncobertas() {
    	
    }
    
    public int calcularPontosLetrasEncobertas(int valorPorLetraEncoberta) {
    	
    }
    
    public boolean descobriu() {
    	
    }
    
    public void exibir(Object context) {
    	
    }
    
    private boolean tentar(char codigo) {
    	
    }
    
    private void arriscar(String palavra) {
    	
    }
    
    public String getPalavraArriscada() {
    	
    }
    
    public boolean arriscou() {
    	
    }
    
    public boolean acertou() {
    	
    }
}
