# `@Temporal`

* You must annotate `java.util.Date` or `java.util.Calendar` fields with the `@Temporal` annotation and specify a value from the TemporalType enumeration.

  * The value can be `TIMESTAMP`, `TIME` or `DATE`.

```java
@Entity
@Table(name="CustomerTable")
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name="create_date")
  @Temporal(TemporalType.DATE)
  private Date createDate;

  // ...
}
```

* This mapping tells the persistence provider which of the `java.sql` types to use when working with the underlying JDBC driver.

* This annotation is unnecessary if your field is already of type `java.sql.Date`, `java.sql.Time`, or `java.sql.Calendar`.

* JPA 2.1 was released before Java 8, so it doesn’t yet support `java.time.LocalTime` or `java.time.LocalDate`.


### Hands On:
1: Add a new field called *createdAt* of type `java.util.Date` to your *Customer* entity.

* Use both the `@Column` and `@Temporal` annotations on the newly created field.

Here is the _CustomerTable_ for reference:  

```
+-------------+----------------------+------+-----+-------------------+-----------------------------+
| Field       | Type                 | Null | Key | Default           | Extra                       |
+-------------+----------------------+------+-----+-------------------+-----------------------------+
| id          | int(10) unsigned     | NO   | PRI | NULL              | auto_increment              |
| store_id    | smallint(5) unsigned | NO   | MUL | NULL              |                             |
| first_name  | varchar(45)          | NO   |     | NULL              |                             |
| last_name   | varchar(45)          | NO   | MUL | NULL              |                             |
| email       | varchar(50)          | YES  |     | NULL              |                             |
| address_id  | int(10) unsigned     | NO   | MUL | NULL              |                             |
| active      | tinyint(1)           | NO   |     | 1                 |                             |
| create_date | datetime             | NO   |     | NULL              |                             |
| last_update | timestamp            | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
+-------------+----------------------+------+-----+-------------------+-----------------------------+
```

* Don’t forget to add get/set methods.

2: Write a test for the *createdAt* mapping.

* Name the test `test_customer_temporal`

* Compare the *Date* value from the retrieved customer object to the expected value.

  * ***HINT***: *java.util.Date* objects' `toString()` method might be useful.

3: Look at your *CustomerTest* class. In each of your tests you are likely using `em.find()` to retrieve a *Customer* entity, likely the same *Customer* entity. This isn't very DRY...how could you refactor your test class to fix this?

* Look at how you are retrieving/assigning the *EntityManagerFactory* an *EntityManager* as fields at the class level...could you do something similar with the *Customer* entity?


[Previous](generated_value.md) | [Next](enumerated.md)
