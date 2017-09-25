# Java Persistence API (JPA)

### Table of Contents

##### [Chapter 1 - Introduction to the Java Persistence API](ch1/README.md)
* [What is Java Persistence?](ch1/what_is_java_persistence.md)

* [Dependencies](ch1/dependencies_maven.md)

* [Creating an Entity Class](ch1/creating_an_entity_class.md)

* [`persistence.xml`](ch1/persistence_xml.md)

* [Finding an Entity with *EntityManager*](ch1/entity_manager.md)

* [Labs](ch1/labs.md)

* *Supporting Files:*
  * [`pom.xml`](ch1/handsOn/pom.xml)
  * [`Customer.java`](ch1/handsOn/Customer.java)
  * [`persistence.xml`](ch1/handsOn/persistence.xml)
  * [`log4j.properties`](ch1/handsOn/log4j.properties)
  * [`CustomerClient.java`](ch1/handsOn/CustomerClient.java)

##### [Chapter 2 - Additional Mapping Annotations](ch2/README.md)
* [Testing with *JUnit*](ch2/testing_junit.md)

* [`@GeneratedValue`](ch2/generated_value.md)

* [`@Temporal`](ch2/temporal.md)

* [`@Enumerated`](ch2/enumerated.md)

* [Labs](ch2/labs.md)

* *Supporting Files:*
  * [`Customer.java`](ch2/handsOn/Customer.java)
  * [`CustomerTest.java`](ch2/handsOn/CustomerTest.java)
  * [`Film.java`](ch2/handsOn/Film.java)
  * [`Rating.java`](ch2/handsOn/Rating.java)

##### [Chapter 3 - Mapping One-to-One Relationships](ch3/README.md)
* [Entity Relationships](ch3/entity_relationships.md)

* [`@OneToOne`](ch3/one_to_one.md)

* [Labs](ch3/labs.md)

* *Supporting Files:*
  * [`Customer.java`](ch3/handsOn/Customer.java)
  * [`CustomerTest.java`](ch3/handsOn/CustomerTest.java)

##### [Chapter 4 - Mapping Many-to-One Relationships](ch4/README.md)
* [Uni-directional `@ManyToOne`](ch4/uni_many_to_one.md)

* [Bi-directional `@ManyToOne`](ch4/bi_many_to_one.md)

* [Labs](ch4/labs.md)


* *Supporting Files:*
  * [`Address.java`](ch4/handsOn/Address.java)
  * [`Country.java`](ch4/handsOn/Country.java)
  * [`Film.java`](ch4/handsOn/Film.java)
  * [`Language.java`](ch4/handsOn/Language.java)

##### [Chapter 5 - JPQL](ch5/README.md)
* [Basic Queries](ch5/basic_queries.md)

* [Query Parameters](ch5/query_parameters.md)

* [Labs](ch5/labs.md)

* *Supporting Files:*
  * [`JPQLClient.java`](ch5/handsOn/JPQLClient.java)

##### [Chapter 6 - `@ManyToMany`](ch6/README.md)
* [Many To Many](ch6/many_to_many.md)

* [Eager and Lazy Loading](ch6/eager_and_lazy_loading.md)

* [Labs](ch6/labs.md)

* *Supporting Files:*
  * [`Actor.java`](ch7/handsOn/Actor.java)
  * [`Film.java`](ch6/handsOn/Film.java)

##### [Chapter 7 - More Mappings](ch7/README.md)
* [Association Class](ch7/association_class.md)

* [Mapping Options with Association Classes](ch7/mapping_options_with_association_classes.md)

* [Self Reference](ch7/self_reference.md)

* [Unidirectional One to Many](ch7/unidirectional_one_to_many.md)

* [Labs](ch7/labs.md)

* *Supporting Files:*
  * [`Film.java`](ch7/handsOn/Film.java)
  * [`InventoryItem.java`](ch7/handsOn/InventoryItem.java)
  * [`Payment.java`](ch7/handsOn/Payment.java)
  * [`Rental.java`](ch7/handsOn/Rental.java)
  * [`Staff.java`](ch7/handsOn/Staff.java)
  * [`Store.java`](ch7/handsOn/Store.java)

##### [Chapter 8 - CRUD](ch8/README.md)
* [Managed vs Detached](ch8/managed_vs_detached.md)

* [Creating an Entity](ch8/creating_an_entity.md)

* [Updating an Entity](ch8/updating_an_entity.md)

* [Deleting an Entity](ch8/deleting_an_entity.md)

* [Persisting Multiple Entities](ch8/persisting_multiple_entities.md)

* [Cascading](ch8/cascading.md)

* [Labs](ch8/labs.md)

* *Supporting Files:*
  * [`CreateRental.java`](ch8/handsOn/CreateRental.java)
  * [`DeleteActor.java`](ch8/handsOn/DeleteActor.java)
  * [`ManagedEntities.java`](ch8/handsOn/ManagedEntities.java)
  * [`Rental.java`](ch8/handsOn/Rental.java)
  * [`UpdateActor.java`](ch8/handsOn/UpdateActor.java)

##### [Chapter 9 - Spring MVC/JPA Integration](ch9/README.md)
* [Incorporating JPA into your Dynamic Web Project](ch9/jpa_with_web.md)

* [Adding Dependencies](ch9/adding_dependencies_maven.md)

* [Data Access Object](ch9/dao.md)

* [Controller](ch9/controller.md)

* [web.xml](ch9/web_xml.md)

* [Spring Configuration File](ch9/servlet_xml.md)

* [Updating Data](ch9/updataing_data.md)

* [Labs](ch9/labs.md)

* *Supporting Files:*
  * [`VideoController.java`](ch9/handsOn/VideoController.java)
  * [`VideoControllerImpl.java`](ch9/handsOn/VideoControllerImpl.java)
  * [`VideoDBDao.java`](ch9/handsOn/VideoDBDao.java)
  * [`VideoDaoJPAImpl.java`](ch9/handsOn/VideoDaoJPAImpl.java)
  * [`VideoStore-servlet.xml`](ch9/handsOn/VideoStore-servlet.xml)
  * [`pom.xml`](ch9/handsOn/pom.xml)
  * [`web.xml`](ch9/handsOn/web.xml)


# Group Project
* [Introduction](GroupProject/README.md)
