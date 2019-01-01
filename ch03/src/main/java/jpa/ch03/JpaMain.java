package jpa.ch03;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-exercise");

	public static void main(String[] args) {
		Member member = createMember("memberA", "회원1");

		member.setUsername("회원명변경");
		
		mergeMember(member);
	}

	static Member createMember(String id, String username) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Member member = Member.builder()
				.id(id)
				.username(username)
				.build();
		
		em.persist(member);
		
		tx.commit();
		
		em.close();
		
		return member;
	}
	
	static void mergeMember(Member member) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		Member mergeMember = em.merge(member);
		
		tx.commit();
		
		System.out.println("member = " + member.getUsername());
		
		System.out.println("mergeMember = " + mergeMember.getUsername());
		
		System.out.println("em contains member = " + em.contains(member));
		
		System.out.println("em contains mergeMember = " + em.contains(mergeMember));
		
		em.close();
	}
}
