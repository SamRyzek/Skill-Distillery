# Cascading
* Manually persisting multiple related entities is cumbersome, thankfully, the JPA has a means of simplifying this process.

* By default an *EntityManager* operation will not be applied to related entities.

* To propagate *EntityManager* operations to a related entity, include the `cascade` element in the relationship annotation.

  * Specify an array of operations to be cascaded.

  * The values, defined in the `CascadeType` enum, are `PERSIST`, `MERGE`, `REFRESH`, `REMOVE`, `DETACH`, or `ALL`.

```java
@Entity
public class Rental {
// ...
  @OneToMany(cascade=CascadeType.PERSIST)
  @JoinColumn(name = "rental_id", referencedColumnName = "id")
  private List<Payment> payments;
// ...
}
```

#### Note
* Cascade only propagates the persist, merge, etc... actions. It does not cascade the actual data changes that will be saved by a persist or merge. You still need to set data on both sides of a bi-directional link so that persists will save the correct data in each entity.

### Hands On
* To get some experience with `cascade` we will create a method to add a new film to a newly discovered actor's filmography (for the sake of this example, lets assume that our application has functionality to both create a new actor and film simultaneously).

1: Add the `cascade` element to the `@ManyToMany` relationship in *Actor* (the association to *Film*)

* Assign `cascade` an array, and the `PERSIST` and `REMOVE` types

2: In *ActorDAO* add the following method stub:

`public Actor createActorAndFilm(Actor actor, Film film);`

3: In *ActorDAOImpl* implement the `createActorAndFilm` method.

* Check if the provided *Actor* has a list of films, if not, create one and set it

* Add the provided film to the *Actor*'s list of films

* Persist the *Actor* entity within a transaction

4: In *ActorDAOTest* use your `createActorAndFilm` method to create both objects.

* Print out the *Actor*'s `toString` as well as the *Film*'s `toString`.

  * Film requires:

    * a language

    * a rental rate

    * a replacement cost

* Use your `destroy` method to remove the *Actor*.

5: You should see the information about your Actor and Film print out. Now, query your database from terminal, if your `destroy` worked correctly, neither the *Film* nor the *Actor* should exist in the database.


[Previous](persisting_multiple_entities.md) | [Next](../ch9/README.md)
