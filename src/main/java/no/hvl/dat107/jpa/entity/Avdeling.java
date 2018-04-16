package no.hvl.dat107.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "Avdeling", schema = "oblig3")
public class Avdeling {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int avdId;
	
	private String navn;
	private Ansatt sjef;

	public Avdeling() {
		this(0, "Prosjekt", new Ansatt());
	}

	public Avdeling(int id, String navn, Ansatt sjef) {
		this.avdId = id;
		this.navn = navn;
		this.sjef = sjef;
	}

	public int getId() {
		return this.avdId;
	}

	@Override
	public String toString() {
		return "Avdeling { \n	ID : " + this.avdId + 
		" | Navn : " + this.navn + 
		" | Sjef : { " + this.sjef.toString() + 
		" } \n}";
	}
}
