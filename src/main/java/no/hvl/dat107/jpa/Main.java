package no.hvl.dat107.jpa;

import no.hvl.dat107.jpa.eao.AnsattEAO;
import no.hvl.dat107.jpa.eao.AvdelingEAO;
import no.hvl.dat107.jpa.eao.ProsjektEAO;

import no.hvl.dat107.jpa.entity.Ansatt;
import no.hvl.dat107.jpa.entity.Avdeling;

public class Main {

	public static void test() {
		Ansatt s = new Ansatt();
		Avdeling a = new Avdeling(1, "Test", s);

		System.out.println(a.toString());
	}

	public static void main(String[] args) {
		test();

		try {

			AnsattEAO ansattEAO = new AnsattEAO();
			AvdelingEAO avdelingEAO = new AvdelingEAO();
			ProsjektEAO prosjektEAO = new ProsjektEAO();

		} catch (Exception ex) {

		}
		

	}
}
