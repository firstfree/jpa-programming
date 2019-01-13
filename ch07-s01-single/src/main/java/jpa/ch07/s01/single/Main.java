package jpa.ch07.s01.single;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.ch07.s01.single.entity.Item;
import jpa.ch07.s01.single.entity.Movie;
import jpa.ch07.s01.single.entity.Album;
import jpa.ch07.s01.single.entity.Book;

public class Main {
	
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
		Album album = Album.builder()
				.name("Song")
				.price(10000)
				.artist("js")
				.build();
		
		em.persist(album);
		
		Movie movie = Movie.builder()
				.name("Betman")
				.price(8000)
				.director("J")
				.actor("Ti")
				.build();
		
		em.persist(movie);
		
		Book book = Book.builder()
				.name("Mountain")
				.price(15000)
				.author("Shanzes")
				.isbn("123123-isbn")
				.build();
		
		em.persist(book);
		
		List<Item> items = em.createQuery("select i from Item i", Item.class).getResultList();
		System.out.println(items);
		
		em.remove(album);
		em.remove(movie);
		em.remove(book);
	}
}
