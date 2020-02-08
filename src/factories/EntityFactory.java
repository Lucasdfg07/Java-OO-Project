package factories;

import repositories.Repository;

public abstract class EntityFactory {
	
	
	protected static Repository repository;
	
	protected EntityFactory(Repository repository) {
		EntityFactory.repository = repository;
		
	}
	
	protected Repository getRepository() {
		return repository;
	}
	
	protected long getProximoId() {
		return repository.getProximoId();
	}

}
