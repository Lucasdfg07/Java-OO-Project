package factories;

import model.Boneco;
import model.BonecoFactory;
import model.BonecoImagem;

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
