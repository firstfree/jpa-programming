package jpa.ch07.s03.identification;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.ch07.s03.identification.entity.IdentifiedChildId;
import jpa.ch07.s03.identification.entity.IdentifiedGrandChild;
import jpa.ch07.s03.identification.entity.IdentifiedGrandChildId;

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
		IdentifiedGrandChild grandChild = em.find(IdentifiedGrandChild.class,
				IdentifiedGrandChildId.builder()
					.child(IdentifiedChildId.builder()
						.parent("parentId1")
						.childId("childId1")
						.build())
					.id("grandChildId1")
					.build());
		
		System.out.println(grandChild);
	}
}
