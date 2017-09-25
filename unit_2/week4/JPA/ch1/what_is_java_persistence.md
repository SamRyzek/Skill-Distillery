# What is Java Persistence?
* The Java Persistence API is a persistence mechanism which can be used in Java SE and Spring applications.

  * It is designed to simplify the persistence of POJOs (Plain Old Java Objects), called *Entities* in relational databases.

  * It employs object-relational mapping (ORM) to accomplish this.

  * ORM translates SQL tables and columns to Java classes and fields (*Entities*).

* JPA is mostly made up of interfaces, each of these interfaces is implemented by yet another dependency known as a 'persistence provider'.

  * We will be using the *Hibernate* persistence provider with JPA. Hibernate will actually manage the connection to the SQL database, JPA will handle the translation from SQL -> Java and back.

* The creation and persistence of *Entities* (...these are just instances of Java objects...) is managed by an *EntityManager*. The *EntityManager* is just an object representing the persistence provider's connection to the database.

* Once configured, the *EntityManager* makes persistence of objects simple. You will use methods like `find()`, `persist()` and `remove()` on the *EntityManager* instance for query, insert and delete operations. The *EntityManager* will translate these methods to the corresponding SQL to complete your operation.

* The classes, interfaces and annotations that we will use to interact with our data are predominantly located in the *java.persistence* package.

### Hands On:
You are going to create a new JPA Project and add to it over the next several sections, eventually creating an ***Entity*** that you can test with an ***EntityManager***.  

1: In STS, select _File -> Switch Workspace -> Other -> Browse_. This will open 'Finder', navigate to your _SD/Java_ directory and create a 'New Folder' named *VideoStore*.

2: Create a new *Java Project*. Be sure you do not do a new Dynamic Web project like we have in the past.  

3: On the *Project* page, name the project ***JPAVideoStore***, click *Finish*  .

4: Inside of the source folder create a folder named `META-INF`.

5: In the `META-INF` folder, create a file named `persistence.xml`.

[Ch 1 ...](README.md) | [Next](dependencies_gradle.md)
