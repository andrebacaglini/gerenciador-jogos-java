package br.com.gerenciador.jogos.business;

import java.util.List;

import br.com.gerenciador.jogos.domain.entities.Jogo;

public interface IJogosBusiness {
	
	boolean cadastrarJogo(Jogo jogo);
	
	List<Jogo> listaJogos();

}
