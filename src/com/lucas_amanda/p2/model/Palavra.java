package com.lucas_amanda.p2.model;

import java.io.Serializable;

public class Palavra implements Serializable {
	private static final long serialVersionUID = 1L;
    
    private Long id;
    
    
    public static void setLetraFactory(LetraFactory factory) {
    	
    }
    
    public static LetraFactory getLetraFactory() {
    	
    }
    
    public static Palavra criar(Long id, String palavra, Tema tema) {
    	
    }
    
    public static Palavra reconstituir(Long id, String palavra, Tema tema) {
    	
    }
    
    //Construtor
    private Palavra(Long id, String palavra, Tema tema) {
    	
    }
    
    public Letra[] getLetras() {
    	
    }
    
    public Letra[] getLetra(int posicao) {
    	
    }
    
    public void exibir(Object context) {
    	
    }
    
    public void exibir(Object context, boolean posicoes[]) {
    	
    }
    
    public int[] tentar(char codigo) {
    	
    }
    
    public Tema getTema() {
    	
    }
    
    public boolean comparar(String palavra) {
    	
    }
    
    public int getTamanho() {
    	
    }
    
    public String toString() {
    	
    }
    
}
