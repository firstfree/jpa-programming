package jpa.ch07.s02;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.ch07.s02.entity.Member;
import jpa.ch07.s02.entity.Seller;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-exercise");
		EntityManager em = emf.createEntityManager();
		EntityTransaction ex = em.getTransaction();
		
		try {
			ex.begin();
			logic(em);
			ex.commit();
		} catch(Exception e) {
			e.printStackTrace();
			ex.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}
	
	public static void logic(EntityManager em) {
		Member member = Member.builder()
				.name("js")
				.email("aB31fEfdee9E@hotmail.com")
				.build();
		
		em.persist(member);
		
		Seller seller = Seller.builder()
				.name("hanny")
				.shopName("Bakers")
				.build();
		
		em.persist(seller);
		
		member.setName("kong");
		
		em.remove(member);
		em.remove(seller);
	}
}
