# Configure Spring REST
### Routing with Spring
* Up to now we have done our routing with the `.do` convention. We want to eliminate this extension in our RESTful routes.

* In SpringMVC you may have written a route with this mapping:

```java
@RequestMapping("getEmployees.do");
```

* While this route is probably aptly named, it is almost redundant thanks to REST's verbs (i.e. `GET`).

* We can simplify the above mapping, by using the preferred *noun* based naming convention. Name the route a word associated with the resource (e.g. 'employees'), and explicitly assign it to a method:

```java
@RequestMapping(value = "employees", method = RequestMethod.GET);
```

* Convention dictates that this route is now an *index* route. An *index* route is one which requests ALL of the data for a resource with a `GET` request.

### Configuring the `url-pattern`

* To alter the route naming convention away from `*.do` in spring, alter the `<url-pattern>` property in the `<servlet-mapping>` of your 'web.xml':

```xml
<!-- Web.xml -->
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns="http://java.sun.com/xml/ns/javaee" xmlns:web="http://java.sun.com/xml/ns/javaee"
  xsi:schemaLocation="http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd"
  id="WebApp_ID" version="3.0">

  <servlet>
    <servlet-name>HR</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>HR</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
</web-app>
```

* This property can be changed to anything we want. The extension `.do` is a convention for standard Spring applications, where as `/api/*` is standard for Spring REST applications.

```xml
<web-app>
  <!--xmlns/xsi excluded for brevity -->
  <servlet>
    <servlet-name>HR</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>HR</servlet-name>
    <url-pattern>/api/*</url-pattern>
  </servlet-mapping>
</web-app>
```

The path to our respective method in the controller is now `/api/employees` instead of `getEmployees.do`.

### -servlet.xml
We also need to add a line of code to the `-servlet.xml` file. Above all of your JPA bean configuration add the line `	<mvc:annotation-driven />`. That's it, some of you have already been including this line of code. We need to make sure it is included to that our spring annotations work properly.

[Previous](spring_rest.md) | [Next](configure_rest_controller.md)
