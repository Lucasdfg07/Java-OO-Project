package model;

public class Jogador extends ObjetoDominioImpl {
	
	private String nome;
	private int pontuacao = 0;
	
	public static Jogador criar(Long id, String nome) {
		Jogador j = new Jogador(id, nome);
		return j;
	}
	
	public static Jogador reconstituir(Long id, String nome, int pontuacao) {
		Jogador j = new Jogador(id, nome);
		return j;		
	}
	
	private Jogador(Long id, String nome) {
		super(id);
		this.nome = nome;
	}
	
	private Jogador(Long id, String nome, int pontuacao) {
		super(id);
		this.nome = nome;
		this.pontuacao = pontuacao;
	}

	public String getNome() {
		return nome;
		
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
		
	}

	void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
}
