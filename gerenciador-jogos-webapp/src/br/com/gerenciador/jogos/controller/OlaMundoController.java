package br.com.gerenciador.jogos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gerenciador.jogos.business.IJogosBusiness;
import br.com.gerenciador.jogos.domain.entities.Jogo;

@Controller
public class OlaMundoController {

	// para evitar gerenciar os beans no xml do spring, basta seguir os padrões de
	// anotações
	// @Repository para classes de persistencias
	// @Service para classes de serviços/negocio
	// @Component é generico, pode ser utilizado "em qualquer lugar"
	// Feito isso, basta anotar a prop (ou qualquer outro contexto) com @Autowired

	@Autowired
	private IJogosBusiness _jogoBusiness;

	@RequestMapping
	public String index() {
		return "olamundo";
	}

	// Ao definir um valor para RequestMapping, estamos vinculando a rota ~/olamundo
	// à action minhaAcao
	@RequestMapping("/olamundo")
	public String minhaAcao() {
		List<Jogo> listaJogos = _jogoBusiness.listaJogos();
		for (Jogo j : listaJogos) {
			System.out.println(j.getNome());
		}
		return "olamundo";
	}

	@RequestMapping("/formularioJogo")
	public String formularioJogo() {

		return "jogo/formulario";
	}

	@RequestMapping("/cadastrarJogo")
	public String cadastrarJogo(Jogo jogo) {

		boolean foiSalvo = _jogoBusiness.cadastrarJogo(jogo);
		System.out.println(String.format("O jogo %s foi salvo? %s", jogo.getNome(), foiSalvo));

		return "olamundo";
	}

}
