package br.edu.iff.jogoforca.dominio.rodada;
 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.jogoforca.ElementoGraficoFactory;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
 
public class Rodada extends ObjetoDominioImpl {
       
  private static int maxPalavras = 3;
  private static int maxErros = 10;
  private static int pontosQuandoDescobreTodasAsPalavras = 100;
  private static int pontosPorLetraEncoberta = 15;
 
  private static BonecoFactory bonecoFactory = null;
 
  private Jogador j1;
 
  private Boneco boneco;
 
  private List<Item> listaItens;
 
  private Set<Letra> certas;
  private Set<Letra> erradas;
 
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
 
  public static BonecoFactory getBonecoFactory() {
          return bonecoFactory;
  }
 
  public static void setBonecoFactory(BonecoFactory factory) {
          bonecoFactory = factory;
  }
 
  public static Rodada criar(Long id, List<Palavra> palavras, Jogador jogador) {
          Rodada r = new Rodada(id, palavras, jogador);
          return r;
  }
 
  public static Rodada reconstituir(Long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
          Rodada r = new Rodada(id, itens, erradas, jogador);
          return r;
  }
 
  private Rodada(Long id, List<Palavra> palavras, Jogador jogador) {
    super(id);
 
    if (getBonecoFactory() == null) {
       
      throw new RuntimeException("Boneco Factory não inicializada!");
   
    }
 
 
    this.j1 = jogador;
    boneco = getBonecoFactory().getBoneco();
   
    this.certas = new HashSet<>();
   
    this.erradas = new HashSet<>();
   
    this.listaItens = new ArrayList<>(
                palavras.size()
    );
 
    for (int i = 0; i < palavras.size(); i++) {
      this.listaItens.add(Item.criar(i, palavras.get(i)));
    }
  }
 
  private Rodada(Long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
    super(id);
 
    if (getBonecoFactory() == null) {
      throw new RuntimeException("Fábrica do boneco ainda não foi inicializada");
    }
 
    boneco = getBonecoFactory().getBoneco();
 
    this.j1 = jogador;
   
    this.certas = new HashSet<>();
   
    this.erradas = new HashSet<>();
   
    this.listaItens = new ArrayList<>(
        itens.size()
    );
 
    for (int i = 0; i < itens.size(); i++) {
      Item item = itens.get(i);
     
      this.listaItens.add(item);
 
      for (Letra correta: item.getLetrasDescobertas()) {
        this.certas.add(correta);
      }
    }
 
    for (Letra errada: erradas) {
      this.erradas.add(errada);
    }
  }
 
  public Jogador getJogador() {
    return this.j1;
  }
 
  public Tema getTema() {
    return this.listaItens.get(0).getPalavra().getTema();
  }
 
  public List<Palavra> getPalavras() {
   
        List<Palavra> p = new ArrayList<>();
   
    for (Item i: listaItens) {
      p.add(i.getPalavra());
    }
   
    return p;
  }
 
  public int getNumPalavras() {
    return listaItens.size();
  }
 
  public void tentar(char codigo) {
   
     if (encerrou() == true) {
      return;
    } else {
     
            Map<Item, Boolean> corretos = new HashMap<>();
           
            ElementoGraficoFactory letraFactory = Palavra.getLetraFactory();
       
            for (Item item: listaItens) {
               
              if (item.tentar(codigo) == true) {
                  certas.add(letraFactory.getLetra(codigo));
                 
                  corretos.put(item, true);
              } else {
                  corretos.put(item, false);
              }
             
            }
       
            if (!corretos.containsValue(true)) {
              erradas.add(letraFactory.getLetra(codigo));
            }
       
            if (encerrou() == true) {
                this.j1.setPontuacao(
                        this.calcularPontos()
                );
            }
           
    }
  }
 
  public void arriscar(List<String> palavras) {
    if (encerrou() == true) {
      return;
    } else {
            int aux = 0;
           
            if (palavras.size() < listaItens.size()) {
                aux = palavras.size();
            } else {
                aux = listaItens.size();
            }
       
            for (int i = 0; i < aux; i++) {
                listaItens.get(i).arriscar(
                        palavras.get(i)
                );
            }
       
            if (encerrou() == true) {
                this.j1.setPontuacao(
                        this.calcularPontos()
                );
            }
    }
  }
 
  public void exibirItens(Object contexto) {
    for (Item i: listaItens) {
      i.exibir(contexto);
     
      System.out.println();
    }
   
  }
 
  public void exibirBoneco(Object contexto) {
    boneco.exibir(contexto, getQtdeErros());
  }
 
  public void exibirPalavras(Object contexto) {
    for (Palavra p: getPalavras()) {
      p.exibir(contexto);
     
      System.out.println();
    }
   
  }
 
  public Set<Letra> getTentativas() {
    Set<Letra> tentar = new HashSet<>();
   
    tentar.addAll(certas);
   
    tentar.addAll(erradas);
 
    return tentar;
  }
 
  public Set<Letra> getCertas() {
    return Collections.unmodifiableSet(certas);
  }
 
  public Set<Letra> getErradas() {
    return Collections.unmodifiableSet(erradas);
  }
 
  public int calcularPontos() {
         
    if (!descobriu() == true) {
      return 0;
    } else {
            int p = getPontosQuandoDescobreTodasAsPalavras();
       
            for (Item item: listaItens) {
              p = p + item.calcularPontosLetrasEncobertas(getPontosPorLetraEncoberta());
            }
       
            return p;
    }
  }
 
  public boolean encerrou() {
    if (arriscou() || descobriu() || getQtdeTentativaRestantes() == 0) {
      return true;
    }
     
    return false;
  }
 
  public boolean descobriu() {
    for (Item i: listaItens) {
       
      if (!i.descobriu()) {
        return false;
      }
     
    }
     
    return true;
  }
 
  public boolean arriscou() {
         
    for (Item i: listaItens) {
        if (i.arriscou() == true) {
                return true;
        }
    }
     
    return false;
  }
 
  public int getQtdeTentativaRestantes() {
          return getMaxErros() - erradas.size();
  }
 
  public int getQtdeErros() {
          return erradas.size();
  }
 
  public int getQtdeAcertos() {
          return certas.size();
  }
 
  public int getQtdeTentativas() {
          return getQtdeErros() + getQtdeAcertos();
  }
}