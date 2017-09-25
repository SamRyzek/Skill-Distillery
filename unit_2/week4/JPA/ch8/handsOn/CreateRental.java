package crud;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Customer;
import entities.InventoryItem;
import entities.Payment;
import entities.Rental;
import entities.Staff;

public class CreateRental {
	public static void main(String[] args) {
		System.out.println("Adding an actor to the database ...");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAVideoStore");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		 System.out.println("Create a new rental...");
//		 Create the rental
         Rental r = new Rental();
         r.setStaff(em.find(Staff.class, 2));
         r.setCustomer(em.find(Customer.class, 2));
         r.setInventoryItem(em.find(InventoryItem.class, 2));
         r.setRentalDate(new Date());
         r.setReturnDate(new Date());
//         Create the payment
         Payment p = new Payment();
         p.setAmount(
              r.getInventoryItem().getFilm().getRentalRate());
         p.setPaymentDate(new Date());
//         Add the payment to the rental's list
         r.addPayment(p);

//         Persist both objects
         em.persist(r);
//         em.persist(p);  // This is not necessary if cascade persist is enabled in Rental payments

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
