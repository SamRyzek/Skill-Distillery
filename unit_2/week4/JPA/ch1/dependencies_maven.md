# Dependencies
* JPA requires several additional JAR files:

  * A JDBC driver to communicate with the database (MySQL).

  * A persistence provider that implements the JPA interfaces (Hibernate).

* We will also incorporate several optional libraries to improve JPA's performance:

  * A logging framework to control the persistence provider's output making it easier to debug (Log4J).

  * A connection pool library which will scale with production (c3p0).

    * Without c3p0, Hibernate's connections go to sleep after ~24 hours. If a user trys to access a sleeping connection pool, they will initially be served an error. To improve User Experience, c3p0 ensures that the connection pool remains open.

* We will be including these dependencies with Maven.

### Hands On:
You are going to convert your project to a Maven project and add dependencies to the *pom.xml* so that Maven will automatically include the necessary JAR files in the Eclipse build path.  
  
1: In Eclipse, right click on the *JPAVideoStore*'s project name in the *Project Explorer* and choose *Configure -> Convert to Maven Project*. Click *Finish* on the *Maven POM* dialog.  

2: Modify the newly created *pom.xml* file by adding the following just before the final `</project>` tag:  

```xml
<!-- preceding pom.xml excluded for brevity -->
</build>
  <properties>
    <hibernate.version>5.2.1.Final</hibernate.version>
  </properties>
  <dependencies>
    <!-- MySQL Driver -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>5.1.39</version>
    </dependency>
    <!-- Hibernate Persistence Provider -->
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-core</artifactId>
      <version>${hibernate.version}</version>
    </dependency>
    <!-- c3p0 connection pooling -->
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-c3p0</artifactId>
      <version>${hibernate.version}</version>
    </dependency>
    <!-- Log4j for better logging -->
    <dependency>
      <groupId>log4j</groupId>
      <artifactId>log4j</artifactId>
      <version>1.2.17</version>
    </dependency>
  </dependencies>
</project>
```

* ***What is `<properties>` doing?***
  * If you have multiple dependencies from the same groupId, it is useful to ensure that they are of the same version (this decreases the likelihood of dependency hell)

  * In the example above, we are using a `<properties>` tag to set a version of hibernate we wish to use for all of the hibernate dependencies.

  * This could also be useful if you had multiple Spring jars and wanted to ensure that they were all the same version.


[Previous](what_is_java_persistence.md) | [Next](creating_an_entity_class.md)
