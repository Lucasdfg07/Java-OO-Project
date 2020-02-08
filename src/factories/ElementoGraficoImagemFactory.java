package factories;

import model.Boneco;
import model.Letra;

public class ElementoGraficoImagemFactory implements ElementoGraficoFactory {

	private static ElementoGraficoImagemFactory soleInstance;
	private BonecoImagemFactory bonecoImagemFactory;
	private LetraImagemFactory letraImagemFactory;
	
	private ElementoGraficoImagemFactory() {
		
	}
	
	public static ElementoGraficoImagemFactory getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new ElementoGraficoImagemFactory();
		
		return soleInstance;
	}

	@Override
	public Boneco getBoneco() {
		// TODO Auto-generated method stub
		return bonecoImagemFactory.getBoneco();
	}

	@Override
	public Letra getLetra(char codigo) {
		return letraImagemFactory.getLetra(codigo);
	}

	@Override
	public Letra getLetraEncoberta() {
		return letraImagemFactory.getLetraEncoberta();
	}

}
