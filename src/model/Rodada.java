package model;

import java.util.HashSet;

public class Rodada extends ObjetoDominioImpl {
    
    private static int maxPalavras = 3;
    
    private static int maxErros = 10;
    
    private static int pontosQuandoDescobreTodasAsPalavras = 100;
    
    private static int pontosPorLetraEncoberta = 15;
    
    private Jogador jogador;
	private Item[] itens;
	private Letra[] erradas;
	
	private static BonecoFactory boneco;
    
    public static int getMaxPalavras() {
		return maxPalavras;
    	
    }
    
    public static void setMaxPalavras(int max) {
    	maxPalavras = max;
    }
    
    public static int getMaxErros() {
		return maxErros;
    	
    }
    
    public static void setMaxErros(int max) {
    	maxErros = max;
    }
    
    public static int getPontosQuandoDescobreTodasAsPalavras() {
		return pontosQuandoDescobreTodasAsPalavras;
    }
    
    public static void setPontosQuandoDescobreTodasAsPalavras(int pontos) {
    	pontosQuandoDescobreTodasAsPalavras = pontos;
    }
    
    public static int getPontosPorLetraEncoberta() {
    	return pontosPorLetraEncoberta;
    }
    
    public static void setPontosPorLetraEncoberta(int pontos) {
    	pontosPorLetraEncoberta = pontos;
    }
    
    public static void setBonecoFactory(BonecoFactory bonecoFactory) {
    	boneco = bonecoFactory;
    }
    
    public static BonecoFactory getBonecoFactory() {
    	return boneco;
    }
    
    public static Rodada criar(Long id, Palavra[] palavra, Jogador jogador) {
		Rodada r = new Rodada(id, palavra, jogador);
		return r;    	
    }
    
    public static Rodada reconstituir(Long id, Item[] itens, Letra[] erradas, Jogador jogador) {
    	Rodada r = new Rodada(id, itens, erradas, jogador);
		return r;
    }
    
    private Rodada(Long id, Palavra[] palavras, Jogador jogador) {
    	super(id);
    	this.jogador = jogador;
    	int quantidadePalavras = palavras.length;
    	this.itens = new Item[quantidadePalavras];
    	
    	for(int i = 0; i < quantidadePalavras; i++) {
    		this.itens[i] = Item.criar(id, palavras[i]);
    	}
    }
    
    private Rodada(Long id, Item[] itens, Letra[] erradas, Jogador jogador) {
    	super(id);
    	this.itens = itens;
		this.erradas = erradas;
		this.jogador = jogador;
    }
    
    public Jogador getJogador() {
    	return this.jogador;
    	
    }
    
    public Tema getTema() {
    	return this.itens[0].getPalavra().getTema();
    	
    }
    
    public Palavra[] getPalavras() {
    	Palavra[] palavras = new Palavra[this.itens.length];
    	
    	for(int i = 0; i < palavras.length; i++) {
    		palavras[i] = this.itens[i].getPalavra();
    	}
    	
    	return palavras;
    }
    
    public int getNumPalavras() {
    	return itens.length;
    }
    
    public void tentar(char codigo) {
    	Boolean errou = true;
    	
    	if(!this.encerrou()) {
    		for(Item i : this.itens) {
    			if(i.tentar(codigo))
    				errou = false;
    		}
    	} else if(errou) {
    		Letra[] n = new Letra[this.erradas.length + 1];
    		for (int i = 0; i < this.erradas.length; i++) {
    			n[i] = this.erradas[i];
    		}
    		Letra letra = Palavra.getLetraFactory().getLetra(codigo);
    		n[n.length - 1] = letra;
    		this.erradas = n;
    	}
    }
    
    public void arriscar(String[] palavras) {
    	if (!this.encerrou()) {
    		for(int i = 0; i < this.itens.length; i++) {
    			this.itens[i].arriscar(palavras[i]);
    		}
    	} else {
    		this.jogador.setPontuacao(this.calcularPontos());
    	}
    }
    
    public void exibirItens(Object context) {
    	for(Item i : this.itens)
			i.exibir(context);	
    }
    
    public void exibirBoneco(Object context) {
    	boneco.getBoneco().exibir(context, this.getQtdeErros());
    }
    
    public void exibirPalavras(Object context) {
    	for(Item item : this.itens) {
			Palavra palavra = item.getPalavra();
			
			boolean[] posicoes = new boolean[palavra.getTamanho()]; 
			
			for( int i = 0; i < palavra.getTamanho(); i++) {
				posicoes[i] = true;
			}
			
			palavra.exibir(context, posicoes);
		}
    }
    
    public Letra[] getTentativas() {
    	HashSet<Letra> tentativas = new HashSet<Letra>();
    	for(Letra l : this.getCertas()) {
    		tentativas.add(l);
    	}
    	
    	for(Letra l : this.getErradas()) {
    		tentativas.add(l);
    	}
    	
    	Letra[] letras = new Letra[tentativas.size()];
		
    	int count = 0;
    	
		for(Letra l : tentativas) {
			letras[count] = l;
			count++;
		}
		
		return letras;
    }
    
    public Letra[] getCertas() {
    	HashSet<Letra> certas = new HashSet<Letra>();
    	
		for(Item item: this.itens) {
			for(Letra l : item.getLetrasDescobertas()) {
				certas.add(l);
			}
		}
		
		return (Letra[])certas.toArray();
    }
    
    public Letra[] getErradas() {
    	return this.erradas;
    	
    }
    
    public int calcularPontos() {
    	if(!this.descobriu()) {
			return 0;	
    	}
		
		int qtdLetrasEncobertas = 0;
		
		for(Item item : this.itens) {
			qtdLetrasEncobertas = qtdLetrasEncobertas + item.qtdeLetrasEncobertas();
		}
		
		return pontosQuandoDescobreTodasAsPalavras + (pontosPorLetraEncoberta * qtdLetrasEncobertas);
    }
    
    public boolean encerrou() {
    	return this.descobriu();
    	
    }
    
    public boolean descobriu() {
    	for(Item item : this.itens) {
			if (item.descobriu()) {
				return true;
			}
    	}
    	
		return true;
    }
    
    public boolean arriscou() {
    	return this.itens[0].arriscou();
    }
    
    public int getQtdeTentativaRestantes() {
    	return maxErros - this.getQtdeErros();
    }
    
    public int getQtdeErros() {
    	return this.erradas.length;
    }
    
    public int getQtdeAcertos() {
    	int acertos = 0;
		
    	for(Item item : this.itens) {
			acertos = acertos + item.qtdeLetrasEncobertas();
		}
    	
		return acertos;
    }
    
    public int getQtdeTentativas() {
    	HashSet<Letra> tentativas = new HashSet<Letra>();
    	
		for(Letra l : this.getCertas()) {
			tentativas.add(l);
		}
		
		for(Letra l : this.getErradas()) {
			tentativas.add(l);
		}
		
		Letra[] letras = new Letra[tentativas.size()];
		
		int count = 0;
		
		for(Letra letra : tentativas) {
			letras[count] = letra;
			count++;
		}
		
		return count;
    }
}
