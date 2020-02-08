package model;

import java.io.Serializable;

public abstract class ObjetoDominioImpl implements ObjetoDominio {
	
	private Long id;
	
	public ObjetoDominioImpl(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
		
	}


}
