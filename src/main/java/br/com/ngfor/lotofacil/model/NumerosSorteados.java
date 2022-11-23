package br.com.ngfor.lotofacil.model;

public class NumerosSorteados {

	private int numero;
	private int quantidade;

	public NumerosSorteados() {
		super();
	}

	public NumerosSorteados(int numero, int quantidade) {
		super();
		this.numero = numero;
		this.quantidade = quantidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int compareTo(NumerosSorteados outroNumero) {
		if (this.quantidade > outroNumero.getQuantidade()) {
			return -1;
		}
		if (this.quantidade < outroNumero.getQuantidade()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "NumerosSorteados [numero=" + numero + ", quantidade=" + quantidade + "]";
	}

}
