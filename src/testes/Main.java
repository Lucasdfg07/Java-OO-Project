package testes;
 
import java.util.ArrayList;
import java.util.Scanner;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactory;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaFactory;
import br.edu.iff.jogoforca.Aplicacao;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorFactory;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactory;
 
 
public class Main {
       
        private ArrayList<String> buffer = new ArrayList<String>();
       
        public void adicionar(String s) {
            this.buffer.add(s);
        };
 
        public static void main(String[] args) throws Exception {
                // TODO Auto-generated method stub
            System.out.println("Bem vindo ao Jogo da Forca!!");
               
            Scanner scan = new Scanner(System.in);
 
            Aplicacao aplicacao = Aplicacao.getSoleInstance();
 
            JogadorFactory jFactory = aplicacao.getJogadorFactory();
 
            RodadaFactory rFactory = aplicacao.getRodadaFactory();
 
            TemaFactory tfactory = aplicacao.getTemaFactory();
 
            setTema(tfactory, aplicacao);
 
            iniciarJogo(jFactory, rFactory);
       
    }
       
        private static void iniciarJogo(JogadorFactory jFactory, RodadaFactory rFactory) {
        	//Setar automaticamente o nome do jogador
            Jogador player = jFactory.getJogador("Jogador 1");
            
            Rodada rodada = rFactory.getRodada(player);
 
            System.out.println("---------------------------");
            //System.out.println("Nome: "+ player.getNome());
 
            System.out.print("O tema é '" + rodada.getTema().getNome() +"'");
 
            iniciaJogoForca(rodada);
        }
       
        private static void iniciaJogoForca(Rodada r) {
            Scanner scan = new Scanner(System.in);
       
            while (r.encerrou() == false) {
 
                System.out.print("Tentativas: ");
                for (Letra tentativa: r.getTentativas()) {
                    tentativa.exibir(null);
                    System.out.print(" ");
                }
                System.out.println();
 
                System.out.println("Palavras:");
                r.exibirItens(null);
                System.out.println();
                System.out.println("Erros: " + r.getQtdeErros() + "/" + Rodada.getMaxErros());
                System.out.println("Corpo: ");
                r.exibirBoneco(null);
                System.out.println();
 
                System.out.print("Digite uma letra: ");
                char codigo = scan.next().charAt(0);
 
                if (codigo >= 'A' && codigo <= 'Z') {
                    codigo = (char)(codigo+32);
                }
 
                r.tentar(codigo);
                System.out.println("");
 
            }
 
            if (r.descobriu()) {
                System.out.println("Parabéns, você ganhou o jogo!");
            } else {
                System.out.println("Você perdeu!");
            }
 
            System.out.println("Pontos: " + r.calcularPontos());
 
            scan.close();
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