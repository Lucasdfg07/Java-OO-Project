package services;

import model.Palavra;

public class JogadorNaoEncontradoException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String jogador;

	public JogadorNaoEncontradoException(String jogador) {
	}
	
	public Palavra getJogador() {
		return null;
	}
}
