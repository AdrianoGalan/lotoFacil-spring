package br.com.ngfor.lotofacil.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Frequencia {

	private String chave;
	private int frequencia;
	private String data;

	public Frequencia() {
		super();
	}

	public Frequencia(String chave, int frequencia, String data) {
		super();
		this.chave = chave;
		this.frequencia = frequencia;
		this.data = data;
	}

	public Frequencia(String chave, int frequencia) {
		super();
		this.chave = chave;
		this.frequencia = frequencia;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public int getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(int frequencia) {
		this.frequencia = frequencia;
	}

	public String getData() {

		if (this.data != null && this.data != "") {

			DateTimeFormatter formatterIn = DateTimeFormatter.ofPattern("ddMMuuuu");
			DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern("dd/MM/uuuu");

			if (data.length() < 8) {
				LocalDate d = LocalDate.parse(data, formatterIn);
				return d.format(formatterOut);
			}

		}

		return data;

	}

	public void setData(String data) {
		this.data = data;
	}

	public int compareTo(Frequencia outro) {
		if (this.frequencia < outro.getFrequencia()) {
			return 0;
		}
		if (this.frequencia > outro.getFrequencia()) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Frequencia [chave=" + chave + ", frequencia=" + frequencia + "]";
	}

}
