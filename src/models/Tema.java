package models;

import models.Tema;

public class Tema extends ObjetoDominioImpl {

  private String nome;

  public static Tema criar(Long id, String nome) {
	Tema t = new Tema(id, nome);
	return t;
  }

  public static Tema reconstituir(Long id, String nome) {
	Tema t = new Tema(id, nome);
	return t;
  }

  private Tema(Long id, String nome) {
    super(id);
    
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
}