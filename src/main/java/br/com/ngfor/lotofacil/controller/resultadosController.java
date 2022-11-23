package br.com.ngfor.lotofacil.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ngfor.lotofacil.model.Resultado;
import br.com.ngfor.lotofacil.services.ResultadoService;

@RestController
@RequestMapping("/api/resultados")
public class resultadosController {

	private ResultadoService rs;

	public resultadosController(ResultadoService rs) {
		super();
		this.rs = rs;

	}

	@GetMapping
	public List<Resultado> list() {

		return this.rs.findAll();
	}

	// Alimenta o banco de dados
	@GetMapping("/carregar")
	public List<Resultado> alimentaBancoResultados() {

		return this.rs.alimentaBanco();
	}

	// busca o ultimo sorteio gravado no banco
	@GetMapping("/ultimo")
	public Resultado ultimoResultado() {

		return this.rs.ultimoResultado();
	}

	// Atualiza o banco de dados com os novos sorteios
	@GetMapping("/atualizar")
	public List<Resultado> atualizaResultado() {

		return this.rs.atualizaBanco();
	}

	// busca sorteios passando o numero de sorteios
	@GetMapping("/lista/{concusos}")
	public List<Resultado> getBuscaConcusos(@PathVariable(value = "concusos") String concusos) {

		int n = Integer.parseInt(concusos);

		return this.rs.buscaLimite(n);

	}

	// busca sorteios passando intervalo de datas
	@GetMapping("/lista/{dataInicial}/{dataFinal}")
	public List<Resultado> getBuscaConcusosIntervaloData(@PathVariable(value = "dataInicial") String dataInicial,
			@PathVariable(value = "dataFinal") String dataFinal) {

		return this.rs.buscaConcusosIntervaloData(dataInicial, dataFinal);

	}

	// busca sorteios passando o numero de sorteios
	@GetMapping("/concurso/{concuso}")
	public Resultado getBuscaConcuso(@PathVariable(value = "concuso") String concuso) {

		int n = Integer.parseInt(concuso);

		return this.rs.buscaConcurso(n);

	}

	// busca sorteio que contenha o numero
	// passando numero
	@GetMapping("/lista/contem/{numero}")
	public List<Resultado> getResultadoContem(@PathVariable(value = "numero") String numero) {

		int n = Integer.parseInt(numero);

		return rs.buscaSorteioContemNumero(n);
	}

}
