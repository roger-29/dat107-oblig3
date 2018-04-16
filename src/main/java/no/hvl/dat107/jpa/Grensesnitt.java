package no.hvl.dat107.jpa;

import javax.persistence.*;

import no.hvl.dat107.jpa.eao.*;
import no.hvl.dat107.jpa.entity.Ansatt;
import no.hvl.dat107.jpa.entity.Avdeling;

public class Grensesnitt {

	private AnsattEAO ansattEAO;
	private AvdelingEAO avdelingEAO;
	private ProsjektEAO prosjektEAO;
	private AnsattProsjektEAO ansattProsjektEAO;

	public Grensesnitt() {
		this.ansattEAO = new AnsattEAO();
		this.avdelingEAO = new AvdelingEAO();
		this.prosjektEAO = new ProsjektEAO();
		this.ansattProsjektEAO = new AnsattProsjektEAO();
	}

	private void clear() {
		// Tøm konsollvindu
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public void start() {

		clear();

		System.out.println("Velkommen til Obligatorisk innlevering 3, i DAT107\n");

		Ansatt test = ansattEAO.finnAnsattMedId(1);
		System.out.println(test.getBrukernavn());

		// Start meny-løkke
		boolean done = false;
		while (!done) {
			done = this.meny();
		}
	}

	private boolean meny() {
		System.out.println("Følgende valg er tilgjengelige:\n");

		System.out.println("  1. Se alle ansatte");
		System.out.println("  2. Se alle avdelinger");
		System.out.println("  3. Se alle prosjekter\n");

		System.out.println("  4. Legg til ansatt");
		System.out.println("  5. Legg til avdeling");
		System.out.println("  6. Legg til prosjekt\n");

		System.out.println("  7. Fjern ansatt");
		System.out.println("  8. Fjern avdeling");
		System.out.println("  9. Fjern prosjekt\n");

		System.out.println(" 10. Avslutt program");

		System.out.println("\nSkriv inn tallet ved ditt ønskede valg");

		int input;

		try {
			input = Integer.parseInt(receiveInput());
		} catch (NumberFormatException ex) {
			System.out.println("\nSkriv inn et tall.\n");
			return false;
		}

		switch (input) {
		case 1:
			System.out.println("\nIkke implementert.\n");
			break;
		case 2:
			System.out.println("\nIkke implementert.\n");
			break;
		case 3:
			System.out.println("\nIkke implementert.\n");
			break;
		case 4:
			leggTilAnsatt();
			break;
		case 5:
			System.out.println("\nIkke implementert.\n");
			break;
		case 6:
			System.out.println("\nIkke implementert.\n");
			break;
		case 7:
			System.out.println("\nIkke implementert.\n");
			break;
		case 8:
			System.out.println("\nIkke implementert.\n");
			break;
		case 9:
			System.out.println("\nIkke implementert.\n");
			break;
		case 10:
			System.out.println("\nProgrammet avsluttes...\n");
			return true;
		default:
			System.out.println("\nUgyldig valg, prøv igjen...\n");
		}

		clear();
		return false;
	}

	private void leggTilAnsatt() {
		clear();
		System.out.println("Legg til ansatt\n");

		Ansatt a = new Ansatt();

		System.out.println("Fornavn?");
		a.setFornavn(receiveInput());

		System.out.println("Etternavn?");
		a.setEtternavn(receiveInput());

		System.out.println("Stilling?");
		a.setEtternavn(receiveInput());

		System.out.println("Månedslønn?");
		boolean done = false;
		while (!done) {
			try {
				a.setMaanedslonn(Integer.parseInt(receiveInput()));
				done = true;
			} catch (NumberFormatException ex) {
				System.out.println("Skriv inn et gyldig tall.");
			}
		}

		System.out.println("Etternavn?");
		a.setEtternavn(receiveInput());

		ansattEAO.leggTilAnsatt(a);
	}

	private String receiveInput() {
		System.out.print("> ");
		String s = System.console().readLine();
		System.out.println();

		return s;
	}
}
