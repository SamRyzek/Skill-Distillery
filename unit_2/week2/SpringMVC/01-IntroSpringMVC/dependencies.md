## Dependencies

### Spring MVC

* Spring MVC requires the `spring-webmvc` Maven dependency to be included in your `pom.xml`:
  
```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-webmvc</artifactId>
  <version>4.3.2.RELEASE</version>
</dependency>
```
  
* `spring-webmvc` is a superset of `spring-context` (meaning it includes it). As such, you can use the `spring-webmvc` dependency instead of `spring-context`.
  
### JSP / JSTL
* To make use of JavaServer Pages (JSP), and JSP Standard Tag Library (JSTL), you will also need to include these dependencies:
  
```xml
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
```
  
<hr>

### Hands On:
2: Convert the 'SpringLottoWeb' project to a Maven Project.  
  
3: Add the `spring-webmvc`, `javax.servlet-api`, and `jstl` dependencies.  
  
4: Copy the `lotto` package from the previous project into the `src` directory in 'SpringLottoWeb', we shouldn't need to alter these in anyway.
  
  
[Prev](file_structure.md) | [Up](../README.md) | [Next](webxml.md)

