## ApplicationContexts

Spring creates beans, which it manages in an _ApplicationContext_. According to Spring:
>The ApplicationContext is the central interface within a Spring application for providing configuration information to the application.
> - Spring.io: [https://spring.io/understanding/application-context](https://spring.io/understanding/application-context)

This just means the place where Spring manages all the beans you and it configure for your webapp.

Simple applications usually need only one application context, but there are often two contexts in a web application: the Root WebApplicationContext and Servlet WebApplicationContext. These are configured in different Spring configuration files.
* **Note**: the code for each context should be in different packages. For example, root context code could be in the package `app` while servlet context code could be in the package `web`. This is important when component scanning is used (especially when unit testing).

_See Spring.io:  [https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-servlet](https://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-servlet)_

#### Root WebApplicationContext
The root context usually contains shared resources like data sources or middle-tier objects.

#### Servlet WebApplicationContext
This context contains beans and configuration that are specific to that servlet, such as controllers.

[Prev](README.md) | [Up](../README.md) | [Next](webappcontext.md)
