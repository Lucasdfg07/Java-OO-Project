package testes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Aplicacao;
import factories.JogadorFactory;
import factories.PalavraFactory;
import factories.RodadaFactory;
import factories.TemaFactory;
import models.BonecoTexto;
import models.Jogador;
import models.Letra;
import models.Palavra;
import models.Rodada;
import models.Tema;


public class Main {
	
	private ArrayList<String> buffer = new ArrayList<String>();
	
	public void adicionar(String s) {
		this.buffer.add(s);
	};

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Bem vindo ao Jogo da Forca!!");
		
		boolean opcao = true;       
        Scanner scan = new Scanner(System.in);
        
        Aplicacao aplicacao = Aplicacao.getSoleInstance();
        
        JogadorFactory jFactory = aplicacao.getJogadorFactory();
        
        RodadaFactory rFactory = aplicacao.getRodadaFactory();
        
        TemaFactory tfactory = aplicacao.getTemaFactory();
        
        setTema(tfactory, aplicacao);
        
        iniciarJogo(jFactory, rFactory);
        
    }
	
	private static void iniciarJogo(JogadorFactory jFactory, RodadaFactory rFactory) {
		Scanner scan = new Scanner(System.in);
		
		boolean o = true;
        
		//Setar automaticamente o nome do jogador
        Jogador player = jFactory.getJogador("Jogador 1");
        Rodada rodada = rFactory.getRodada(player);
        
        System.out.println("---------------------------");
        //System.out.println("Nome: "+ player.getNome());
        
    	System.out.println("O tema é '" + rodada.getTema().getNome() +"'");
    	
    	boolean encerramento = rodada.encerrou();
        iniciaJogoForca(rodada, encerramento);
	}
	
 	private static void iniciaJogoForca(Rodada r, boolean encerramento) {
		Scanner scan = new Scanner(System.in);
		
		while (encerramento == false) {
			// Exibição das letras encobertas
	        r.exibirItens(null);
	        
	        System.out.println();
        	
            for (Letra t: r.getTentativas()) {
                t.exibir(null);
                
                System.out.print(" - ");
            }
            
            System.out.println("\nErros: " + r.getQtdeErros() + 
            				   "\nMáximo:" + Rodada.getMaxErros());
            
            System.out.println();
            
            System.out.println("Forca: ");
            r.exibirBoneco(null);
            
            digitarLetra(r);
            
        }

        System.out.println("Pontos: "+r.calcularPontos());

        scan.close();
	}
 	
 	private static void digitarLetra(Rodada r) {
 		Scanner scan = new Scanner(System.in);
        System.out.print("Digite a Letra desejada: ");
        
        char code = scan.next().charAt(0);
        // Maior que A, menor que Z
        if (code >= 'A' && code <= 'Z') {
        	code = (char)(code+32);
        } 
        
        r.tentar(code); 

        System.out.println("");
        
        venceuJogo(r);
 	}
	
 	private static void venceuJogo(Rodada r) {
 		if (r.descobriu() == true) {
            r.exibirPalavras(null);
            
            System.out.println("Parabéns, você ganhou o jogo!");
            
            //Seta encerramento = true e chama a função iniciaJogoForca novamente.
            boolean encerramento = true;
            iniciaJogoForca(r, encerramento);
        } else if (r.getQtdeErros() == 10){
            System.out.println("Você perdeu!");
            
            boolean encerramento = true;
            iniciaJogoForca(r, encerramento);
        }
 	}
 	
	private static void setTema(TemaFactory tfactory, Aplicacao aplicacao) {
		Tema tCasa = tfactory.getTema("Móveis da Casa");
        PalavraFactory palavra = aplicacao.getPalavraFactory();
        palavra.getPalavra("mesa", tCasa);
        palavra.getPalavra("cadeira", tCasa);
        palavra.getPalavra("cortina", tCasa);
        
        Tema tProfs = tfactory.getTema("Professores");
        PalavraFactory palavra2 = aplicacao.getPalavraFactory();
        palavra2.getPalavra("fernando", tProfs);
        palavra2.getPalavra("mark", tProfs);
        palavra2.getPalavra("marcio", tProfs);
	}
}
