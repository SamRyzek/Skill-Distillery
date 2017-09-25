package dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import entities.Customer;

@Transactional
@Repository
public class VideoDaoJPAImpl implements VideoDao {
  
  @PersistenceContext
  private EntityManager em;

  @Override
  public Customer getCustomer(int id) {
    Customer cust = em.find(Customer.class, id);
    return cust;
  } 
}