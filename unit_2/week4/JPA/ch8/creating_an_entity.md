# Creating an Entity

* When you create a new entity instance, it is initially detached.
  
  * Call `EntityManager.persist()` to make it a managed entity.
  
  * On the next _commit_ it will be `INSERT`ed to the database.

* When working in a Java SE application, use `EntityManager.getTransaction()` to get an *EntityTransaction* object.
  
  * Use `EntityTransaction.begin()` to start a new transaction.
  
  * Use `commit()` to _commit_ or `rollback()` to _rollback_ the transaction.

* Here is the previous example illustrating how these pieces fit together:

```java
public class CustomerDAOImpl implements CustomerDAO {
  public Customer create(Customer customer) {
    EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory("VideoStore");
    EntityManager em = emf.createEntityManager();

    // start the transaction
    em.getTransaction().begin();
    // write the customer to the database
    em.persist(customer);
    // update the "local" ("detached") 'customer' object
    em.flush();
    // commit the changes (actually perform the operation)
    em.getTransaction().commit();

    // return the full "managed" customer object
    return customer;
  }
}
```

### Hands On
1: Create a new package in the *src* directory named *data*.
  
  * Create two files inside of the *data* package*

    * an interface named *ActorDAO*
    
    * a class named *ActorDAOImpl*

2: In *ActorDAO* create a method stub:

  * `public Actor create(Actor actor);`

3: Implement the `create` method in your *ActorDAOImpl*.

  * Use a transaction to persist the detached entity.

  * be sure to commit the transaction.

X: Usually we would write some integration tests for the DAO. At the moment, we don't have all the tools we will ultimately use to do so, as such, we won't worry about writing DAO tests until we get into Spring integration.

4: Let's make sure that the `create` method is actually doing it's job.

* In the *client* package, create a *DAOTest.java* file with a `main` method.

* Instantiate an instance of *ActorDAOImpl* and use your create method to persist a new *Actor* entity.

* Print out the *Actor*'s `toString` (if you don't have one, create one)

* Open MySQL in terminal and query the _actor_ table for your new actor.

[Previous](managed_vs_detached.md) | [Next](updating_an_entity.md)
