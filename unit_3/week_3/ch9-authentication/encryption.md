# Password Encryption with bCrypt

### Configuration
* One of the greatest benefits to using bcrypt for password encryption with Spring is how easy it is to configure and use.  

* First, add the 'Spring Security' dependency to your `build.gradle`:  

```groovy
compile group: 'org.springframework.security', name: 'spring-security-core', version: '4.1.2.RELEASE'

```

* Second, inject a bean for bcrypt in your dispatcher servlet:  

```xml
<!-- dispatcher-servlet.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
  xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
  xsi:schemaLocation="
    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.2.xsd
    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.2.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.2.xsd
    http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.2.xsd">

  <context:component-scan base-package="controllers, test" />

  <!-- bcrypt bean -->
  <bean id="bCryptPasswordEncoder"
    class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder" />

  <bean id="myEntityManagerFactory"
    class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
    <property name="persistenceUnitName" value="NgSecurityPU" />
  </bean>

  <bean id="myTransactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
    <property name="entityManagerFactory" ref="myEntityManagerFactory" />
  </bean>

  <tx:annotation-driven transaction-manager="myTransactionManager" />
</beans>
```  

* Finally, autowire bcrypt where you want to use it. For the purposes of this example, the bean is autowired in a controller:

```java
@Transactional
@Repository
public class AuthDAOImpl implements AuthDAO {

  @PersistenceContext
  private EntityManager em;

  @Autowired
  private PasswordEncoder encoder;
}
```

* With bcrypt configured, it can be used to hash user passwords.  

### Use
* Once `BCryptPasswordEncoder` has been autowired in you application, the `encode(CharSequence arg0):String` method can be used to generate an encoded String. (i.e. `"banana"` would become something like `$2a$10$EGfvuDgIKqhmzlDf34s/aOxU0fSWf/2uZnxQqcIS3n9j7cIwIqnFa`)

* A very simple example would be the use of bcrypt to encode a password prior to persisting it inside of a `UserDAO`:

```java
  @Override
  public User register(User u) {
    String passwordSha = encoder.encode(u.getPassword());
    u.setPassword(passwordSha);
    em.persist(u);
    em.flush();
    return u;
  }
```

* With a user's password encoded, it is no longer possible to compare a *plain text* password (i.e. `"banana"`) to the encrypted equivalent without bcrypt.  

```java
"banana".equals("$2a$10$EGfvuDgIKqhmzlDf34s/aOxU0fSWf/2uZnxQqcIS3n9j7cIwIqnFa"); // false
```

* bcrypt provides an additional method, `matches(CharSequence rawPassword, String encodedPassword):boolean`, which will use the encoded salt to compare the two values provided and return a boolean (`true` if the values match).

* `matches` makes it easy to authenticate user information, below is an example of how this can be accomplished:  

```java
// Assume this 'user' is passed to authenticate from a '/login' route
// where the user provides username and a plain text password
public User authenticateUser(User user) throws NoResultException {
  // find the User by username/email (a unique field)
  String query = "SELECT u FROM User u WHERE u.email = :email";
  User managedUser = em.createQuery(query, User.class)
                        .setParameter("email", user.getEmail())
                        .getSingleResult();
  if (passwordEncoder.matches(user.getPassword(), managedUser.getPassword())) {
    return managedUser;
  }
  return null;
}
```

* This `authenticateUser(User user):User` method will either:  
  1: Throw a `NoResultException`, which can be handled to return a `404` status (because no user with that username was found),  

  2: Evaluate that the *plain text* password provided matches the encoded password from the database, and return the User object,  

  3: Evaluate that the passwords _do not_ match, and return `null`, allowing for `null` checking and a `401` response (as the authentication failed and login is 'unauthorized').

### Hands On


1: Include the Spring Security Dependency:

```groovy
compile group: 'org.springframework.security', name: 'spring-security-core', version: '4.1.2.RELEASE'
```

2: In your dispatcher servlet, configure a bean for `org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder`

3: Create an interface and implementation of an `AuthDAO`

4: In your `AuthDAOImpl` autowire a `PasswordEncoder` bean.

5: Create a `register` method to persist users with encrypted passwords

6: Create a `login` method to authenticate a user against the managed user record in the database. On success, return the managed user, otherwise return `null`

#### [Prev](user-authentication.md) | [Next](spring-session.md)
