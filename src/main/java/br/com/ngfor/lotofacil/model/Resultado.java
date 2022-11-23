package br.com.ngfor.lotofacil.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "resultado")
@NamedNativeQuery(name = "Resultado.buscaResultadolimite", query = "SELECT concurso, bola1, bola2, bola3, bola4, bola5, bola6, bola7, bola8,  "
		+ "		    bola9, bola10, bola11, bola12, bola13, bola14, bola15, `data`  " + "         FROM resultado  "
		+ "         order by concurso DESC limit  ?1 ", resultClass = Resultado.class)

@NamedNativeQuery(name = "Resultado.buscaResultadoContemNumero", query = "SELECT concurso, bola1, bola2, bola3, bola4, bola5, bola6, bola7, bola8, "
		+ "		bola9, bola10, bola11, bola12, bola13, bola14, bola15, `data` " + "		FROM resultado  "
		+ "		WHERE bola1 = ?1 OR bola2  = ?1 OR bola3 = ?1 OR bola4  = ?1 "
		+ "		OR bola5  = ?1 OR bola6 = ?1 OR bola7  = ?1  OR bola8  = ?1  "
		+ "		OR bola9 = ?1 OR bola10  = ?1 OR bola11  = ?1 OR bola12 = ?1 "
		+ "		OR bola13  = ?1 OR bola14  = ?1 OR bola15 = ?1 "
		+ "		order by concurso DESC ", resultClass = Resultado.class)

@NamedNativeQuery(name = "Resultado.buscaResultadoIntervaloData", query = "SELECT concurso, bola1, bola2, bola3, bola4, bola5, bola6, bola7, bola8, "
		+ "		bola9, bola10, bola11, bola12, bola13, bola14, bola15, `data` " + "		FROM resultado  "
		+ "		WHERE `data` >= ?1 AND `data` <= ?2 "
		+ "		order by concurso DESC", resultClass = Resultado.class)

public class Resultado {

	@Id
	@Column
	private int concurso;
	@Column
	private LocalDate data;
	@Column
	private int bola1;
	@Column
	private int bola2;
	@Column
	private int bola3;
	@Column
	private int bola4;
	@Column
	private int bola5;
	@Column
	private int bola6;
	@Column
	private int bola7;
	@Column
	private int bola8;
	@Column
	private int bola9;
	@Column
	private int bola10;
	@Column
	private int bola11;
	@Column
	private int bola12;
	@Column
	private int bola13;
	@Column
	private int bola14;
	@Column
	private int bola15;

	public Resultado() {
		super();
	}

	public Resultado(int concurso, String data, int bola1, int bola2, int bola3, int bola4, int bola5, int bola6,
			int bola7, int bola8, int bola9, int bola10, int bola11, int bola12, int bola13, int bola14, int bola15) {
		super();

		DateTimeFormatter formatterIn = DateTimeFormatter.ofPattern("ddMMuuuu");
		DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern("dd/MM/uuuu");

		LocalDate d = LocalDate.parse(data, formatterIn);
		this.data = d;

		this.concurso = concurso;
		this.bola1 = bola1;
		this.bola2 = bola2;
		this.bola3 = bola3;
		this.bola4 = bola4;
		this.bola5 = bola5;
		this.bola6 = bola6;
		this.bola7 = bola7;
		this.bola8 = bola8;
		this.bola9 = bola9;
		this.bola10 = bola10;
		this.bola11 = bola11;
		this.bola12 = bola12;
		this.bola13 = bola13;
		this.bola14 = bola14;
		this.bola15 = bola15;
	}

	public void addAll(List<Integer> bolas) {

		this.bola1 = bolas.get(0);
		this.bola2 = bolas.get(1);
		this.bola3 = bolas.get(2);
		this.bola4 = bolas.get(3);
		this.bola5 = bolas.get(4);
		this.bola6 = bolas.get(5);
		this.bola7 = bolas.get(6);
		this.bola8 = bolas.get(7);
		this.bola9 = bolas.get(8);
		this.bola10 = bolas.get(9);
		this.bola11 = bolas.get(10);
		this.bola12 = bolas.get(11);
		this.bola13 = bolas.get(12);
		this.bola14 = bolas.get(13);
		this.bola15 = bolas.get(14);

	}

	public List<Integer> getAll() {
		List<Integer> bolas = new ArrayList<Integer>();

		bolas.add(this.bola1);
		bolas.add(this.bola2);
		bolas.add(this.bola3);
		bolas.add(this.bola4);
		bolas.add(this.bola5);
		bolas.add(this.bola6);
		bolas.add(this.bola7);
		bolas.add(this.bola8);
		bolas.add(this.bola9);
		bolas.add(this.bola10);
		bolas.add(this.bola11);
		bolas.add(this.bola12);
		bolas.add(this.bola13);
		bolas.add(this.bola14);
		bolas.add(this.bola15);

		return bolas;
	}

	public int getConcurso() {
		return concurso;
	}

	public void setConcurso(int concurso) {
		this.concurso = concurso;
	}

	public String getData() {

		DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		return formatterOut.format(this.data);

	}

	public void setData(String data) {

		DateTimeFormatter formatterIn = DateTimeFormatter.ofPattern("ddMMuuuu");
		DateTimeFormatter formatterOut = DateTimeFormatter.ofPattern("dd/MM/uuuu");

		LocalDate d = LocalDate.parse(data, formatterIn);
		this.data = d;
	}

	public int getBola1() {
		return bola1;
	}

	public void setBola1(int bola1) {
		this.bola1 = bola1;
	}

	public int getBola2() {
		return bola2;
	}

	public void setBola2(int bola2) {
		this.bola2 = bola2;
	}

	public int getBola3() {
		return bola3;
	}

	public void setBola3(int bola3) {
		this.bola3 = bola3;
	}

	public int getBola4() {
		return bola4;
	}

	public void setBola4(int bola4) {
		this.bola4 = bola4;
	}

	public int getBola5() {
		return bola5;
	}

	public void setBola5(int bola5) {
		this.bola5 = bola5;
	}

	public int getBola6() {
		return bola6;
	}

	public void setBola6(int bola6) {
		this.bola6 = bola6;
	}

	public int getBola7() {
		return bola7;
	}

	public void setBola7(int bola7) {
		this.bola7 = bola7;
	}

	public int getBola8() {
		return bola8;
	}

	public void setBola8(int bola8) {
		this.bola8 = bola8;
	}

	public int getBola9() {
		return bola9;
	}

	public void setBola9(int bola9) {
		this.bola9 = bola9;
	}

	public int getBola10() {
		return bola10;
	}

	public void setBola10(int bola10) {
		this.bola10 = bola10;
	}

	public int getBola11() {
		return bola11;
	}

	public void setBola11(int bola11) {
		this.bola11 = bola11;
	}

	public int getBola12() {
		return bola12;
	}

	public void setBola12(int bola12) {
		this.bola12 = bola12;
	}

	public int getBola13() {
		return bola13;
	}

	public void setBola13(int bola13) {
		this.bola13 = bola13;
	}

	public int getBola14() {
		return bola14;
	}

	public void setBola14(int bola14) {
		this.bola14 = bola14;
	}

	public int getBola15() {
		return bola15;
	}

	public void setBola15(int bola15) {
		this.bola15 = bola15;
	}

	public int getNumeroPar() {

		int nPar = 0;

		for (Integer n : this.getAll()) {
			if (n % 2 == 0) {
				nPar++;
			}
		}
		return nPar;
	}

	public int getNumeroImpar() {
		int nImpar = 0;

		for (Integer n : this.getAll()) {
			if (n % 2 != 0) {
				nImpar++;
			}
		}
		return nImpar;
	}

	public int compareTo(Resultado outroResultado) {
		if (this.concurso < outroResultado.getConcurso()) {
			return -1;
		}
		if (this.concurso > outroResultado.getConcurso()) {
			return 1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(concurso);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resultado other = (Resultado) obj;
		return concurso == other.concurso;
	}

	@Override
	public String toString() {
		return "Resultado [concurso=" + concurso + ", data=" + data + ", bola1=" + bola1 + ", bola2=" + bola2
				+ ", bola3=" + bola3 + ", bola4=" + bola4 + ", bola5=" + bola5 + ", bola6=" + bola6 + ", bola7=" + bola7
				+ ", bola8=" + bola8 + ", bola9=" + bola9 + ", bola10=" + bola10 + ", bola11=" + bola11 + ", bola12="
				+ bola12 + ", bola13=" + bola13 + ", bola14=" + bola14 + ", bola15=" + bola15 + ", numeroPar="
				+ getNumeroPar() + ", numeroImpar=" + getNumeroImpar() + "]";
	}

}