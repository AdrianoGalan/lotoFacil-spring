package br.com.ngfor.lotofacil.algoritmo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.SystemPropertyUtils;

import br.com.ngfor.lotofacil.model.Frequencia;
import br.com.ngfor.lotofacil.model.NumerosSorteados;
import br.com.ngfor.lotofacil.model.Previsao;
import br.com.ngfor.lotofacil.model.Resultado;
import br.com.ngfor.lotofacil.services.EstatisticaService;
import br.com.ngfor.lotofacil.services.ResultadoService;

@Service
public class AlgoritmoPrevisao {

	private ResultadoService rs;
	private EstatisticaService estatisticaService;

	public AlgoritmoPrevisao(ResultadoService rs, EstatisticaService estatisticaService) {
		super();
		this.rs = rs;
		this.estatisticaService = estatisticaService;
	}

	public void algoritmo1() {

		System.out.println("Então");

		int totalConcurso = 2;

		double pontos = 0;
		double pontosAtual = 0;

		List<Integer> acertos = new ArrayList<>();

		int sequenciaFrequenciaIntervalo = 0;
		int sequenciaFrequenciaTotal = 0;
		int sequencia = 0;
		int intervalo = 10;
		List<Resultado> todosConcursos = rs.findAll();

		for (int k = 10; k < 1000; k++) {

			totalConcurso = k;

			
			List<Resultado> concursoAnalise = new ArrayList<>();
			List<Previsao> nPrevisao = new ArrayList<>();

			// cria uma lista com os 10 primeiros concursos
			for (int i = todosConcursos.size() - 1; i >= (todosConcursos.size() - totalConcurso); i--) {

				concursoAnalise.add(todosConcursos.get(i));

				// mostra lista
				// System.err.println(todosConcursos.get(i));

			}

			// lista os numeros mais sorteados
			List<NumerosSorteados> numerosSorteadosAnalise = estatisticaService
					.contaNumeroPorConcurso(concursoAnalise.size(), concursoAnalise);

			// mostra numeros mais sorteados
//		for (NumerosSorteados numerosSorteados : numerosSorteadosAlalise) {
//			System.err.println(numerosSorteados);
//		}

			// calcula pontos usando frequencia do numero
			for (int i = 0; i < numerosSorteadosAnalise.size(); i++) {

				// System.err.println(numerosSorteadosAnalise.get(i));

				// int pontos = (25 * numerosSorteadosAlalise.get(i).getQuantidade()) /
				// numerosSorteadosAlalise.size();

				pontos = ((100.0 * numerosSorteadosAnalise.get(i).getQuantidade()) / (15.0 * totalConcurso));

				nPrevisao.add(new Previsao(numerosSorteadosAnalise.get(i).getNumero(), pontos));

			}

			// mostra numeros e pontos
			/*
			 * for (Previsao p : nPrevisao) { System.err.println(p); }
			 */

			for (int i = 0; i < numerosSorteadosAnalise.size(); i++) {

				// System.out.println("Numero analisado " +
				// numerosSorteadosAnalise.get(i).getNumero());

				// verifica frequencia do numero
				List<Frequencia> intervalos = estatisticaService
						.sequenciaIntervalo(numerosSorteadosAnalise.get(i).getNumero(), concursoAnalise)
						.getMediaIntervalo();
				List<Frequencia> sequencias = estatisticaService
						.sequenciaIntervalo(numerosSorteadosAnalise.get(i).getNumero(), concursoAnalise)
						.getMediaSequencia();

				// mostra frequuencia do numero
//		for (Frequencia frequencia : intervalos) {
//			System.out.println("Intervalo " + frequencia);
//		}

				sequenciaFrequenciaTotal = 0;
				for (Frequencia frequencia : sequencias) {
//			System.out.println("Sequencia " + frequencia);

					sequenciaFrequenciaTotal = sequenciaFrequenciaTotal + frequencia.getFrequencia();
				}

				sequencia = 0;

				// conta sequencia de ultimos concursos que contem o numero
				for (int j = concursoAnalise.size() - 1; j >= 0; j--) {

					if (concursoAnalise.get(j).getAll().contains(numerosSorteadosAnalise.get(i).getNumero())) {
						sequencia++;

					} else {
						break;
					}

				}

				sequenciaFrequenciaIntervalo = 0;
				for (Frequencia frequencia : sequencias) {
//			System.out.println("Sequencia " + frequencia);

					if (sequencia != 0) {
						if (Integer.parseInt(frequencia.getChave()) >= sequencia) {
							sequenciaFrequenciaIntervalo = sequenciaFrequenciaIntervalo + frequencia.getFrequencia();
						}
					} else {
						break;
					}

				}

				pontos = (100.0 * sequenciaFrequenciaIntervalo) / sequenciaFrequenciaTotal;
				pontosAtual = nPrevisao.get(i).getPonto();

				nPrevisao.get(i).setPonto(pontosAtual + pontos);

			}

			// ordena pontos
			nPrevisao.sort((p1, p2) -> p1.compareTo(p2));

			for (int j = 0; j < nPrevisao.size(); j++) {

				int n = nPrevisao.get(j).getNumero();

				//System.err.println(n);

				List<NumerosSorteados> ns = this.estatisticaService.coincidencias(n, concursoAnalise);
				for (NumerosSorteados numerosSorteados : ns) {

					if (numerosSorteados.getNumero() != n) {
					//	System.err.println(numerosSorteados);
						pontos = (numerosSorteados.getQuantidade() * 100) / totalConcurso;

						for (int l = 0; l < nPrevisao.size(); l++) {

							if (nPrevisao.get(l).getNumero() == numerosSorteados.getNumero()) {

								pontosAtual = nPrevisao.get(l).getPonto();
								nPrevisao.get(l).setPonto(pontosAtual + pontos);

								break;

							}

						}

						break;
					}

				}
			}

			// ordena pontos
			nPrevisao.sort((p1, p2) -> p1.compareTo(p2));

			// gera jogo
			Resultado previsto = new Resultado();
			List<Integer> bolas = new ArrayList<>();

			for (int j = 0; j < 15; j++) {

				bolas.add(nPrevisao.get(j).getNumero());
			}

			previsto.addAll(bolas);

			// conferir resultados
			acertos.add(this.confereResultado(totalConcurso + 1, previsto));
		}

//		mostra acertos 
		for (Integer acerto : acertos) {
			if (acerto > 12) {
				System.err.println("Acerto " + acerto);
			} else {
				System.out.println("Acerto " + acerto);
			}
		}

	}

	private int confereResultado(int concurso, Resultado previsto) {

		Resultado resultado = this.rs.buscaConcurso(concurso);
		int acerto = 0;

		for (int i = 0; i < 15; i++) {

			if (resultado.getAll().contains(previsto.getAll().get(i))) {
				acerto++;
			}

		}

		return acerto;

	}

}
