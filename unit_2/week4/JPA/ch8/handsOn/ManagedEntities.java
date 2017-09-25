package client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Actor;

public class ManagedEntities {

	private static void isManaged(Object obj, EntityManager em, String label) {
		String output = em.contains(obj) ? " is managed" : " is detached";
		System.out.println(label + output);
	}

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAVideoStore");
		EntityManager em = emf.createEntityManager();

		System.out.println("Find two actors");
		Actor actor1 = em.find(Actor.class, 1);
		Actor actor2 = em.find(Actor.class, 2);
		isManaged(actor1, em, "Actor 1");
		isManaged(actor2, em, "Actor 2");

		System.out.println("Detach actor #1");
		em.detach(actor1);
		isManaged(actor1, em, "Actor 1");
		isManaged(actor2, em, "Actor 2");

		System.out.println("Merge actor #1 into new variable");
		Actor mergedActor = em.merge(actor1);
		isManaged(actor1, em, "Actor 1");
		isManaged(mergedActor, em, "Actor 1 Merged");
		isManaged(actor2, em, "Actor 2");

		em.close();
		emf.close();
	}
}
