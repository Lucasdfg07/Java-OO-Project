package services;

import factories.RodadaFactory;
import model.Jogador;
import model.Rodada;
import repositories.JogadorRepository;
import repositories.RepositoryException;
import repositories.RodadaRepository;

public class RodadaAppService {
	private static RodadaAppService soleInstance;
	
	private RodadaRepository rodadaRepository;
	private RodadaFactory rodadaFactory;
	private JogadorRepository jogadorRepository;
	
	private RodadaAppService(RodadaFactory rodadaFactory, RodadaRepository rodadaRepository, JogadorRepository jogadorRepository) {
		this.rodadaRepository = rodadaRepository;
		this.rodadaFactory = rodadaFactory;
		this.jogadorRepository = jogadorRepository;
	}
	
	public void createSoleInstance(RodadaFactory rodadaFactory, RodadaRepository rodadaRepository, JogadorRepository jogadorRepository) {
		
	}
	
	public static RodadaAppService getSoleInstance() {
		if(soleInstance == null) 
			soleInstance = new RodadaAppService(null, null, null);
		
		return soleInstance;
	}
	
//	public Rodada novaRodada(int idJogador) throws JogadorNaoEncontradoException{
//		try {
//			jogadorRepository.inserir(idJogador);	
//		} catch (Exception e) {
//			System.out.print(e.getMessage());
//		}
//	}
//	
//	public Rodada novaRodada(String nomeJogador) throws JogadorNaoEncontradoException{
//		try {
//			jogadorRepository.inserir(nomeJogador);	
//		} catch (Exception e) {
//			System.out.print(e.getMessage());
//		}
//	}
	
	public Rodada novaRodada(Jogador jogador) {
		return rodadaFactory.getRodada(jogador);		
	}
	
	public boolean salvarRodada(Rodada rodada) throws RepositoryException{
		return false;
	}
}
