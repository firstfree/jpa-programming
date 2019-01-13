package jpa.ch07.s03.identification;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.ch07.s03.identification.entity.ChildId;
import jpa.ch07.s03.identification.entity.GrandChild;
import jpa.ch07.s03.identification.entity.GrandChildId;

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
		GrandChild grandChild = em.find(GrandChild.class,
				GrandChildId.builder()
					.childId(ChildId.builder()
						.parentId("parentId")
						.id("childId")
						.build())
					.id("grandChildId")
					.build());
		
		System.out.println(grandChild);
	}
}
