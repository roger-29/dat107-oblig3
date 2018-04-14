package no.hvl.dat107.jpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table()
@DiscriminatorValue(value = "S")

public class Avdeling {
	private int id;
	private String navn;
	private Ansatt sjef;

	public Avdeling() {
		this(0, "Prosjekt", new Ansatt());
	}

	public Avdeling(int id, String navn, Ansatt sjef) {
		this.id = id;
		this.navn = navn;
		this.sjef = sjef;
	}

	@Override
	public String toString() {
		return "Avdeling { \n	ID : " + this.id + 
		" | Navn : " + this.navn + 
		" | Sjef : { " + this.sjef.toString() + 
		" } \n}";
	}
}
