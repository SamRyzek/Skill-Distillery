# Unidirectional One-To-Many

* Earlier you saw how to build a uni-directional, many-to-one relationship between *Address* and *Country*.

  * You annotated the field in the owning side of the relationship (*Address*) with the `@ManyToOne` and `@JoinColumn` annotations

```java
  @Entity
  public class Address {
    //...
    @ManyToOne
    @JoinColumn(name="country_code")
    private Country country;
    //...
  }
```
  * As a uni-directional relationship, the *Country* had no reference to *Address*.

  * What if you want to build a uni-directional, one-to-many relationship? How would you annotate the non-owning side of the relationship?

    * Use `@JoinColumn` on the `@OneToMany` non-owning side of the relationship adding two elements:

      * `name` - the name of the foreign key in the owning table.

      * `referencedColumnName` - the name of the primary key in the non-owning table - the one that is related to this entity.

```java
  @Entity
  public class Rental {
    //...
    @OneToMany
    @JoinColumn(name="rental_id", referencedColumnName="id")
    private List<Payment> payments;
    //...
  }
```

### Hands On:
1: Create an entity called *Payment*. Add the following fields:

  * id

  * amount

  * paymentDate

* Generate get and set methods

* Write a JUnit test in *PaymentTest* to ensure the entity is mapped correctly

2: Create a unidirectional one-to-many relationship between *Rental* and Payment.

* *Rental* stores a list of *Payment*s, *Payment* has no knowledge of a *Rental*. Add get/set methods.

* Write a JUnit in *RentalTest* test to ensure that *Rental* is correctly associated to *Payment*.
