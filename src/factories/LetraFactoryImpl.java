package factories;

import models.Letra;

public abstract class LetraFactoryImpl {

	private Letra[] pool;
	
	private Letra letraEnc;
	

	protected LetraFactoryImpl() {
		// 26 letras do alfabeto
		this.pool = new Letra[26];
		
		this.letraEnc = null;
	}

	protected Letra criarLetra(char codigo) {
		return null;
	}
	
	public final Letra getLetra(char codigo) {
		//Diminui a o codigo por 'a', obtendo assim o código da letra
		int dif = codigo-'a';
		
		Letra letra = this.pool[dif];
		
		if(letra == null) {
			letra = this.criarLetra(codigo);
			this.pool[dif] = letra;
		}
		
		return letra;
	}

	public final Letra getLetraEncoberta() {
		
		if (letraEnc == null) {
			// Caso o espaço da letra seja null, então representa a letra escondida como *
			char codigo = '*';
			
			this.letraEnc = this.criarLetra(codigo);
		}
		return this.letraEnc;
	}
}