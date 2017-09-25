# Deleting an Entity

* Call `EntityManager.remove()` on a managed entity to `DELETE` the corresponding row in the database on the next commit.

  * The entity becomes detached after the remove and remains available until it is garbage collected.

```java
Actor a = em.find(Actor.class, 1);
em.getTransaction().begin();

em.remove(a); // performs the delete on the managed entity

em.getTransaction().commit();

a.getFirstName(); 
// a is now a detached entity and does not correspond to a row in the db...
// ... however, it is still an object and can be used as such
```

* Due to the obvious risk of a `DELETE`, Hibernate can sometimes rollback a transaction behind the scenes. If your `em.remove()` call isn't being committed to the database you can always write a JPQL `DELETE` statement. 

### Hands On

1: In your *ActorDAO* create the following method stub:

`public boolean destroy(int id);`

2: Implement the `destroy` method in your *ActorDAOImpl*: 

* Use the provided `id` to retrieve a managed *Actor* entity

* Use `EntityManager.remove()` to delete the managed entity

* on `commit()` the managed entity will be deleted

* presuming there is no error and the entity was found, return `true`, otherwise, return `false`.

3: To test that your `destroy` is working, modify *ActorDAOTest* by commenting out your `update`, remove the entity you created and modified in the previous two 'hands on' activities. Check MySQL, the entity should no longer be present in your database.


[Previous](updating_an_entity.md) | [Next](persisting_multiple_entities.md)
