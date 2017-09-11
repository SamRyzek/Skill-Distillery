## HttpSession

* Since HTTP is a stateless protocol, tracking a user from one page to another within your website requires developers to make use of creative solutions, such as cookies, hidden form fields, and URL rewriting.

* The `javax.servlet.http.HttpSession` class simplifies session tracking for Java web applications.

* Retrieve the session object from the `HttpServletRequest` object:

```java
HttpSession session = request.getSession();
```

  * If the session does not already exist, the request creates it.

* Set attributes on the session as a key, value pair.

```java
session.setAttribute("name", "Jane");
```

* Set a timeout for the session with the `setMaxInactiveInterval()` method passing in the time in seconds.

```java
session.setMaxInactiveInterval(600);
```

  * If the session has not been accessed before the time expires it will be invalidated and any objects bound to it will be unbound.

  * You can proactively destroy the session object by calling `invalidate()` on it.

  ```java
  session.invalidate();
  ```

<hr>

[Prev](02-BeanScopes.md) | [Up](../README.md) | [Next](04-ServletContext.md)
