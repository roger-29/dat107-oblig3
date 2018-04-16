package no.hvl.dat107.jpa.eao;

import java.util.List;

import javax.persistence.*;

import no.hvl.dat107.jpa.entity.Ansatt;

public class AnsattEAO {

	private EntityManagerFactory emf;

	public AnsattEAO() {
		emf = Persistence.createEntityManagerFactory("Oblig3");
	}

	public void leggTilAnsatt(Ansatt a) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(a);
			tx.commit();
		} catch(Throwable e){
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}

	public List<Ansatt> finnAlleAnsatte() {
		String queryString = "SELECT a FROM Ansatt a";
		EntityManager em = emf.createEntityManager();
		List<Ansatt> list = null;
		
		try {
			TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return list;
	}

	public Ansatt finnAnsattMedId(int id) {
		EntityManager em = emf.createEntityManager();
		Ansatt ansatt = null;
		
        try {
            ansatt = em.find(Ansatt.class, id);
        } finally {
            em.close();
		}
		
        return ansatt;
	}

	public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
		String query = "SELECT * FROM Ansatt WHERE id=" + brukernavn +";";

		return null;
	}

	public void oppdaterAnsatt(Ansatt ansatt) {
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(ansatt);
			tx.commit();
		} catch (Throwable e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
	}
}
