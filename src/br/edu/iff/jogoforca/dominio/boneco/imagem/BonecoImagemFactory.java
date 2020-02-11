package br.edu.iff.jogoforca.dominio.boneco.imagem;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;
import br.edu.iff.jogoforca.dominio.boneco.imagem.BonecoImagem;

public class BonecoImagemFactory implements BonecoFactory {

	private static BonecoImagemFactory soleInstance;
	
	private BonecoImagemFactory() {
		
	}

	public static BonecoImagemFactory getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new BonecoImagemFactory();
		
		return soleInstance;
		
	}
	
	

	public Boneco getBoneco() {
		// TODO Auto-generated method stub
		return BonecoImagem.getSoleInstance();
	}
}