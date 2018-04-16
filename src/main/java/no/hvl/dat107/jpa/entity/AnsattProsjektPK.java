package no.hvl.dat107.jpa.entity;

public class AnsattProsjektPK {

	private int ansattId;
	private int prosjektId;

	public AnsattProsjektPK(Ansatt a, Prosjekt p) {
		this.ansattId = a.getId();
		this.prosjektId = p.getId();
	}
}
