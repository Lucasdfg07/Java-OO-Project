package factories;

import models.Boneco;
import models.BonecoFactory;
import models.BonecoImagem;

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