package client;

import javax.persistence.*;
import entities.Customer;

public class CustomerClient {
  public static void main(String[] args) {
    System.out.println("Finding a customer...");

    // Create EntityManager from persistence unit/EntityManagerFactory
    EntityManagerFactory emf =
      Persistence.createEntityManagerFactory("VideoStore");
    EntityManager em = emf.createEntityManager();

    // Use EntityManager to retrieve managed Customer object with id 1
    Customer cust = em.find(Customer.class, 1);
    System.out.println(cust);

    // Clean up...
    em.close();
    em.close();
  }
}