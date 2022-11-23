package br.com.ngfor.lotofacil.model;

import java.text.DecimalFormat;

public class Previsao {

	private int numero;
	private double ponto;

	public Previsao() {

	}

	public Previsao(int numero, double ponto) {
		super();
		this.numero = numero;
		this.ponto = ponto;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public double getPonto() {
		return ponto;
	}

	public void setPonto(double ponto) {
		this.ponto = ponto;
	}
	
	public int compareTo(Previsao outraPrevisao) {
		if (this.ponto < outraPrevisao.getPonto()) {
			return 1;
		}
		if (this.ponto > outraPrevisao.getPonto()) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("##.00");
		return "Previsao [numero=" + numero + ", ponto=" + df.format(ponto) + "]";
	}

}
