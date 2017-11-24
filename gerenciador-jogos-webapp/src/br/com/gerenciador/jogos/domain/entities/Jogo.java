package br.com.gerenciador.jogos.domain.entities;

import org.hibernate.validator.constraints.NotEmpty;

public class Jogo {

	private int id;
	
	@NotEmpty	
	private String nome;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
