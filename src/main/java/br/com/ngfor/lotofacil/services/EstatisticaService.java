package br.com.ngfor.lotofacil.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ngfor.lotofacil.DTO.ImparesDTO;
import br.com.ngfor.lotofacil.DTO.ParesDTO;
import br.com.ngfor.lotofacil.DTO.SequenciaIntervaloDTO;
import br.com.ngfor.lotofacil.algoritmo.AlgoritmoEstatistica;
import br.com.ngfor.lotofacil.model.NumerosSorteados;
import br.com.ngfor.lotofacil.model.Resultado;

@Service
public class EstatisticaService {

	private AlgoritmoEstatistica ap;

	public EstatisticaService(AlgoritmoEstatistica ap) {
		super();
		this.ap = ap;
	}

	// Retorna o numero de vezes que um numero apareceu nos sorteios
	// passando o numero a ser analizado e uma lista de sorteios
	public List<NumerosSorteados> contaNumeroPorConcurso(int numero, List<Resultado> resultados) {

		List<NumerosSorteados> ns = ap.numerosMaisSorteados(resultados);

		ns.sort((r1, r2) -> r1.compareTo(r2));

		return ns;

	}

	// Retorna o numero de vezes que um numero coincidem com outro numero passando o
	// numero a ser analizado e uma lista de sorteios
	public List<NumerosSorteados> coincidencias(int numero, List<Resultado> resultados) {

		List<NumerosSorteados> ns = ap.numerosJuntos(numero, resultados);

		ns.sort((r1, r2) -> r1.compareTo(r2));

		return ns;

	}

	// retorna a frequencia de sequencia e intervalos
	// passando uma lista de sorteios
	public SequenciaIntervaloDTO sequenciaIntervalo(int numero, List<Resultado> resultados) {
		return ap.sequencias(numero, resultados);
	}

	public ParesDTO listaPar(List<Resultado> resultados) {
		return ap.numerosPares(resultados);
	}

	public ImparesDTO listaImpar(List<Resultado> resultados) {
		return ap.numerosImpares(resultados);
	}

}
