package jpa.ch07.s01.join;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.ch07.s01.join.entity.Album;
import jpa.ch07.s01.join.entity.Book;
import jpa.ch07.s01.join.entity.Item;
import jpa.ch07.s01.join.entity.Movie;

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
				.name("The Man")
				.price(25000)
				.artist("js")
				.build();
		
		em.persist(album);

		Movie movie = Movie.builder()
				.name("Betman")
				.price(10000)
				.director("John")
				.actor("Mark")
				.build();
		
		em.persist(movie);
		
		Book book = Book.builder()
				.name("Book")
				.price(15000)
				.author("Sane")
				.isbn("10010-isbn")
				.build();
		
		em.persist(book);
		
		List<Item> items = em.createQuery("select i from Item i", Item.class).getResultList();
		System.out.println(items);
		
		em.remove(album);
		em.remove(movie);
		em.remove(book);
	}
}
