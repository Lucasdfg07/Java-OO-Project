package factories;

import models.Boneco;
import models.BonecoFactory;
import models.BonecoTexto;

public class BonecoTextoFactory implements BonecoFactory {

	private static BonecoTextoFactory soleInstance;
	
	private BonecoTextoFactory() {
		
	}
	
	public static BonecoTextoFactory getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new BonecoTextoFactory();
		
		return soleInstance;
	}
	
	public Boneco getBoneco() {
		return BonecoTexto.getSoleInstance();
	}
}