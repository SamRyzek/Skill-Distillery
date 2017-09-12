## Spring Configuration File (*Dispatcher Servlet*)

### What is a *DispatcherServlet*?

>Incoming requests enter the framework via a Front Controller. In the case of Spring MVC, this is an actual Java Servlet called DispatcherServlet. Think of DispatcherServlet as the gatekeeper. It doesn’t perform any real web or business logic, but rather delegates to POJOs called Controllers where the real work is done (either in whole or via the back-end). When the work has been done, it’s the responsibility of Views to produce the output in the proper format (whether that’s a JSP page, Velocity template, or JSON response). Strategies are used to decide which Controller (and which method(s) inside that Controller) handles the request, and which View renders the response. The Spring container is used to wire together all these pieces.
> - Spring.io Blog: [http://spring.io/blog/2011/01/04/green-beans-getting-started-with-spring-mvc/][greenies]

<hr>

### How to configure a simple *Web Application Context*?

* In addition to the `web.xml` you must also create a Spring configuration file and save it in the *WEB-INF* folder.

  * Name the file `<servlet-name>-servlet.xml` where the *servlet-name* is the one you specified in the `<servlet-name>` element in the `web.xml`.

    * **EXAMPLE**: If you used *WebApp* as the `<servlet-name>` in the `web.xml`, then you should name the file `WebApp-servlet.xml`.

  * Add the `<context:component-scan base-package="packagename" />` element, where `"packagename"` is the package that contains the class(es) with the `@Controller` annotation.

  * Configure any Spring beans that you would like to use in your web applciation using `<bean>` declarations.

    * Add `id` attributes to specify an alias for the bean.

    * Add `class` attributes to specify a fully qualified class name for your POJO.

    * Use `<constructor-arg>` child elements to call the POJO's constructor.

      * Identify which `arg` you are populating through the use of a zero based **index** attribute.

      * Use a `value` attribute to pass a string or primitive or a `ref` attribute to specify another bean.

    * You can also use the `<property>` child elements to call `set()` methods on the newly created bean.

      * The property must specify which `set()` method to invoke by use of the `name` attribute - the name is derived from the `set()` method name without the prefix *set*.

      * Like with `<constructor-arg>`, use a `value` attribute to pass a string or primitive or a `ref` attribute to specify another bean.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
  xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
  xsi:schemaLocation="
    http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
    http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
    http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
    http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">

  <context:component-scan base-package="web"/>

  <bean id="lottery" class="lotto.Hopper">
    <property name="name" value="Lottery Numbers"/>
    <property name="pingPongBalls">
      <list>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="1" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="2" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="3" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="4" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="5" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="6" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="7" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="8" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="9" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="10" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="11" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="12" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="13" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="14" />
        </bean>
        <bean class="lotto.PingPongBall">
          <constructor-arg value="15" />
        </bean>
      </list>
    </property>
  </bean>
</beans>
```

<hr>

### Hands On:
1: Now you will create a simple web application configuration file (*Lotto-servlet.xml*) like the one above.  

* Make sure that the *Lotto-servlet.xml* is in the *WEB-INF* directory.

[Prev](webxml.md) | [Up](../README.md) | [Next](controller.md)


[greenies]:http://spring.io/blog/2011/01/04/green-beans-getting-started-with-spring-mvc/
