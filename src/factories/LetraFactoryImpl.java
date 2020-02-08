package factories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import model.Letra;
import model.LetraFactory;
import model.Palavra;

public abstract class LetraFactoryImpl implements LetraFactory {
	
	private  List<Letra> pool = new ArrayList<Letra>();
	private HashMap<Long , Letra> encoberta = new  HashMap<Long , Letra>();
	
	protected LetraFactoryImpl() {
		
	}
	
	protected Letra criarLetra(char codigo) {
		return null;
	}

	@Override
	public Letra getLetra(char codigo) {
		return null;
	}

	@Override
	public Letra getLetraEncoberta() {
		// TODO Auto-generated method stub
		return null;
	}

}
