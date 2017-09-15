## Setup

### Spring Configuration

* In order for Spring MVC to recognize the validation annotations we will be using, you must enable annotation processing in the Spring config (DispatcherServlet) file with the `<mvc:annotation-driven>` element.
  
  ```xml
  <!-- authentication-servlet.xml -->
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
    xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
    xsi:schemaLocation="
      http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
      http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
      http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
      http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">
  
    <context:component-scan base-package="controllers,data" />
  
    <!-- Add this -->
    <mvc:annotation-driven />
    
  </beans>
  ```
  
### Dependency

* Make sure to include the `hibernate-validator` dependency in your `pom.xml` in order to gain access to the validation annotations:
  
  ```xml
  <!-- pom.xml -->
  <dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>4.3.2.RELEASE</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
    </dependency>
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
    <!-- Add this for validation annotations -->
    <dependency>
      <groupId>org.hibernate</groupId>
      <artifactId>hibernate-validator</artifactId>
      <version>5.2.4.Final</version>
    </dependency>
  </dependencies>
  ```

<hr>

[Prev](README.md) | [Up](../README.md) | [Next](annotations.md)
