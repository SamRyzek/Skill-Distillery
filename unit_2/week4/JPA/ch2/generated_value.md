# `@GeneratedValue`

* Primary keys can be generated using a table or by using a sequence or identity column (if supported by the database).

* When creating new entity objects, it is important to notify the persistence provider as to whether it should use your current id value for the INSERT, or depend upon a generation strategy instead.

  * Use the `strategy` element of the `@GeneratedValue` annotation to identify your choice.

    * Supported values include `TABLE`, `SEQUENCE`, `IDENTITY`, or `AUTO`, all of which are members of the `GenerationType` enumeration. (We will exclusively be using `IDENTITY` with MySQL)

  * Place the annotation above the primary key field that you have mapped with `@Id`.
  
```java
@Entity
@Table(name="CustomerTable")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name="first_name")
  private String firstName;

  // ...
}
```

* Notice that in the *CustomerTable* (below), the `id` field is marked ast `PRI` and `auto_increment`

  * `PRI` indicates that this is the primary key value

  * `auto_increment` indicates that when a new value is inserted into the table, MySQL will handle the determination of the next available id, and assign it as the value to this field. This corresponds directly to the `@GeneratedValue(strategy = GenerationType.IDENTITY)` which tells the JPA that MySQL is handling Primary Key assignment.
  
```
mysql > describe CustomerTable;
+------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| id         | int(11)     | NO   | PRI | NULL    | auto_increment |
| first_name | varchar(50) | YES  |     | NULL    |                |
+------------+-------------+------+-----+---------+----------------+
```

  
### Hands On:
1: Modify your *Customer* entity by adding the `@GeneratedValue` annotation above the id field. 

  * Your JUnit test should still pass after you have made this change.

2: Currently we are running *JUnit* tests manually. As a build tool, *Gradle* is more than capable of running our tests for us on each build. This saves us a step, and ensures that each time we run our project *Gradle* will ensure that the build is passing. Let's add configuration in the *build.gradle* file to have gradle run our tests for us.

* Modify the *sourceSets* task to include a *test* property.

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
      // need this to pull in the persistence unit, otherwise you won't be able to connect to the database
      srcDir 'src'
    }
   }
 }

```

* Now, instead of running tests as *JUnit* tests, right click on *CustomerTest* and select _Run As -> Gradle Test_
  
  * You will see the Gradle build run in the *Gradle Executions* view, and among the last tasks should be `:test`. Below `:test` you should see the test classes and tests that were run.

  * Your tests (and build) should still be passing.

[Previous](testing_junit.md) | [Next](temporal.md)
