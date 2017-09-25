# `web.xml`
* Like before, configure the Spring *DispatcherServlet* in your *web.xml* so it responds to *.do* requests.

### Hands On:
* Create a web.xml file and add it to your WebContent directory.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
     xmlns="http://xmlns.jcp.org/xml/ns/javaee"
     xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
       http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
     version="3.1">
  <servlet>
    <servlet-name>VideoStore</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet
    </servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>VideoStore</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
</web-app> 
```

* Run your MVC application on the server, see if it works as expected.

[Previous](controller.md) | [Next](labs.md)
