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
	
	public int novaRodada1(String idJogador) throws JogadorNaoEncontradoException {
		
		int id = Integer.parseInt(idJogador);
		
		try {
			Jogador retorno = jogadorRepository.getPorId(id);
			return rodadaFactory.getRodada(retorno);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return 0;
	}
	
	public int novaRodada(String nomeJogador) throws JogadorNaoEncontradoException{
		
		try {
			Jogador[] retorno = jogadorRepository.getPorNome(nomeJogador);
			return rodadaFactory.getRodada(retorno);
			
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return 0;
	}
	
	public Rodada novaRodada(Jogador jogador) {
		try {
			jogadorRepository.inserir(jogador);	
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		
		return null;
	}
	
	public void salvarRodada(Rodada rodada) throws RepositoryException{
		try {
			rodadaRepository.inserir(rodada);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
	}
}
