# Creating an Entity Class
* An entity is a *Plain Old Java Object* (POJO) whose values represent a row in a database table.

  * An entity **MUST** have a *no-argument constructor*

  * Fields **must not** be marked *public* or *final*

* The `@Entity` annotation is used to declare a class as an entity:

```java
@Entity
@Table(name="CustomerTable")
public class Customer {
  //  ...
}
```

  * If your class name **does not** match the table name, then identify the table name with the `@Table` annotation as above.

  * If you class name **does** match the table name, you are all set, JPA will find the table by itself.

* You must annotate the field that maps to your primary key using the `@Id` annotation:

```java
@Entity
@Table(name="CustomerTable")
public class Customer {
  @Id
  private int id;
}
```

* By default, JPA will attempt to access columns on your table based on the names of the fields you create.

* Annotate fields that don't match the names of your columns with `@Column` using `name` to specify the column name.

```java
@Entity
@Table(name="CustomerTable")
public class Customer {
  @Id
  private int id;

  @Column(name="first_name")
  private String firstName;
}
```

* The persistence provider will assume that all of an Entity's fields are mapped to the database.

  * If you wish to add a field to your entity that is not mapped to a column in the database, mark that field as `@Transient`

```java
@Entity
@Table(name="CustomerTable")
public class Customer {
  @Id
  private int id;

  @Column(name="first_name")
  private String firstName;

  @Transient
  private boolean served;
}
```

* As all of the fields are private, you will also need to add get/set methods so that Entity's values are accessible. (except for id...we don't want to set that, the database is going to do it for us.)

```java
@Entity
@Table(name="CustomerTable")
public class Customer {
  @Id
  private int id;

  @Column(name="first_name")
  private String firstName;

  public int getId() {
    return this.id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
}
```

### Digging Deeper:
* A JPA *Entity* is the Java equivalent of a SQL table.

* The corresponding table for the *Customer* entity could look like:

```
mysql > describe CustomerTable;
+------------+-------------+------+-----+---------+----------------+
| Field      | Type        | Null | Key | Default | Extra          |
+------------+-------------+------+-----+---------+----------------+
| id         | int(11)     | NO   | PRI | NULL    | auto_increment |
| first_name | varchar(50) | YES  |     | NULL    |                |
+------------+-------------+------+-----+---------+----------------+
```

* As you can see, it is simple to conceptualize what the SQL looks like from the Java Entity, and vice versa.


### Hands On:
Create a new class that represents the *customer* table as an *Entity*.

* Name the class **Customer** and place it in a package named **entities**. For now, add fields for:
  * id

  * firstName -> SQL column name is 'first_name'

  * lastName -> SQL column name is 'last_name'

  * email -> SQL column name is 'email'...no `@Column` necessary

* Decorate the *Customer* class with `@Id`, `@Entity` and `@Table` as needed.

* Generate a get method only for *id*

* Generate both getters and setters for the other fields.

* Add a **toString()** method to the class.


[Previous](dependencies_gradle.md) | [Next](persistence_xml.md)
