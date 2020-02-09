package factories;

import model.Tema;
import repositories.Repository;
import repositories.TemaRepository;

public class TemaFactoryImpl  extends EntityFactory  implements TemaFactory{
	
	private static TemaFactoryImpl soleInstance;

	private TemaFactoryImpl(Repository repository) {
		// TODO Auto-generated constructor stub
		super(repository);	
	}
	
	public static void createSoleInstance(TemaRepository temaRepository) {
		// TODO Auto-generated method stub
		soleInstance = new TemaFactoryImpl(repository);
	}
	
	
	public static TemaFactoryImpl getSoleInstance() {
		if(soleInstance == null)
			soleInstance = new  TemaFactoryImpl(repository);
			
			return soleInstance;
	}

	private TemaRepository getTemaRepository() {
		return (TemaRepository) this.getRepository();
	}
	
	@Override
	public Tema[] getTema(String nome) {
		// TODO Auto-generated method stub
		return this.getTemaRepository().getPorNome(nome);
	}


}
