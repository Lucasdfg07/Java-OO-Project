package factories;

import model.Tema;
import repositories.Repository;

public class TemaFactoryImpl  extends EntityFactory  implements TemaFactory{
	
	
	private static TemaFactoryImpl soleInstance;

	protected TemaFactoryImpl(Repository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}
	
	
	public static TemaFactoryImpl getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new  TemaFactoryImpl(repository);
			
			return soleInstance;
	}


	@Override
	public Tema getTema(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

}
