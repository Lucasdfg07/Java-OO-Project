package com.lucas_amanda.p2.model;

import java.io.Serializable;

public class Rodada implements Serializable {
	private static final long serialVersionUID = 1L;
    
    private static Long id;
    
    private static int maxPalavras = 3;
    
    private static int maxErros = 10;
    
    private static int pontosQuandoDescobreTodasAsPalavras = 100;
    
    private static int pontosPorLetraEncoberta = 15;
    
    public static int getMaxPalavras() {
    	
    }
    
    public static void setMaxPalavras(int max) {
    	
    }
    
    public static int getMaxErros() {
    	
    }
    
    public static void setMaxErros(int max) {
    	
    }
    
    public static int getPontosQuandoDescobreTodasAsPalavras() {
    	
    }
    
    public static void setPontosQuandoDescobreTodasAsPalavras(int pontos) {
    	
    }
    
    public static int getPontosPorLetraEncoberta() {
    	
    }
    
    public static void setPontosPorLetraEncoberta(int pontos) {
    	
    }
    
    public static void setBonecoFactory(BonecoFactory bonecoFactory) {
    	
    }
    
    public static BonecoFactory getBonecoFactory() {
    	
    }
    
    public static Rodada criar(Long id, Palavra[] palavra, Jogador jogador) {
    	
    }
    
    public static Rodada reconstituir(Long id, Item[] itens, Letra[] erradas, Jogador jogador) {
    	
    }
    
    private Rodada(Long id, Palavra[] palavras, Jogador jogador) {
    	
    }
    
    private Rodada(Long id, Item[] itens, Letra[] erradas, Jogador jogador) {
    	
    }
    
    public Jogador getJogador() {
    	
    }
    
    public Tema getTema() {
    	
    }
    
    public Palavra[] getPalavras() {
    	
    }
    
    public int getNumPalavras() {
    	
    }
    
    public void tentar(char codigo) {
    	
    }
    
    public void arriscar(String[] palavras) {
    	
    }
    
    public void exibirItens(Object contexto) {
    	
    }
    
    public void exibirBoneco(Object contexto) {
    	
    }
    
    public void exibirPalavras(Object contexto) {
    	
    }
    
    public Letra[] getTentativas() {
    	
    }
    
    public Letra[] getCertas() {
    	
    }
    
    public Letra[] getErradas() {
    	
    }
    
    public int calcularPontos() {
    	
    }
    
    public boolean encerrou() {
    	
    }
    
    public boolean descobriu() {
    	
    }
    
    public boolean arriscou() {
    	
    }
    
    public int getQtdeTentativaRestantes() {
    	
    }
    
    public int getQtdeErros() {
    	
    }
    
    public int getQtdeAcertos() {
    	
    }
    
    public int getQtdeTentativas() {
    	
    }
}
