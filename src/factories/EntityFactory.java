package factories;

import repositories.Repository;

public abstract class EntityFactory {
  
  private Repository repo;

  protected EntityFactory(Repository repository) {
	  this.repo = repository;
  }

  protected Repository getRepository() {
	  return repo;
  }

  protected Long getProximoId() {
    return repo.getProximoId();
  }
}