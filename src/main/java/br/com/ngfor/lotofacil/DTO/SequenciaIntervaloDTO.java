package br.com.ngfor.lotofacil.DTO;

import java.util.List;

import br.com.ngfor.lotofacil.model.Frequencia;
import br.com.ngfor.lotofacil.model.SequenciaIntervalo;

public class SequenciaIntervaloDTO {

	private List<SequenciaIntervalo> sequencias;
	private int maiorSequencia;
	private String dataMaiorSequencia;
	private int menorSequencia;
	private String dataMenorSequencia;
	private List<Frequencia> mediaSequencia;

	private List<SequenciaIntervalo> intervalos;
	private int maiorIntervalo;
	private String dataMaiorIntervalo;
	private int menorIntervalo;
	private String dataMenorIntervalo;
	private List<Frequencia> mediaIntervalo;

	public SequenciaIntervaloDTO() {
		super();
	}

	public SequenciaIntervaloDTO(List<SequenciaIntervalo> sequencias, int maiorSequencia, String dataMaiorSequencia,
			int menorSequencia, String dataMenorSequencia, List<Frequencia> mediaSequencia,
			List<SequenciaIntervalo> intervalos, int maiorIntervalo, String dataMaiorIntervalo, int menorIntervalo,
			String dataMenorIntervalo, List<Frequencia> mediaIntervalo) {
		super();
		this.sequencias = sequencias;
		this.maiorSequencia = maiorSequencia;
		this.dataMaiorSequencia = dataMaiorSequencia;
		this.menorSequencia = menorSequencia;
		this.dataMenorSequencia = dataMenorSequencia;
		this.mediaSequencia = mediaSequencia;
		this.intervalos = intervalos;
		this.maiorIntervalo = maiorIntervalo;
		this.dataMaiorIntervalo = dataMaiorIntervalo;
		this.menorIntervalo = menorIntervalo;
		this.dataMenorIntervalo = dataMenorIntervalo;
		this.mediaIntervalo = mediaIntervalo;
	}

	public List<SequenciaIntervalo> getSequencias() {
		return sequencias;
	}

	public void setSequencias(List<SequenciaIntervalo> sequencias) {
		this.sequencias = sequencias;
	}

	public int getMaiorSequencia() {
		return maiorSequencia;
	}

	public void setMaiorSequencia(int maiorSequencia) {
		this.maiorSequencia = maiorSequencia;
	}

	public String getDataMaiorSequencia() {
		return dataMaiorSequencia;
	}

	public void setDataMaiorSequencia(String dataMaiorSequencia) {
		this.dataMaiorSequencia = dataMaiorSequencia;
	}

	public int getMenorSequencia() {
		return menorSequencia;
	}

	public void setMenorSequencia(int menorSequencia) {
		this.menorSequencia = menorSequencia;
	}

	public String getDataMenorSequencia() {
		return dataMenorSequencia;
	}

	public void setDataMenorSequencia(String dataMenorSequencia) {
		this.dataMenorSequencia = dataMenorSequencia;
	}

	public List<Frequencia> getMediaSequencia() {
		return mediaSequencia;
	}

	public void setMediaSequencia(List<Frequencia> mediaSequencia) {
		this.mediaSequencia = mediaSequencia;
	}

	public List<SequenciaIntervalo> getIntervalos() {
		return intervalos;
	}

	public void setIntervalos(List<SequenciaIntervalo> intervalos) {
		this.intervalos = intervalos;
	}

	public int getMaiorIntervalo() {
		return maiorIntervalo;
	}

	public void setMaiorIntervalo(int maiorIntervalo) {
		this.maiorIntervalo = maiorIntervalo;
	}

	public String getDataMaiorIntervalo() {
		return dataMaiorIntervalo;
	}

	public void setDataMaiorIntervalo(String dataMaiorIntervalo) {
		this.dataMaiorIntervalo = dataMaiorIntervalo;
	}

	public int getMenorIntervalo() {
		return menorIntervalo;
	}

	public void setMenorIntervalo(int menorIntervalo) {
		this.menorIntervalo = menorIntervalo;
	}

	public String getDataMenorIntervalo() {
		return dataMenorIntervalo;
	}

	public void setDataMenorIntervalo(String dataMenorIntervalo) {
		this.dataMenorIntervalo = dataMenorIntervalo;
	}

	public List<Frequencia> getMediaIntervalo() {
		return mediaIntervalo;
	}

	public void setMediaIntervalo(List<Frequencia> mediaIntervalo) {
		this.mediaIntervalo = mediaIntervalo;
	}

	@Override
	public String toString() {
		return "SequenciaIntervaloDTO [sequencias=" + sequencias + ", maiorSequencia=" + maiorSequencia
				+ ", dataMaiorSequencia=" + dataMaiorSequencia + ", menorSequencia=" + menorSequencia
				+ ", dataMenorSequencia=" + dataMenorSequencia + ", mediaSequencia=" + mediaSequencia + ", intervalos="
				+ intervalos + ", maiorIntervalo=" + maiorIntervalo + ", dataMaiorIntervalo=" + dataMaiorIntervalo
				+ ", menorIntervalo=" + menorIntervalo + ", dataMenorIntervalo=" + dataMenorIntervalo
				+ ", mediaIntervalo=" + mediaIntervalo + "]";
	}

}
