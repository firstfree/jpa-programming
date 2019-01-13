package jpa.market;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa.market.entity.Delivery;
import jpa.market.entity.Order;
import jpa.market.entity.OrderItem;

public class Main {
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-market");
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
	
	private static void logic(EntityManager em) {
		Delivery delivery = new Delivery();
		OrderItem orderItem1 = new OrderItem();
		OrderItem orderItem2 = new OrderItem();
		
		Order order = new Order();
		order.setDelivery(delivery);
		order.addOrderItem(orderItem1);
		order.addOrderItem(orderItem2);
		
		em.persist(order);
	}
}
