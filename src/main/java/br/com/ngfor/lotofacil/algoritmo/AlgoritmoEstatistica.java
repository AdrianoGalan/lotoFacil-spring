package br.com.ngfor.lotofacil.algoritmo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.ngfor.lotofacil.DTO.ImparesDTO;
import br.com.ngfor.lotofacil.DTO.ParesDTO;
import br.com.ngfor.lotofacil.DTO.SequenciaIntervaloDTO;
import br.com.ngfor.lotofacil.model.Frequencia;
import br.com.ngfor.lotofacil.model.NumerosSorteados;
import br.com.ngfor.lotofacil.model.Resultado;
import br.com.ngfor.lotofacil.model.SequenciaIntervalo;

@Service
public class AlgoritmoEstatistica {

	// Lista numeros mais sorteados passando uma lista de concursos
	public List<NumerosSorteados> numerosMaisSorteados(List<Resultado> resultados) {

		List<NumerosSorteados> qtsNumero = new ArrayList<NumerosSorteados>(25);

		int bola;
		int qts;

		for (int i = 1; i < 26; i++) {
			NumerosSorteados n = new NumerosSorteados(i, 0);
			qtsNumero.add(n);

		}

		for (int i = 0; i < resultados.size(); i++) {
			for (int j = 0; j < resultados.get(i).getAll().size(); j++) {

				qts = 0;
				bola = 0;

				bola = resultados.get(i).getAll().get(j);
				qts = qtsNumero.get(--bola).getQuantidade();
				qtsNumero.get(bola).setQuantidade(++qts);
			}

		}

		return qtsNumero;

	}

	// lista a frequencia dos intervalos e sequencias de uma lista de concursos
	public SequenciaIntervaloDTO sequencias(int numero, List<Resultado> resultados) {

		SequenciaIntervaloDTO sequenciaIntervaloDto = new SequenciaIntervaloDTO();

		int sequencia = 0;
		List<SequenciaIntervalo> sequencias = new ArrayList<>();

		int intervalo = 0;
		List<SequenciaIntervalo> intervalos = new ArrayList<>();

		for (Resultado resultado : resultados) {

			if (resultado.getAll().contains(numero)) {

				intervalos.add(new SequenciaIntervalo(numero, resultado.getData(), intervalo));

				intervalo = 0;

				++sequencia;

			} else {

				sequencias.add(new SequenciaIntervalo(numero, resultado.getData(), sequencia));

				sequencia = 0;

				++intervalo;
			}

		}

		SequenciaIntervalo sequenciaMaior = this.maior(sequencias);
		SequenciaIntervalo sequenciaMenor = this.menor(sequencias);

		SequenciaIntervalo intervaloMaior = this.maior(intervalos);
		SequenciaIntervalo intervaloMenor = this.menor(intervalos);

		sequenciaIntervaloDto.setSequencias(sequencias);
		sequenciaIntervaloDto.setDataMaiorSequencia(sequenciaMaior.getData());
		sequenciaIntervaloDto.setMaiorSequencia(sequenciaMaior.getValor());
		sequenciaIntervaloDto.setDataMenorSequencia(sequenciaMenor.getData());
		sequenciaIntervaloDto.setMenorSequencia(sequenciaMenor.getValor());
		sequenciaIntervaloDto.setMediaSequencia(this.media(sequencias));

		sequenciaIntervaloDto.setIntervalos(intervalos);
		sequenciaIntervaloDto.setDataMaiorIntervalo(intervaloMaior.getData());
		sequenciaIntervaloDto.setMaiorIntervalo(intervaloMaior.getValor());
		sequenciaIntervaloDto.setDataMenorIntervalo(intervaloMenor.getData());
		sequenciaIntervaloDto.setMenorIntervalo(intervaloMenor.getValor());
		sequenciaIntervaloDto.setMediaIntervalo(this.media(intervalos));

		return sequenciaIntervaloDto;

	}

	public ImparesDTO numerosImpares(List<Resultado> resultados) {

		List<Frequencia> fre = new ArrayList<>();
		ImparesDTO impar = new ImparesDTO();

		// Lista os impares
		for (Resultado r : resultados) {
			fre.add(new Frequencia("Impar", r.getNumeroImpar(), r.getData()));
		}

		// ordena a lista por maior par no mesmo sorteio
		fre.sort((f1, f2) -> f1.compareTo(f2));

		impar.setMaior(fre.get(0).getFrequencia());
		impar.setDataMaior(fre.get(0).getData());
		impar.setMenor(fre.get(fre.size() - 1).getFrequencia());
		impar.setDataMenor(fre.get(fre.size() - 1).getData());

		// conta numero de frequencia
		Map<Integer, Integer> contagem = new HashMap<Integer, Integer>();

		for (Frequencia valor : fre) {

			if (!contagem.containsKey(valor.getFrequencia())) {
				contagem.put(valor.getFrequencia(), 0);
			}
			contagem.put(valor.getFrequencia(), contagem.get(valor.getFrequencia()) + 1);

		}

		// ordena a frequencia
		fre.clear();

		for (Map.Entry<Integer, Integer> f : contagem.entrySet()) {
			fre.add(new Frequencia(String.valueOf(f.getKey()), f.getValue()));

		}

		fre.sort((f1, f2) -> f1.compareTo(f2));

		impar.setMaiorFrequencia(fre.get(0).getFrequencia());
		impar.setMenorFrequencia(fre.get(fre.size() - 1).getFrequencia());
		impar.setLista(fre);

		return impar;

	}

	// Lista a frequencia dos numeros pares
	public ParesDTO numerosPares(List<Resultado> resultados) {

		List<Frequencia> fre = new ArrayList<>();
		ParesDTO par = new ParesDTO();

		// Lista os pares
		for (Resultado r : resultados) {
			fre.add(new Frequencia("Par", r.getNumeroPar(), r.getData()));
		}

		// ordena a lista por maior par no mesmo sorteio
		fre.sort((f1, f2) -> f1.compareTo(f2));

		par.setMaior(fre.get(0).getFrequencia());
		par.setDataMaior(fre.get(0).getData());
		par.setMenor(fre.get(fre.size() - 1).getFrequencia());
		par.setDataMenor(fre.get(fre.size() - 1).getData());

		// conta numero de frequencia
		Map<Integer, Integer> contagem = new HashMap<Integer, Integer>();

		for (Frequencia valor : fre) {

			if (!contagem.containsKey(valor.getFrequencia())) {
				contagem.put(valor.getFrequencia(), 0);
			}
			contagem.put(valor.getFrequencia(), contagem.get(valor.getFrequencia()) + 1);

		}

		// ordena a frequencia
		fre.clear();

		for (Map.Entry<Integer, Integer> f : contagem.entrySet()) {
			fre.add(new Frequencia(String.valueOf(f.getKey()), f.getValue()));

		}

		fre.sort((f1, f2) -> f1.compareTo(f2));

		par.setMaiorFrequencia(fre.get(0).getFrequencia());
		par.setMenorFrequencia(fre.get(fre.size() - 1).getFrequencia());
		par.setLista(fre);

		return par;
	}

	// Lista qual foi o numero que mais teve combinações passando
	// um numero que a ser analizado e uma lista de concursos
	public List<NumerosSorteados> numerosJuntos(int numero, List<Resultado> resultados) {

		int soma = 0;
		List<NumerosSorteados> ns = new ArrayList<>(25);

		for (int i = 1; i <= 25; i++) {
			soma = 0;

			for (Resultado resultado : resultados) {

				if (resultado.getAll().contains(i) && resultado.getAll().contains(numero)) {

					++soma;

				}

			}
			ns.add(new NumerosSorteados(i, soma));

		}

		return ns;

	}

	// retorna uma lista de frequencia de sequencia e intevalos
	private List<Frequencia> media(List<SequenciaIntervalo> lista) {

		List<Frequencia> fre = new ArrayList<Frequencia>();

		Map<Integer, Integer> contagem = new HashMap<Integer, Integer>();

		for (SequenciaIntervalo valor : lista) {

			if (!contagem.containsKey(valor.getValor())) {
				contagem.put(valor.getValor(), 0);
			}
			contagem.put(valor.getValor(), contagem.get(valor.getValor()) + 1);

		}

		for (Map.Entry<Integer, Integer> f : contagem.entrySet()) {
			fre.add(new Frequencia(String.valueOf(f.getKey()), f.getValue()));

		}

		fre.sort((f1, f2) -> f1.compareTo(f2));

		return fre;

	}

	// Retorna maior valor de uma lista de SequenciaIntervalo
	private SequenciaIntervalo maior(List<SequenciaIntervalo> lista) {

		SequenciaIntervalo si = new SequenciaIntervalo();
		int valor = 0;

		for (SequenciaIntervalo sequenciaIntervalo : lista) {

			if (valor < sequenciaIntervalo.getValor()) {
				valor = sequenciaIntervalo.getValor();
				si.setValor(valor);
				si.setData(sequenciaIntervalo.getData());
				si.setNumero(sequenciaIntervalo.getNumero());
			}
		}

		return si;

	}

	// Retorna menor valor de uma lista de SequenciaIntervalo
	private SequenciaIntervalo menor(List<SequenciaIntervalo> lista) {

		SequenciaIntervalo si = new SequenciaIntervalo();

		int valor;
		si.setValor(0);
		si.setData(lista.get(0).getData());
		si.setNumero(lista.get(0).getNumero());

		if (lista.size() == 0) {
			return null;
		} else {
			valor = lista.get(0).getValor();
		}

		for (SequenciaIntervalo sequenciaIntervalo : lista) {

			if (valor > sequenciaIntervalo.getValor()) {
				valor = sequenciaIntervalo.getValor();
				si.setValor(valor);
				si.setData(sequenciaIntervalo.getData());
				si.setNumero(sequenciaIntervalo.getNumero());

			}
		}

		return si;

	}

}
