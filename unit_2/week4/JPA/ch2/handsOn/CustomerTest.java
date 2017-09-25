package test;

import static org.junit.Assert.*;
import javax.persistence.*;
import org.junit.*;
import entities.Customer;

public class CustomerTest {
  private EntityManagerFactory emf;
  private EntityManager em;

  @Before
  public void setUp() throws Exception {
    emf = Persistence.createEntityManagerFactory("VideoStore");
    em = emf.createEntityManager();
  }

  @Test
  public void test() {
    Customer cust = em.find(Customer.class, 1);
    assertEquals("Mary", cust.getFirstName());
    assertEquals("Smith", cust.getLastName());
    assertEquals("MARY.SMITH@sdvidcustomer.org", cust.getEmail());
  }

  @Test
  public void test() throws ParseException {
    Customer cust = em.find(Customer.class, 1);
    SimpleDateFormat formatter =
              new SimpleDateFormat("yyyy-MM-dd");
    Date expected = formatter.parse("2014-05-25");
    assertEquals(expected, cust.getCreateDate());
  }

  @After
  public void tearDown() throws Exception {
    em.close();
    emf.close();
  }
}