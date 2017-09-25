# @ManyToMany

* Relational databases model many-to-many relationship through a join table.

  * If the join table contains no extra data beyond foreign keys, you should not build a separate entity for it (this is called a *Virtual Join Table*).

  * However...if the join table contains additional data, then you should create an entity to represent it.

* In a many-to-many, either side of the relationship can be chosen as the owning side.

  * In the owning entity, annotate a collection typed field (e.g. *List*, *Set* etc) with `@ManyToMany` and `@JoinTable`.

```java
@Entity
public class Actor {
  // ...
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToMany
  @JoinTable(name="film_actor",
    joinColumns=@JoinColumn(name="actor_id"),
    inverseJoinColumns=@JoinColumn(name="film_id")
  )
  private List<Film> films;

  // ...
}
```

  * `@JoinTable` has three elements:

    * `name` - the name of the actual SQL table functioning as a join table. (see *film_actor* below)

    * `joinColumns` - is assigned a `@JoinColumn` containing the column name (*actor_id*) in the join table that matches the primary key (*id*) in the owning entity (*Actor*).

    * `inverseJoinColumns` - A `@JoinColumn` that identifies the column in the join table (*film_id*) that matches the primary key (*id*) in the non-owning entity (*Film*).

```sql
-- actor
+------------+------------------+------+-----+---------+----------------+
| Field      | Type             | Null | Key | Default | Extra          |
+------------+------------------+------+-----+---------+----------------+
| id         | int(10) unsigned | NO   | PRI | NULL    | auto_increment |
| first_name | varchar(45)      | NO   |     | NULL    |                |
| last_name  | varchar(45)      | NO   | MUL | NULL    |                |
+------------+------------------+------+-----+---------+----------------+

-- film_actor (the join table)
+----------+------------------+------+-----+---------+-------+
| Field    | Type             | Null | Key | Default | Extra |
+----------+------------------+------+-----+---------+-------+
| actor_id | int(10) unsigned | NO   | PRI | NULL    |       |
| film_id  | int(10) unsigned | NO   | PRI | NULL    |       |
+----------+------------------+------+-----+---------+-------+

-- film
+------------------+-----------------------+------+-----+---------+----------------+
| Field            | Type                   | Null | Key | Default | Extra          |
+------------------+-----------------------+------+-----+---------+----------------+
| id               | int(10) unsigned       | NO   | PRI | NULL    | auto_increment |
| title            | varchar(255)           | NO   | MUL | NULL    |                |
| description      | text                   | YES  |     | NULL    |                |
+------------------+------------------------+------+-----+---------+----------------+
```

  * In the non-owning entity (*Film*) of a bi-directional relationship, add the `@ManyToMany` annotation above the collection typed field that references the owning entity (*Actor*):

      * Use the `mappedBy` element to specify the defining field in the owning entity.

```java
@Entity
public class Film {
  // ...
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToMany(mappedBy="films")
  private List<Actor> actors;

  // ...
}
```


### Hands On:
1: Create a new entity called *Actor* with fields for:

  * id

  * firstName

  * lastName

2: In *Actor* add a field of type `List<Film>` named `films`. Annotate it with
`@ManyToMany`. Let’s choose *Actor* as the owning side of this
relationship, so it will define the `@JoinTable` annotation as well.

3: Since *Film* is the non-owning side, add a `mappedBy` element within its `@ManyToMany`. As in the example, the value of the `mappedBy` should match the name of the corresponding field in *Actor*.

4: Generate get and set methods for your new fields. Then, update your JUnit
test for *Film* to verify your new associations work. Also create a JUnit test to ensure that the *Actor* entity's fields are mapped correctly, and that actors do indeed have films.

[Previous](README.md) | [Next](eager_and_lazy_loading.md)
