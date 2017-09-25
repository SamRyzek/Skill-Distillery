# Finding an Entity with EntityManager
* Use an *EntityManager* to retrieve or store an entity in the database.

  * An *EntityManager* is an interface provided by the *javax.persistence* class, which is used to interact with the *Persistence Unit*'s *Persistence Context* (the collection of entities known to the *Persistence Unit*).

  * What this means to you is, if you want to interact with a managed entity (data persisted in SQL), you will use the *EntityManager* to do so.

* In Java SE, you must use an *EntityManagerFactory* to obtain the *EntityManager*.
  
```java
public class CustomerClient {
  public static void main(String[] args) {
    EntityManagerFactory emf =
      Persistence.createEntityManagerFactory("VideoStore");
    EntityManager em = emf.createEntityManager();
  }
}
```
  
  * Use the *Persistence* class to get the factory for the named persistence unit.

* Use *EntityManager*'s `find()` method to retrieve an entity instance loaded with data from the database.
  

```java
public class CustomerClient {
  public static void main(String[] args) {
    EntityManagerFactory emf =
      Persistence.createEntityManagerFactory("VideoStore");
    EntityManager em = emf.createEntityManager();

    // returns a Customer entity where id = 1
    Customer cust = em.find(Customer.class, 1);
    /*
      Behind the scenes, the 'em.find(Customer.class, 1);' is translated into a 
      SQL query like:

        SELECT * FROM CustomerTable WHERE id = 1;

      The returned data is then returned as an Object, and cast to the indicated 
      e.g. Customer.class
    */
  }
}
```
  
  * Pass the expected datatype as a Class literal in the first argument and the primary key value as the second argument.


* Be sure to close an EntityManager that is obtained from an EntityManagerFactory.

  * Also, close the EntityManagerFactory if you obtained it from the Persistence class.
  
```java
public class CustomerClient {
  public static void main(String[] args) {
    EntityManagerFactory emf =
      Persistence.createEntityManagerFactory("VideoStore");
    EntityManager em = emf.createEntityManager();

    Customer cust = em.find(Customer.class, 1);

    // No memory leaks...
    em.close();
    emf.close();
  }
}
```
  
### Hands On:
* Create a new package called *client* and in that package create a class called *CustomerClient*. 

* Add a `main()` method to your new class and add code to find a *Customer* using an *EntityManager*

* If everything went well, then you will see the output from your *Customer*’s `toString()` implementation.

* To control the logging, create a file called *log4j.properties* and save it to the src folder. Add the following content to only show warnings and errors:
  
```groovy
// Change this line from WARN to INFO for more detailed logging
log4j.rootLogger=WARN, stdout
log4j.logger.org.hibernate.type=trace
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
log4j.appender.stdout.layout.ConversionPattern=%d %p [%c] - %m%n
```
  
[Previous](persistence_xml.md) | [Next](labs.md)
