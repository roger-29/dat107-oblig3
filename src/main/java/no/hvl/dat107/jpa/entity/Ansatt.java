package no.hvl.dat107.jpa.entity;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name = "Ansatt", schema = "oblig3")
public class Ansatt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansId;

	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansettelsesDato;
	private String stilling;
	private int maanedslonn;

	@ManyToOne
	@JoinColumn(name = "AvdId")
	private Avdeling avdeling;

	public Ansatt() {
		this(0, "abcd", "Ola", "Nordmann", LocalDate.now(), "Sjef", 12345);
	}

	public Ansatt(int id, String brukernavn, String fornavn, String etternavn, LocalDate ansettelsesDato, String stilling,
			int maanedslonn) {
		this.ansId = id;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansettelsesDato = ansettelsesDato;
		this.stilling = stilling;
		this.maanedslonn = maanedslonn;
	}

	public int getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(int maanedslonn) {
		this.maanedslonn = maanedslonn;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public LocalDate getAnsettelsesDato() {
		return ansettelsesDato;
	}

	public void setAnsettelsesDato(LocalDate ansettelsesDato) {
		this.ansettelsesDato = ansettelsesDato;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public int getId() {
		return ansId;
	}

	public void setId(int id) {
		this.ansId = id;
	}

	@Override
	public String toString() {
		return "Ansatt { ID : " + this.ansId + 
		" | Navn : " + this.fornavn + " " + this.etternavn + 
		" | Stilling : " + this.stilling + " }";
	}
}
