package no.hvl.dat107.jpa.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Ansatt", schema = "oblig3")
@NamedQuery(name = "hentAlleAnsatte", query = "SELECT p FROM Ansatt p")

public class Ansatt {

	private int id;
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private Date ansettelsesDato;
	private String stilling;
	private int maanedslonn;

	public Ansatt() {
		this(0, "abcd", "Ola", "Nordmann", new Date(0), "Sjef", 12345);
	}

	public Ansatt(int id, String brukernavn, String fornavn, String etternavn, Date ansettelsesDato, String stilling,
			int maanedslonn) {
		this.id = id;
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

	public Date getAnsettelsesDato() {
		return ansettelsesDato;
	}

	public void setAnsettelsesDato(Date ansettelsesDato) {
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

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Ansatt { ID : " + this.id + 
		" | Navn : " + this.fornavn + " " + this.etternavn + 
		" | Stilling : " + this.stilling + " }";
	}
}
