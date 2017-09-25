# Eager and Lazy Loading

* When you call find() to retrieve an entity, JPA will eagerly load data into scalar types, but defer loading data into collection types until the data is needed.

  * Called lazy loading, this feature is enabled by default for performance and memory conservation.

* By default one-to-one and many-to-one relationships are eagerly loaded and one-to-many and many-to-many are lazily loaded.

  * Override the default behavior by adding `fetch=FetchType.EAGER` or `LAZY` to your cardinality annotation.

```java
  @ManyToMany(mappedBy="films", fetch=FetchType.EAGER)
  private List<Actor> actors;
```

  * Be careful when overriding the default loading strategy since it may affect performance.

    * If all of your entities are set to eager load their associations, and you query a list of all of the entities of a given type...the number of entities loaded could be immense depending on the size of your data. As a result, it is better for performance to set the `FetchType` to `LAZY` in most circumstances. There are drawbacks to this strategy as we will see later.

### How to Query Lazily Loaded Collections?
* To optimize performance you will want to predominantly use `LAZY` loading, however, there are plenty of instances where you will want access to the collection when it is queried. If these collections are lazily loaded, you will get an exception. For instance, the following method will generate a lazy loading exception:

```java
public List<Actor> getActorsForFilmWithTitle(String title) {
  String queryString = "SELECT f FROM Film f WHERE f.title = :title";

  TypedQuery<Film> query = em.createQuery(queryString, Film.class);

  Film film = query.setParameter("title", title)
                   .getSingleResult();

  // Right here, things will break because of lazy loading
  List<Actor> actors = film.getActors();

  return actors;
}
```
* Lazy collections are loaded by default by JPA upon first access. That means calling any method on the collection will cause JPA to re query the database for the appropriate records.
  * A common solution is to call the `.size()` method on the collection before trying to access the data. 

* The best way to query *LAZY* loaded collections is to use a `JOIN FETCH` on the property inside of a typed query.

* `JOIN FETCH` retrieve both the parent entity and it's lazily loaded collection in one query, ensuring that the collection will be available along with the entity.

* The syntax is the same as *TypedQueries* we have seen previously, with the exception of the addition of `JOIN FETCH`. Consider the following method:

```java
public List<Actor> getActorsForFilmWithTitle(String title) {
  String queryString = "SELECT f FROM Film f JOIN FETCH f.actors WHERE f.title = :title";

  TypedQuery<Film> query = em.createQuery(queryString, Film.class);

  Film film = query.setParameter("title", title)
                   .getSingleResult();

  // This will work
  List<Actor> actors = film.getActors();

  return actors;
}
```

[Previous](many_to_many.md) | [Next](labs.md)
