package jpa.ch07.s03.nonidentification;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.ch07.s03.nonidentification.entity.Board;
import jpa.ch07.s03.nonidentification.entity.BoardDetail;
import jpa.ch07.s03.nonidentification.entity.GrandChild;

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
		Board board = Board.builder().title("제목").build();
		em.persist(board);
		
		BoardDetail boardDetail = BoardDetail.builder().board(board).content("내용").build();
		em.persist(boardDetail);
	}
}
