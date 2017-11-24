package br.com.gerenciador.jogos.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gerenciador.jogos.business.IJogosBusiness;
import br.com.gerenciador.jogos.domain.entities.Jogo;
import br.com.gerenciador.jogos.validation.JogoValidator;

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

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new JogoValidator());
	}

	@RequestMapping
	public String index() {
		return "olamundo";
	}

	// Ao definir um valor para RequestMapping, estamos vinculando a rota ~/olamundo
	// à action minhaAcao
	@RequestMapping("/olamundo")
	public String minhaAcao() {
		return "olamundo";
	}

	@RequestMapping("/listarJogos")
	public String listarJogos(Model model) {
		List<Jogo> listaJogos = _jogoBusiness.listaJogos();
		model.addAttribute("listaJogos", listaJogos);
		return "jogo/listar";
	}

	@RequestMapping("/formularioJogo")
	public String formularioJogo() {

		return "jogo/formulario";
	}

	@RequestMapping("/cadastrarJogo")
	public String cadastrarJogo(@Valid Jogo jogo, BindingResult result) {

		if (result.hasFieldErrors("nome")) {
			return "jogo/formulario";
		} else {
			boolean foiSalvo = _jogoBusiness.cadastrarJogo(jogo);
			System.out.println(String.format("O jogo %s foi salvo? %s", jogo.getNome(), foiSalvo));
		}
		return "redirect:listarJogos";
	}

}
