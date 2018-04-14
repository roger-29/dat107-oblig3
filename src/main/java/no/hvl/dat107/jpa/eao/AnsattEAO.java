package no.hvl.dat107.jpa.eao;

import java.util.List;

import java.sql.Connection;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import no.hvl.dat107.jpa.entity.Ansatt;


public class AnsattEAO {

	private EntityManagerFactory emf;

	private Connection conn;
	private boolean connected;

	public AnsattEAO() {
		emf = Persistence.createEntityManagerFactory("Oblig3");
	}

	public AnsattEAO(Connection conn) {
		this.conn = conn;

		try {
			if (conn.isValid(10000) == false) {
				connected = true;
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			connected = false;
		}
	}

	public List<Ansatt> finnAlleAnsatte() {
		EntityManager em = emf.createEntityManager();

        List<Ansatt> l = null;
        try {
            TypedQuery<Ansatt> q = em.createQuery("SELECT p FROM Ansatt p", Ansatt.class);
            l = q.getResultList(); 
        } finally {
            em.close();
        }
        return l;
	}

	public Ansatt finnAnsattMedId(String id) {

		EntityManager em = emf.createEntityManager();

		Ansatt person = null;
		
        try {
            person = em.find(Ansatt.class, id);
        } finally {
            em.close();
		}
		
        return person;
		
		/*
		String query = "SELECT * FROM Ansatt WHERE id=" + id +";";

		try {
			conn.prepareStatement(query);

			Ansatt ansatt = new Ansatt();

			return ansatt;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

			if (ex.getErrorCode() == 0) {
				connected = false;
			}

			return null;
		}
		*/
	}

	public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
		String query = "SELECT * FROM Ansatt WHERE id=" + brukernavn +";";

		try {
			conn.prepareStatement(query);

			Ansatt ansatt = new Ansatt();

			return ansatt;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());

			if (ex.getErrorCode() == 0) {
				connected = false;
			}

			return null;
		}
	}

	public boolean oppdaterAnsatt(Ansatt ansatt) {
		// Ikke implementert
		
		return true;
	}
}
