package no.hvl.dat107.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "Prosjekt", schema = "oblig3")
@NamedQuery(name = "hentAlleAnsatte", query = "SELECT p FROM Ansatt p")

public class Prosjekt {
	
	@Id
	private int prId;



	public int getId() {
		return this.prId;
	}

	@Override
	public String toString() {
		return "Hello";
	}
}
