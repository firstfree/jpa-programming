package jpa.ch07.s04.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-exercise");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction ex = em.getTransaction();
		
		try {
			ex.begin();
			logic(em);
			ex.commit();
		} catch (Exception e) {
			e.printStackTrace();
			ex.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}
	
	public static void logic(EntityManager em) {
	}
}
