## The web.xml File

* Provide an optional deployment descriptor to supply additional configuration information for your web application.

  * Create it as WEB-INF/web.xml in your web application directory.

* List files the container should look for when the user request specifies a context with the `<welcome-file-list>` element.

* Use a `<servlet>` element to define each of your servlets.

  * Specify a unique `<servlet-name>` for each component.

  * For servlets, specify the full class name in the `<servlet-class>` element.

* Use the <servlet-mapping> element to map a servlet or JSP page to a specific URL within your web application.

  * The `<servlet-name>` is the name you specified in the `<servlet>` element.

  * The URL you specify in the `<url-pattern>` element is relative to the context path.

<hr>

HelloWorld/WebContent/WEB-INF/web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
                             http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
         version="3.0">
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
  </welcome-file-list>
  <servlet>
    <servlet-name>TheServletName</servlet-name>
    <servlet-class>web.HelloWorldServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>TheServletName</servlet-name>
    <url-pattern>/SayHello</url-pattern>
  </servlet-mapping>
</web-app>
```

#### Note:
Prior to the Servlet 3.0 specification, `web.xml` was required. Servlet 3.0 defined several annotations that you can add to your code to take the place of many, but not all, of the `web.xml` entries.


[Prev](03-WarFile.md) | [Up](../README.md) | [Next](05-DeployWar.md)
