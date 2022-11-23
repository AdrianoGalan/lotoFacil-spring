package br.com.ngfor.lotofacil.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ngfor.lotofacil.services.PrevisaoService;

@RestController
@RequestMapping("/api/previsao")
public class PrevisaoController {

	private PrevisaoService ps;

	public PrevisaoController(PrevisaoService ps) {
		super();
		this.ps = ps;
	}

	@GetMapping
	public void list() {
		
		this.ps.algoritmo1();

	}

}
