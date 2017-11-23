package br.com.gerenciador.jogos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaMundoController {

	@RequestMapping("/olamundo")
	public String minhaAcao() {
		return "olamundo";
	}
	
}
