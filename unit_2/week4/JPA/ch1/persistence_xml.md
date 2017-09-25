# `persistence.xml`
* A persistence unit is the entities (instances of POJOs annotated with `@Entity`) in your application, and the mapping of those entities to the database (Entity -> SQL & SQL -> Entity).

* You will define persistence units (we will only have one) in a `persistence.xml` file located in the *src/META-INF* directory.

```xml
<persistence-unit name="VideoStore">
  <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
  <!-- ... -->
</persistence-unit>
```

  * Declare the persistence unit name using the **name** attribute of the `<persistence-unit>` element.

  * Identify which persistence provider you wish to use with the `<provider>` element (we are using Hibernate).

  * Provide configuration information for the persistence unit using the `<property>` element.

    ```xml
    <properties>
      <property name="javax.persistence.jdbc.url"
              value="jdbc:mysql://localhost:3306/sdvid" />
      <property name="javax.persistence.jdbc.user" value="student"/>
      <property name="javax.persistence.jdbc.password" value="student" />
      <property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
    </properties>
    ```

 * Standard elements include:

   * *url* - the location of your database server

   * *user* - the username to access your database server

   * *password* - the password to access your database server

   * *driver* - the driver class to use to connect to your SQL implementation

 * You can also add provider specific configuration here.

   * For Hibernate, there are debug configurables that can be toggled on and off to help you during development

   * For c3p0, you can configure the connection pool settings, dictating the length of time until the pooled connections time out, and the maximum number of connections.

### Including *Entities* In your Persistence Unit
* In order for the Persistence Unit to know about the *Entities* it manages, we need to include them within `<class></class>` tags.

* *Entities* are included with the convention _package.class_ within the Persistence Unit:

```xml
<persistence-unit name="VideoStore">
  <class>entities.Customer</class>
  <!-- ... -->
</persistence-unit>
```

### Hands On:
* If you don't already have one, create a `persistence.xml` file in the *src/META-INF* directory.

* Using the template below for the basic elements of your file.

* Name the persistence unit **VideoStore**

* Add additional properties to the file to specify database and connection pool information as below.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<persistence version="2.1"
  xmlns="http://xmlns.jcp.org/xml/ns/persistence"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/persistence http://xmlns.jcp.org/xml/ns/persistence/persistence_2_1.xsd">

  <persistence-unit name="VideoStore">
    <provider>org.hibernate.jpa.HibernatePersistenceProvider
    </provider>

    <!-- List Entities Here -->
    <class>entities.Customer</class>

    <properties>
      <property name="javax.persistence.jdbc.url"
        value="jdbc:mysql://localhost:3306/sdvid" />
      <property name="javax.persistence.jdbc.user"
        value="student"/>
      <property name="javax.persistence.jdbc.password"
        value="student" />
      <property name="javax.persistence.jdbc.driver"
        value="com.mysql.jdbc.Driver" />
  
      <property name="hibernate.show_sql" value="false" />
      <property name="hibernate.format_sql" value="false" />
  
      <property name="hibernate.dialect"
        value="org.hibernate.dialect.MySQLDialect" />
      <property name="hibernate.connection.provider_class"
          value="org.hibernate.connection.C3P0ConnectionProvider" />
  
      <property name="hibernate.c3p0.max_size" value="5" />
      <property name="hibernate.c3p0.min_size" value="0" />
      <property name="hibernate.c3p0.acquire_increment" value="1" />
      <property name="hibernate.c3p0.idle_test_period" value="300"/>
      <property name="hibernate.c3p0.max_statements" value="0" />
      <property name="hibernate.c3p0.timeout" value="60" />
    </properties>
  </persistence-unit>
</persistence>
```

[Previous](creating_an_entity_class.md) | [Next](entity_manager.md)
