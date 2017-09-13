## Root and Servlet Contexts

Configuring a root and servlet WebApplicationContext requires

* Configuring multiple XML configuration files

* Referencing these files in `web.xml`

### web.xml
In web.xml we add a `ContextLoaderListener` and load XML files specified in the `contextConfigLocation`. These files - there can be multiple - are the root context.

We then load the servlet context as an `init-param` to the DispatcherServlet.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns="http://xmlns.jcp.org/xml/ns/javaee"
	xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
	version="3.1">
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>
      /WEB-INF/app-context.xml
			<!-- Can have multiple files -->
      <!-- /WEB-INF/spring/securityContext.xml -->
    </param-value>
	</context-param>
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>
	<servlet>
		<servlet-name>Books</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring/servlet/Books-servlet.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
	<servlet-mapping>
		<servlet-name>Books</servlet-name>
		<url-pattern>*.do</url-pattern>
	</servlet-mapping>
</web-app>
```

<hr>

[Prev](applicationcontexts.md) | [Up](../README.md) | [Next](component.md)
