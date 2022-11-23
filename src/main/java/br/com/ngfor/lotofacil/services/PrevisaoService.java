package br.com.ngfor.lotofacil.services;

import org.springframework.stereotype.Service;

import br.com.ngfor.lotofacil.algoritmo.AlgoritmoPrevisao;

@Service
public class PrevisaoService {

	private AlgoritmoPrevisao ap;

	public PrevisaoService(AlgoritmoPrevisao ap) {
		super();
		this.ap = ap;
	}

	public void algoritmo1() {
		this.ap.algoritmo1();
	}

}
