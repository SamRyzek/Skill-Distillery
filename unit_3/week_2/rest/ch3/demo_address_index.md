## Walkthrough

Up to this point we haven't interacted with a database using Spring REST. Remember the video store database we build during sql week? We are going to use this SQL database and JPA configuration as a starting point for this demo.

1: Find your JPAVideoStore project from a few weeks ago. Run one of your JUnit tests to make sure that your connections are still up and running.

2: Create a separate dynamic web project called VideoStoreREST.

3: Create two packages, one called data and the other called controllers.

4: Add gradle nature to your project and configure a build.gradle file.

5: Add your JPAVideoStore project as a dependency to the build.gradle and settings.gradle files.

6: We are going to need all the dependencies we used in a standard Spring MVC project plus the jackson jars that we discussed. The following is an example of a completed dependencies list in your build.gradle file:
```groovy
dependencies {
	compile project(':JPAVideoStore')

    compile group: 'org.springframework', name: 'spring-webmvc', version:"$springVersion"
    compile group: 'org.springframework', name: 'spring-orm', version:"$springVersion"
    compile group: 'javax.servlet', name: 'javax.servlet-api', version:'3.1.0'
    compile group: 'javax.servlet', name: 'jstl', version:'1.2'
    compile group: 'org.hibernate', name: 'hibernate-validator', version:'5.2.4.Final'
    compile "org.springframework:spring-test:$springVersion"
    compile "org.springframework:spring-tx:$springVersion"

    compile group: 'com.fasterxml.jackson.core', name: 'jackson-core', version: '2.8.5'
    compile group: 'com.fasterxml.jackson.core', name: 'jackson-databind', version: '2.8.5'

    testCompile 'junit:junit:4.12'
    testCompile 'org.hamcrest:hamcrest-junit:2.0.0.0'
}
```

7: Configure your web.xml file and specify the url-pattern as `/api/*`
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
       http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
	version="3.1">
	<servlet>
		<servlet-name>VideoStore</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>VideoStore</servlet-name>
		<url-pattern>/api/*</url-pattern>
	</servlet-mapping>
</web-app>
```

8: Configure your -servlet.xml file exactly as we have before. When you are complete you will have something similar to below.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
	xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
	xsi:schemaLocation="
    http://www.springframework.org/schema/mvc
    http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
    http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
    http://www.springframework.org/schema/context
    http://www.springframework.org/schema/context/spring-context-4.3.xsd
    http://www.springframework.org/schema/tx
    http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">

	<mvc:annotation-driven />

	<context:component-scan base-package="controllers" />

	<bean id="myEntityManagerFactory"
		class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
		<property name="persistenceUnitName" value="JPAVideoStore" />
	</bean>

	<bean id="myTransactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
		<property name="entityManagerFactory" ref="myEntityManagerFactory" />
	</bean>

	<tx:annotation-driven transaction-manager="myTransactionManager" />
</beans>
```

9: Create files called AddressDAO.java and AddressController.java in their respective packages.

10: In your -servlet.xml file add a line to create a bean for your AddressDAO
```xml
<bean id="addressdao" class="data.AddressDAO" />
```

11: Annotate the controller as a `@RestController` and `@Autowire` in your AddressDAO.

```java
@RestController
public class AddressController {
	@Autowired
    private AddressDAO addressDAO;
}
```

12: Annotate your DAO as `@Transactional` and include the EntityManager as a field.
```java
@Transactional
public class AddressDAO {
	@PersistenceContext
	private EntityManager em;
}
```  

13: Write a single DAO method that user JPQL to query the database to retrieve and return a list of addresses.  
```java
public List<Address> index(){
  String query = "Select a from Address a";
  return em.createQuery(query, Address.class).getResultList();
}
```

13: Back in your controller, write a method that is mapped by the path `/api/addresses` which calls the DAO method we just wrote.  
```java
@RequestMapping(path="addresses", method=RequestMethod.GET)
public List<Address> index(){
  return addressDAO.index();
}
```

14: Run the program and hit the route `http://localhost:8080/RESTVideoStore/api/addresses` in postman. View the returned json data.  

[Previous](pojoTojsonAndBack.md) | [Next](demo_address_show.md)
