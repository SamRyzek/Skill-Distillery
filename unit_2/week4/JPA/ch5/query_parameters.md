# Query Parameters
*  Substitute values for embedded JPQL placeholders with the `setParameter()` method.

* Your JPQL statement can identify query parameters by variable name:

  * Specify named parameters with `:name` syntax:

```java
    String queryString =
      "SELECT s FROM Staff s WHERE s.id = :id";

    Staff staff =
      em.createQuery(queryString, Staff.class)
      .setParameter("id", 8)
      .getSingleResult();
```

* The `setParameter()` method is called on the *TypedQuery* and returns the modified *TypedQuery*...allowing you to chain additional methods on it.

* It is also possible to have more than one parameter in a single query string. Simply chain additional `setParameter()` methods onto the *TypedQuery* as below:

```java
    String queryString =
      "SELECT s FROM Staff s WHERE s.firstName = :fname AND s.lastName = :lname";

    List<Staff> results =
      em.createQuery(queryString, Staff.class)
      .setParameter("fname","Lisa")
      .setParameter("lname", "Kong")
      .getResultList();
```

* This parameterization allows you to easily use User input in queries, while also preventing SQL injection attacks (the `setParameter()` method sanitizes inputs).

* The following example illustrates how these parameters could be used to easily allow users to search for Staff members by their last names:

```java
public List<Staff> getStaffMembersByLastName(String lname) {
  String queryString =
      "SELECT s FROM Staff s WHERE s.lastName = :lname";

  List<Staff> results =
    em.createQuery(queryString, Staff.class)
    .setParameter("lname", lname)
    .getResultList();
    
  return results;
}
```

### Hands On:
1: Change your *JPQLClient* program to use a parameter for the id.

[Previous](basic_queries.md) | [Next](labs.md)
