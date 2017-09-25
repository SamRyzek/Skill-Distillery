# `@OneToOne`

* Use the `@OneToOne` annotation to describe a one-to-one relationship.

  * Annotate the defining field in the owning entity to specify mapping
details.

    * The owning entity is the one whose corresponding database table contains the join column which models the relationship.

    * Use the `@JoinColumn` annotation to specify the foreign key _column name_.

```java
@Entity
public class Customer {
     // ...
     @OneToOne
     @JoinColumn(name="address_id")
     private Address address;
     // ...
}
```

* In the non-owning entity of a bi-directional relationship, add the `@OneToOne` annotation above the field that references the owning entity.

  * Use the `mappedBy` element on the `@OneToOne` annotation to specify the defining field in the owning entity.

```java
@Entity
public class Address {
     // ...
     @OneToOne(mappedBy="address")
     private Customer customer;
     // ...
}
```

* For a uni-directional relationship, omit the second `@OneToOne` annotation with the ***mappedBy*** element (and the field it decorates). 

### Hands On:
1: Create a uni-directional, one-to-one relationship between your *Customer* and *Address* entities.

* First, in *Customer*  add a field of type *Address* annotated with `@OneToOne` and `@JoinColumn`.

Here is the _customer_ table for you to reference:

```bash
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

* Also, replace the get/set methods with new versions.

* As a uni-directional relationship, the *Address* entity remains unchanged.

2: Update *CustomerTest.java* so that it tests your new relationship.

```java
  @Test
  public void test_address_association() {
     Customer cust = em.find(Customer.class, 2);
     Address address = cust.getAddress();
     assertEquals("1121 Loja Avenue", address.getStreet());
     assertEquals("", address.getStreet2());
     assertEquals("San Bernardino", address.getCity());
     assertEquals("17886", address.getPostalCode());
  }
```

[Previous](entity_relationships.md) | [Next](labs.md)
