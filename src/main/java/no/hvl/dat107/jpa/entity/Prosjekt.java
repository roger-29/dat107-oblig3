package no.hvl.dat107.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Prosjekt", schema = "oblig3")
@NamedQuery(name = "hentAlleAnsatte", query = "SELECT p FROM Ansatt p")

public class Prosjekt {
	

	@Override
	public String toString() {
		return "Hello";
	}
}
