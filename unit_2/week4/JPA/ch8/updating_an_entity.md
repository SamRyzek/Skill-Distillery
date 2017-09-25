# Updating an Entity

* If you modify a managed entity, then on the next transaction commit, a database `UPDATE` will occur.

  * You do not need to call any additional *EntityManager* methods.

### Hands On:
1: In your *ActorDAO* create the following method stub:

`public Actor update(int id, Actor actor);`

2: Implement the `update` method in your *ActorDAOImpl*:

* Use the provided `id` to retrieve a managed *Actor* entity

* Use set methods to update the managed *Actor* entity with the values in the *Actor* parameter

* on `commit()` the managed entity will be updated

* return the updated managed entity.

3: To test that your `update` is working, modify *ActorDAOTest* by commenting out your `create` (we don't want to create lots of duplicates), and instead using `update` to change the first and last name of the *Actor* you created in the previous 'hands on'.

[Previous](creating_an_entity.md) | [Next](deleting_an_entity.md)
