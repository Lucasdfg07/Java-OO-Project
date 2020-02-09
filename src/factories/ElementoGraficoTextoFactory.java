package factories;

import model.Boneco;
import model.Letra;

public class ElementoGraficoTextoFactory implements ElementoGraficoFactory {
	
	private static ElementoGraficoTextoFactory soleInstance;
	private BonecoTextoFactory bonecoTextoFactory;
	private LetraTextoFactory letraTextoFactory;
	
	private ElementoGraficoTextoFactory() {
		letraTextoFactory = LetraTextoFactory.getSoleInstance();
		bonecoTextoFactory = BonecoTextoFactory.getSoleInstance();
	}
	
	public static ElementoGraficoTextoFactory getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new ElementoGraficoTextoFactory();
		
		return soleInstance;
	}

	@Override
	public Boneco getBoneco() {
		// TODO Auto-generated method stub
		return bonecoTextoFactory.getBoneco();
	}

	@Override
	public Letra getLetra(char codigo) {
		return letraTextoFactory.getLetra(codigo);
	}

	@Override
	public Letra getLetraEncoberta() {
		return letraTextoFactory.getLetraEncoberta();
	}

}
