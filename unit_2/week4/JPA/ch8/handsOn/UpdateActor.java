package crud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Actor;

public class UpdateActor {
	public static void main(String[] args) {
		System.out.println("Updating an actor in the database ...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAVideoStore");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Actor a = em.find(Actor.class, 200);
		a.setFirstName("Shirley");

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
