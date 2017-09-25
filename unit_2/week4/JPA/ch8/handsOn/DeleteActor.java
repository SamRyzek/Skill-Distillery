package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Actor;

public class DeleteActor {
	public static void main(String[] args) {
		System.out.println("Deleting an actor from the database ...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAVideoStore");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Actor a = em.find(Actor.class, 201);
		em.remove(a);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
