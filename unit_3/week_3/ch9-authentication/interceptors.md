# Spring `HandlerInterceptor` Interface

* Securing specific routes can be accomplished a number of ways.

  * You could write individual logic in each request handler determining if a User was authenticated to access data. Or write shared functionality in a helper method...

  * The downside to both of these approaches is that they require multiple implementations when typically user authentication is accomplished the same (or similar) way.

* The `HandlerInterceptor` interface exposes methods that can be applied to given routes as middleware which prehandles tasks like authentication.

### Using Handler Interceptors

* The `HandlerInterceptor` interface can be implemented on a custom class of your creation.

* For authentication purposes the `HandlerInterceptor.preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)` method is the most useful.

  * `prehandle` is called before SpringMVC forwards a matching route to a requst handler.

  * `prehandle` will return a boolean, where:

    * `true` forwards the message to the original destination
    * `false` rejects the message

```java
package security;

public class DataSecurityInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    // 1
    if (request.getSession().getAttribute("user") != null) {
      return true;
    }
    // 2
    response.sendRedirect("auth/unauthorized");
    return false;
  }
}
```

1: Retrieve the `HttpSession` from the `HttpServletRequest` object, check for a `"user"` attribute.

  * In this implementation, all the handler does is check that there is a `"user"` value in session. You could add additional logic to ensure that the provided `@PathVariable` for the `User` id matches the user in session.

  * if you were interested in extracting the `@PathVariable manually`, you can use `request.getRequestURI()` to get the URI and the pattern match for it:

```java
String URI = request.getRequestURI(); // => /ngTodo/api/user/6/todo
```

2: If the `User` is not in session, you will want to return `false` from the handler, but this will not set the reponse status to a meaningful code, nor will it provide additional error handling.

  * Use the `HttpServletResponse.sendRedirect("request/mapping")` to forward the response to another request handler (in the above example it is a method that responds with `401` and `"unauthorized"`)

```java
  @RequestMapping(path = "/unauthorized")
  public String unauth(HttpServletResponse res) {
    res.setStatus(401);
    return "unauthorized";
  }
```

### Assigning Interceptors to Request Mappings

* With a security `HandlerInterceptor` configured, you now have to set configuration to let SpringMVC know when to apply the filter.

  * Obviously you don't want to apply the `HandlerInterceptor` to EVERY route...it would be impossible to log in.

* In your Dispatcher Servlet, use the `<mvc:interceptors>` tag to assign interceptors.

  * *interceptors* is a list of `<mvc:interceptor>` tags, each of these can define a different interceptor.

    * *interceptor* tags require: 
      * a `<mvc:mapping path="path/to/match">` 
      * a *bean* for the `HandlerInterceptor` to apply

```xml
<!-- previous servlet content -->

  <mvc:interceptors>
    <mvc:interceptor>
      <mvc:mapping path="/user/*/todo/**" />
      <bean id="DataSecurityInterceptor" class="security.DataSecurityInterceptor" />
    </mvc:interceptor>
  </mvc:interceptors>

<!-- additional servlet content -->
```

### Hands On

1: Create a package named : `security`

2: Create a class named `DataSecurityInterceptor` which implements `HandlerInterceptor`

3: Override the `preHandle` method and check for a "user" in session. If one exists, return true, otherwise return false.

4: Apply the interceptor to the `/user/*/todo/**` route in your dispatcher servlet.


#### [Prev](encryption.md) | [Next](ng-cookies.md)