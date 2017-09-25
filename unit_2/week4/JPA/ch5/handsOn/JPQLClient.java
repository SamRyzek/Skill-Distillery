package client;

import java.util.List;
import javax.persistence.*;
import entities.Staff;

public class JPQLClient {
  public static void main(String[] args) {
    EntityManagerFactory emf =
    Persistence.createEntityManagerFactory("VideoStore");

    EntityManager em = emf.createEntityManager();

    String queryString = "SELECT s FROM Staff s WHERE s.id < 10";

    List<Staff> results = em.createQuery(queryString,Staff.class).getResultList();

    for (Staff result : results) {
      System.out.println(result.getLastName());
    }

    //String queryString = "SELECT s.lastName FROM Staff s WHERE s.id < 10";

    //List<String> results =
    //em.createQuery(queryString,String.class).getResultList();

    //for (String result : results) {
    //  System.out.println(result);
    //}

    em.close();
    emf.close();
  }
}
