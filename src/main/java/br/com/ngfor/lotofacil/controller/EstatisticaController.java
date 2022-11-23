package br.com.ngfor.lotofacil.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ngfor.lotofacil.DTO.ImparesDTO;
import br.com.ngfor.lotofacil.DTO.ParesDTO;
import br.com.ngfor.lotofacil.DTO.SequenciaIntervaloDTO;
import br.com.ngfor.lotofacil.model.NumerosSorteados;
import br.com.ngfor.lotofacil.model.Resultado;
import br.com.ngfor.lotofacil.services.EstatisticaService;
import br.com.ngfor.lotofacil.services.ResultadoService;

@RestController
@RequestMapping("/api/estatistica")
public class EstatisticaController {

	private ResultadoService rs;
	private EstatisticaService es;

	public EstatisticaController(ResultadoService rs, EstatisticaService es) {
		this.rs = rs;
		this.es = es;
	}

	// Retorna o numero de vezes que o numero aparece na lista de concurso
	// passando o numero de concurso a serem analizados
	@GetMapping("/numeros/{concusos}")
	public List<NumerosSorteados> contasNumerosSoteados(@PathVariable(value = "concusos") String concusos) {

		int n = Integer.parseInt(concusos);
		List<Resultado> resultados = this.rs.buscaLimite(n);

		return es.contaNumeroPorConcurso(n, resultados);

	}

	// Retorna o numero mais sorteados em um intervalo de datas
	@GetMapping("/intervalo/{dataInicial}/{dataFinal}")
	public List<NumerosSorteados> contasNumerosIntervaloData(@PathVariable(value = "dataInicial") String dataInicial,
			@PathVariable(value = "dataFinal") String dataFinal) {

		List<Resultado> resultados = this.rs.buscaConcusosIntervaloData(dataInicial, dataFinal);

		return this.es.contaNumeroPorConcurso(resultados.size(), resultados);

	}

	// Retorna o numero de vezes que um numero coincidem com outro numero passando o
	// numero a ser analizado e uma lista de sorteios
	@GetMapping("/coincidencias/{numero}/{sorteio}")
	public List<NumerosSorteados> coincidencias(@PathVariable int numero, @PathVariable int sorteio) {

		List<Resultado> resultadosContemNumero = this.rs.buscaLimite(sorteio);

		return this.es.coincidencias(numero, resultadosContemNumero);

	}

	@GetMapping("/par/{sorteio}")
	public ParesDTO listPares(@PathVariable int sorteio) {

		List<Resultado> resultadosContemNumero = this.rs.buscaLimite(sorteio);

		return this.es.listaPar(resultadosContemNumero);

	}

	@GetMapping("/impar/{sorteio}")
	public ImparesDTO listImpares(@PathVariable int sorteio) {

		List<Resultado> resultadosContemNumero = this.rs.buscaLimite(sorteio);

		return this.es.listaImpar(resultadosContemNumero);

	}

	@GetMapping("/sequencia/{numero}/{sorteio}")
	public SequenciaIntervaloDTO sequenciaIntervalo(@PathVariable int numero, @PathVariable int sorteio) {

		List<Resultado> resultadosContemNumero = this.rs.buscaLimite(sorteio);

		return this.es.sequenciaIntervalo(numero, resultadosContemNumero);

	}

}
