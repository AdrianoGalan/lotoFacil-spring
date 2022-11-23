package br.com.ngfor.lotofacil.model;

public class SequenciaIntervalo {

	private int numero;
	private String data;
	private int valor;
	

	public SequenciaIntervalo() {
		super();
	}

	public SequenciaIntervalo(SequenciaIntervalo si) {
		this.numero = si.getNumero();
		this.data = si.getData();
		this.valor = si.getValor();
	}

	public SequenciaIntervalo(int numero, String data, int valor) {
		super();
		this.numero = numero;
		this.data = data;
		this.valor = valor;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "SequenciaIntervalo [numero=" + numero + ", data=" + data + ", valor=" + valor + "]";
	}

}
