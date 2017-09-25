# Testing with JUnit

* JUnit is a lightweight test framework for automating unit testing in Java.

* You can use JUnit to create test cases to validate your JPA mappings.

  * Create JUnit ``@Before`` and `@After` methods to initialize and close *EntityManagerFactory* and *EntityManager* objects.

* As the names imply, your `@Before` method is invoked before each test and your `@After` method runs after each test.

* Create individual `@Test` methods to verify your mappings result in values in line with your expectations.

### Hands On:
We are going to create a JUnit test for our Customer entity.

##### A: Setup JUnit :
* We will be modifying existing files and creating new ones in the *test* directory.

1: First things first, we need to include testing dependencies in our *build.gradle* file.

* Under dependencies, include both *junit* and *hamcrest* as below:

```groovy
dependencies {
  compile "mysql:mysql-connector-java:5.1.39"
  compile "log4j:log4j:1.2.17"
  compile "org.hibernate:hibernate-core:$hibernateVersion"
  compile "org.hibernate:hibernate-c3p0:$hibernateVersion"

  testCompile 'junit:junit:4.12'
  testCompile 'org.hamcrest:hamcrest-junit:2.0.0.0'
}
```

  * We are only going to use the *junit* and *hamcrest* dependencies during testing. To indicate this, we add them to our dependencies with the *testCompile* configuration.

* Add the `test` directory in the `sourceSets` property configuration in the `build.gradle` file:

```groovy
sourceSets {
  main {
    java.srcDirs 'src'
    resources.srcDirs 'src/resources'
  }
  test {
    java {
      srcDir 'test'
    }
    resources {
      srcDir 'src'
    }
  }
}
```

2: Include the *JUnit* assertion library:

* We will modify the *CustomerTest* class to actually run ***JUnit*** tests:

```java
import static org.junit.Assert.*;
```

* If prompted to add JUnit 4 to your build path, choose *OK*.

3: Add a test case to *CustomerTest* above the `main` method.

```java
  @Test
  public void test() {
    boolean pass = true;
    assertEquals(pass, true);
  }
```

  * The above method is annotated with `@Test`, indicating that it is a *JUnit* test, and assuring that when the file's tests are run, this method will be invoked.

  * The purpose of this test (which should always pass) is to ensure that your tests are set up properly. If this test fails, then there is a problem with your environment.

4: You will be writing integration tests which require a connection to the database. We will use the `@Before` and `@After` annotations to mark methods to be invoked before and after our tests. This will ensure that the connection is established and closed appropriately.

* Create a `setUp` method, and annotate it with `@Before`

```java
  @Before
  public void setUp() throws Exception { }
```

* Create a `tearDown` method, and annotate it with `@After`

```java
  @After
  public void tearDown() throws Exception { }
```

##### B: Write Tests
* Add two private fields to the newly created class:

  * `private EntityManagerFactory emf;`

  * `private EntityManager em;`

* Initialize the two fields within the `@Before` method.

* Call close() on the fields in the `@After` method.

* Within the `@Test` method, add code to find the Customer entity with id of 1 and call `assertEquals()` to verify that each field contains expected values. Choose one of the records from the `customer` table in the database and use it to test against (obviously this is also the one your should find).

```java
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
  public void test_customer_mappings() {
    Customer cust = em.find(Customer.class, 1);
    assertEquals("Mary", cust.getFirstName());
    assertEquals("Smith", cust.getLastName());
    assertEquals("MARY.SMITH@sdvidcustomer.org", cust.getEmail());
  }

  @After
  public void tearDown() throws Exception {
    em.close();
    emf.close();
  }
}
```

* Run the test by right clicking on the test in Eclipse's *Project Explorer* and choosing _Run As -> JUnit Test_. 

##### C:
Create a new src directory at the same level as *src* named *test* and a new class named *AddressTest* within it.

```bash
JPAVideoStore
├── src
│   ├── META-INF
│   │   └── persistence.xml
│   ├── client
│   │   └── CustomerClient.java
│   ├── entities
│   │   ├── Address.java
│   │   ├── Customer.java
│   └── log4j.properties
└── test
    └── AddressTest.java
```

##### D: (Optional) Remove the `main` method
* Now that we have actual tests, you no longer need to run this test class as a Java Application. To declutter the class, feel free to remove the `main` method.

[Ch 2 ...](README.md) | [Next](generated_value.md)
