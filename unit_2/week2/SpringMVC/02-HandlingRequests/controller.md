## `Handling Requests with @Controller`

* Use the `@Controller` annotation on a POJO class to ask Spring to automatically load it as a Spring bean.

  ```java
  package web;

  import org.springframework.stereotype.Controller;

  @Controller
  public class MyController {

  }
  ```

* For this auto-discovery to take place, your Spring XML coniguration (in your *dispatcher-servlet.xml*) must identify the package that your controller belongs to using the `<context:component-scan>` element.

  ```xml
  <context:component-scan base-package="web" />
  ```

* If you have more than one package that contains controllers, comma separate the names within the *base-package* attribute:

  ```xml
  <context:component-scan base-package="web, com.code.controllers" />
  ```

<hr>

[Prev](README.md) | [Up](../README.md) | [Next](mapping.md)
