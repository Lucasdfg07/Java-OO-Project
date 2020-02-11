package models;

public abstract class Letra {

	public abstract void exibir(Object contexto);
	private char codigo;

	protected Letra(char codigo) {
	  	this.codigo = codigo;
	}
	
	public char getCodigo() {
		 return codigo;
	}
	
	public boolean equals(Object o) {
		 if (!(o instanceof Letra)) {
		   return false;
		 }
		    
		 Letra outra = (Letra) o;
		 
		 
		 return this.codigo == outra.codigo && this.getClass().equals(outra.getClass());
	}
	
	@Override
	public int hashCode() {
		return this.codigo + this.getClass().hashCode();
	}
	
	@Override
	public final String toString() {
		return "Letra: " + codigo;
	 }
}