package jpa.ch04;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-exercise");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		
		try {
			tx.begin();
			logic(em);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		
		emf.close();
	}

	public static void logic(EntityManager em) {
		String id = "id1";
		Member member = Member.builder()
				.id(id)
				.username("재석")
				.age(2)
				.build();
		
		em.persist(member);
		
		member.setAge(20);
		
		Member findMember = em.find(Member.class, id);
		System.out.println(findMember);
		
		List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
		System.out.println("members.size=" + members.size());
		
		em.remove(member);
	}
}
