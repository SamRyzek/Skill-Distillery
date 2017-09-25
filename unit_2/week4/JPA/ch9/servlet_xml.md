# Spring Configuration File

* Now that we are integrating with Spring, we can make use of Spring beans to reduce our workload.

* Remember all of those times we had to retrieve an *EntityManagerFactory*, create a new *EntityManager* and then clean up after those resources? Spring can handle all of that for use with a bean! The same goes for opening and closing *Transaction*s. All we need to do is configure Spring, and let it do the heavy lifting for us.

### Configuring a `-servlet.xml` to provide a *PersistenceContext* / Hands On:

1: Create a new *Spring Bean Configuration File* (right click on your _WEB-INF_ and click _New -> Other -> Spring Bean Configuration File_)

* Name it "VideoStore-servlet.xml"

2: As always with an MVC project, use the `context:component-scan` element to identify the package in which your controllers reside.

3: Declare your data access object (DAO) as a bean so it can use Spring annotations and be injected into the controller.

```xml
<!-- VideoStore-servlet.xml -->
  <!-- ... -->
  <bean id="dao" class="data.ActorDAOImpl" />
  <!-- ... -->
```

* Alternatively, if you can include *mvc:annotation-driven* and annotate your DAO as an `@Repository`. Note, you will need to expand your `context:component-scan` to include the DAO's package.

4: Declare an *EntityManagerFactory* so that it can be injected into the DAO automatically.

```xml
<!-- VideoStore-servlet.xml -->
  <!-- ... -->
  <bean id="dao" class="data.ActorDAOImpl" />

  <bean id="myEntityManagerFactory" 
    class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"> 
      <property name="persistenceUnitName" 
        value="VideoStore" />
  </bean>
  <!-- ... -->
```

  * The string referenced by the entityManagerFactory should match the persistence unit name in your *persistence.xml* file.

5: Declare a *TransactionManager* so that Spring can automatically handle transactions in our DAO. (after including this, you will not need to wrap your operations in a transaction)

```xml
<!-- VideoStore-servlet.xml -->
  <!-- ... -->
  <bean id="dao" class="dao.ActorDAOImpl" />

  <bean id="myEntityManagerFactory" 
    class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"> 
      <property name="persistenceUnitName" 
        value="VideoStore" />
  </bean>

  <bean id="myTransactionManager"
    class="org.springframework.orm.jpa.JpaTransactionManager">
    <!-- this property references (ref="") an existing bean -->
     <property name="entityManagerFactory"
        ref="myEntityManagerFactory" />
  </bean>
  <!-- ... -->
```

6: Use the `tx:annotation-driven` element to enable the `@Transactional` annotation.

  * Set the `transaction-manager` attribute to the name of the *TransactionManager* you set above.

```xml
<!-- VideoStore-servlet.xml -->
  <!-- ... -->
  <bean id="dao" class="dao.ActorDAOImpl" />

  <bean id="myEntityManagerFactory" 
    class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean"> 
      <property name="persistenceUnitName" 
        value="VideoStore" />
  </bean>

  <bean id="myTransactionManager"
    class="org.springframework.orm.jpa.JpaTransactionManager">
     <property name="entityManagerFactory"
        ref="myEntityManagerFactory" />
  </bean>

  <tx:annotation-driven transaction-manager="myTransactionManager" /> 
  <mvc:annotation-driven />
  <!-- ... -->
```

7: You will also need to include the `tx` namespace in your config file to support this element. 

  * xml namespaces are declared at the top of the file in the `<beans>` element. The example below includes the `xmlns:tx` and necessary schema to support it:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns:mvc="http://www.springframework.org/schema/mvc"
  xmlns:context="http://www.springframework.org/schema/context"

  xmlns:tx="http://www.springframework.org/schema/tx"
  xsi:schemaLocation="
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
    http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-4.3.xsd

    http://www.springframework.org/schema/tx
    http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">

<!-- additional bean declarations etc ... -->
```

* STS makes this really easy, click on the `Namespaces` tab at the bottom of the file, look for the `tx` namespace and check the box next to it.



[Previous](adding_dependencies_gradle.md) | [Next](dao.md)
