## Sharing Data Between Servlets and JSPs

* You can share data between your Servlet and JSP using one of three different objects:

  * `ServletRequest`

  * `HttpSession`

  * `ServletContext`

* Use a `ServletRequest` or its subclass `HttpServletRequest` when the data to transfer is short lived.

  * Data stored as a request attribute is only available within the current request.

* Use an `HttpSession` when the data should be maintained on behalf of a particular user across requests.

  * By default, `HttpSession` uses a cookie to store a session identifier that is associated with an instance of `HttpSession`.

* Store global data within the `ServletContext`.

  * This data is available to all Servlets/JSPs for all users of a web application and should be used with caution.

* Call the `setAttribute(key, value)` method on any of the three aforementioned objects to actually store the data to the object.

  * The key must be a `String`, but the value can be any Object.

<hr>
Each request to a Servlet or JSP is invoked on a separate thread. Therefore, any shared data is susceptible to race conditions. Be especially cautious when accessing Servlet fields, ServletContext attributes, and HttpSession attributes making sure to use read-only access or synchronization appropriately.

[Prev](README.md) | [Up](../README.md) | [Next](02-BeanScopes.md)
