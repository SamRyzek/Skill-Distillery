# JPQL
* Java Persistence Query Language (JPQL) is a SQL - like syntax for querying the database.

* Unlike SQL, JPQL is concerned with entities and their properties, not tables and their columns.

  * The following example illustrates what the JPQL query would like like to retrieve all *Staff* members:

```java
String queryString = "SELECT s FROM Staff s";

```

  * Unlike SQL, JPQL requires an alias for each class mentioned in the FROM
clause. In our case, the `s` is the alias for *Staff*. We could have optionally
used the `AS` reserved word to clarify the fact that `s` is an alias:

```java
String queryString = "SELECT s FROM Staff AS s WHERE s.lastName='Kong'";
```

  * Above, we evaluate the value of the *Staff* entity's `lastName` property, to query those records where the `lastName` is equal to `"Kong"`, just as we would in SQL, except, instead of querying by the value of a column, we are using the actual property name.

  * JPQL statements are not case sensitive, except when it comes to entity and property names. The following statement would fail because of the lowercase `s` in `staff` and the lowercase `n` in `lastname`:

```java
String queryString = "SELECT s FROM Staff s WHERE s.lastname='Kong'";
```

### Basic Queries
* *EntityManager*’s `find()` method returns a single entity based on the
provided primary key.

  * The example below queries the provided entity (e.g. queries the corresponding table) for the primary key provided (1), and casts the returned values to appropriate type (*Staff*).

```java
Staff s = em.find(Staff.class, 1);
```
* Use a JPQL query instead of a find to retrieve multiple entities.

  * Call the `createQuery()` method available on the *EntityManager*, and passing in two arguments.

    * First, a JPQL `SELECT` statement that identifies what to retrieve.

    * Second, a class (e.g. `Staff.class`) identifying the data type of the resulting collection.

  * The `createQuery()` method returns a `TypedQuery` object, which we can use to query the database.

  * Call `getResultList()` on the *TypedQuery* object to get a List of entities of the requested type.

```java
    String queryString = "SELECT s FROM Staff s";
    
    TypedQuery<Staff> query = em.createQuery(queryString, Staff.class);

    List<Staff> results = query.getResultList();
```

  * The `createQuery()` and `getResultList()` calls are often combined into a single statement.

```java
    String queryString = "SELECT s FROM Staff s";

    List<Staff> results = em.createQuery(queryString, Staff.class).getResultList();
```

  * If your query only produces a single result, call `getSingleResult()` rather than `getResultList()`.

```java
    String queryString = "SELECT s FROM Staff s WHERE s.id=1";
    Staff s = em.createQuery(queryString, Staff.class).getSingleResult();
```

### Hands On:
1: Create a class named *JPQLClient* in the *client* package.  

2: Write JPQL to retrieve any staff member whose id is less than 10.
  
  * Think about what the SQL query for this would be...how would you write that with JPQL?

[Previous](README.md) | [Next](query_parameters.md)
