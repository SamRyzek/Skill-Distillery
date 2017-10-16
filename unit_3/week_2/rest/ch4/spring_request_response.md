# `HttpServletRequest` and `HttpServletResponse`

### Review Response Handling and Dependency Injection
* Accessing the `HttpServletResponse` object from a Spring controller route is possible thanks to Spring's *dependency injection*.  

* When a request is received by the Tomcat server, it is mapped to a dispatcher servlet (this is configured in your `web.xml`). In turn, the dispatcher servlet determines if there is a controller route with a `@RequestMapping` capable of handling the request. Along the way, the servlet creates several objects that will be needed for the request to be handled (notably a `HttpServletRequest` and a `HttpServletResponse` object), it then injects these dependencies into the controller method which is responsible for handling the request.  

* As a result of this dependency injection, **EVERY** spring mvc controller method has access to the `HttpSerlvetRequest` and `HttpServletResponse` objects (whether or not you chose to use them).  

### Examples

* Example 1:  
  * The following route is 100% valid in Spring, and will respond with the `String` `"pong"`, and a Http Status Code of `200` by default:

```java
@RestController
public class ExampleController {
  @RequestMapping("/ping")
  public String ping() {
    return "pong";
  }
}
```

* It is possible to write the same controller method and gain access to the injected `HttpServletRequest` and `HttpServletResponse` by parameratizing them in the method signature:  

* Example 2:
  * This method produces the exact same result as the previous method:

```java
@RestController
public class ExampleController {
  @RequestMapping("/ping")
  public String ping(HttpServletRequest request, HttpServletResponse response) {
    return "pong";
  }
}
```

* With access to the request and response objects, it is possible to extract/modify information from these objects.  

* Example 3:
  * This method still responds with the `String` `"pong"`, but we have changed the response's status code `to` `202` ('Accepted'), and includes a `"Location"` header, indicating where this information can be found again.

```java
@RestController
public class ExampleController {
  @RequestMapping("/ping")
  public String ping(HttpServletRequest request, HttpServletResponse response) {
    response.setStatus(202);
    response.setHeader("Location","http://localhost:8080/ping");
    return "pong";
  }
}
```

* Similarly, it is possible to gain additional information about a request from the `HttpServletRequest` object.  

* Example 4:
  * In the following method, we will only respond with `"pong"`, status `202` and the `Location` header **IF** the request has a `'say-please'` header. Otherwise, the method will send back a `401` ('Unauthorized'), and the text `"you didn't say the magic word"`:

```java
@RestController
public class ExampleController {
  @RequestMapping("/ping")
  public String ping(HttpServletRequest request, HttpServletResponse response) {
    if (request.getHeader("say-please") != null) {
      response.setStatus(202);
      response.setHeader("Location","http://localhost:8080/ping");
      return "pong";
    }
    response.setStatus(401);
    return "you didn't say the magic word";
  }
}
```

* Some of your controller methods will not need to modify the request or response at all, in these cases you won't need to create a parameter for either of the injected objects, the key takeaway is that if you require access to either, they are both made available to you by SpringMVC's dependency injection.


[Previous](status_codes.md) | [Next](quiz_crud.md)
