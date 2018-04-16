package no.hvl.dat107.jpa.eao;

import java.util.List;
import javax.persistence.*;

import no.hvl.dat107.jpa.entity.Prosjekt;

public class ProsjektEAO {

	private EntityManagerFactory emf;

	public ProsjektEAO() {
        emf = Persistence.createEntityManagerFactory("Oblig3");
	}
	
	public Prosjekt finnProsjektMedId(int id) {
        EntityManager em = emf.createEntityManager();
		Prosjekt p = null;
		
        try {
            p = em.find(Prosjekt.class, id);
        } finally {
            em.close();
		}
		
        return p;
	}
	
	public List<Prosjekt> hentAlleProsjekter() {
		EntityManager em = emf.createEntityManager();
		List<Prosjekt> prosjekter = null;

		try {
			TypedQuery<Prosjekt> query = em.createQuery("SELECT p FROM Prosjekt p ORDER BY p.prId", Prosjekt.class);
			prosjekter = query.getResultList();
		} finally {
			em.close();
		}
		
		return prosjekter;
	}

	public int leggTilProsjekt(Prosjekt p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.persist(p);
			tx.commit();
		} finally {
			em.close();
		}
		
		return p.getId();
	}

	public void oppdaterProsjekt(Prosjekt p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			em.merge(p);
			tx.commit();
		} finally {
			em.close();
		}
	}

	public void fjernProsjekt(Prosjekt p) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			p = em.merge(p);
			em.remove(p);
			tx.commit();
		} finally {
			em.close();
		}
	}	
}
