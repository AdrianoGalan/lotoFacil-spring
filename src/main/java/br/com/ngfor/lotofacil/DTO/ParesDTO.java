package br.com.ngfor.lotofacil.DTO;

import java.util.List;

import br.com.ngfor.lotofacil.model.Frequencia;

public class ParesDTO {

	private int maior;
	private String dataMaior;
	private int maiorFrequencia;

	private int menor;
	private String dataMenor;
	private int menorFrequencia;

	private List<Frequencia> lista;

	public ParesDTO() {

	}

	public ParesDTO(int maior, String dataMaior, int maiorFrequencia, int menor, String dataMenor, int menorFrequencia,
			List<Frequencia> lista) {
		super();
		this.maior = maior;
		this.dataMaior = dataMaior;
		this.maiorFrequencia = maiorFrequencia;
		this.menor = menor;
		this.dataMenor = dataMenor;
		this.menorFrequencia = menorFrequencia;
		this.lista = lista;
	}

	public int getMaior() {
		return maior;
	}

	public void setMaior(int maior) {
		this.maior = maior;
	}

	public String getDataMaior() {
		return dataMaior;
	}

	public void setDataMaior(String dataMaior) {
		this.dataMaior = dataMaior;
	}

	public int getMaiorFrequencia() {
		return maiorFrequencia;
	}

	public void setMaiorFrequencia(int maiorFrequencia) {
		this.maiorFrequencia = maiorFrequencia;
	}

	public int getMenor() {
		return menor;
	}

	public void setMenor(int menor) {
		this.menor = menor;
	}

	public String getDataMenor() {
		return dataMenor;
	}

	public void setDataMenor(String dataMenor) {
		this.dataMenor = dataMenor;
	}

	public int getMenorFrequencia() {
		return menorFrequencia;
	}

	public void setMenorFrequencia(int menorFrequencia) {
		this.menorFrequencia = menorFrequencia;
	}

	public List<Frequencia> getLista() {
		return lista;
	}

	public void setLista(List<Frequencia> lista) {
		this.lista = lista;
	}

	@Override
	public String toString() {
		return "ParesDTO [maior=" + maior + ", dataMaior=" + dataMaior + ", maiorFrequencia=" + maiorFrequencia
				+ ", menor=" + menor + ", dataMenor=" + dataMenor + ", menorFrequencia=" + menorFrequencia + ", lista="
				+ lista + "]";
	}
	
	

}
