## Web Applications

* Web applications are applications that the end user can access using a standard web browser.

* The Java Platform Enterprise Edition (Java EE) defines a web application as a collection of web components and supporting files.

  * Web components include Java servlets and JSP files.

  * Supporting files include static HTML documents, image files, and supporting classes.

* Your web application runs in the environment of a *web container*, which is managed by an application server.

  * Web containers can contain several web applications.

  * Your applications can work together or operate independently.

* Each web application is addressed with a context path.

  * The context path is determined when the application is deployed.

  * A web container can contain a "default" application, which has an empty context path.

  * To access a component or file in the web application from a browser, you must include the context path in the request URL.
  
<hr>

![Web Container and Applications](../images/WebContainer.png)

[Prev](README.md) | [Up](../README.md) | [Next](02-JspServlet.md)

