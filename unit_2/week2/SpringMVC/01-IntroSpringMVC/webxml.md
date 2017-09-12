## `web.xml`

* You must add a `web.xml` file to the *WEB-INF* folder in your web application to configure the Spring MVC servlet.
  
  * The `<servlet-class>` entry must be set to `org.springframework.web.servlet.DispatcherServlet`.
  
  * The `<servlet-name>` can be anything, but must be the same in both the `<servlet>` and `<servlet-mapping>` sections.
  
    * Also, the name you choose will be used later as part of the name of another Spring configuration file (the *Dispatcher Servlet*), so it should be something meaningful.
  
  * The `<url-pattern>` element specifies what requests should be handled by the **DispatcherServlet**.
  
    * For the `<url-pattern>` it is typical to use `*.do`, but any pattern can be substituted.
  
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
  version="3.1">
  <welcome-file-list>
    <welcome-file>lotto.do</welcome-file>
  </welcome-file-list>
  <servlet>
    <servlet-name>Lotto</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>Lotto</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
</web-app>
```
  
<hr>

### Hands On:
  
1: Create a `web.xml` file in the *WebContent/WEB-INF* directory.
  
* Add a `<web-app ...` element to the top of the file, and a closing `</web-app>` element at the bottom.
  
* Between the opening and closing `<web-app>` elements, configure the `<servlet>` and `<servlet-mapping>` elements for your application.
  
  * `<servlet>` should designate a *DispatcherServlet* you will create by name (in a `<servlet-name>` element), and a `<servlet-class>` specifying *`org.springframework.web.servlet.DispatcherServlet`*
  
  * `<servlet-mapping>` should again designate a *DispatcherServlet* by name in a `<servlet-name>` element, and select a `<url-pattern>`. We will be using he `.do` pattern.
  
  
[Prev](dependencies.md) | [Up](../README.md) | [Next](servletxml.md)
