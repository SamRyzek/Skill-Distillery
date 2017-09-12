## View Resolvers

* The "V" and "C" in "MVC" are separate, and Spring allows us to separate the View from the Controller by using a `ViewResolver`.

* The default resolver is `InternalResourceViewResolver`. It interprets view names as JSP paths.

* You do not need to configure a View Resolver in your bean configuration file, but you can. An `InternalResourceViewResolver` is commonly configured with a default prefix/suffix.

  ```xml
  <bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
      <property name="prefix" value="/WEB-INF/"/>
      <property name="suffix" value=".jsp"/>
  </bean>
  ```

  * This allows us to return "local view names." Doing so decouples the Controller from the View technology (JSP).

    ```java
    @Controller
    public class InfoController {
      @RequestMapping(path = "GetInfo.do", method = RequestMethod.GET)
      public String getInfo(Model model) {
        return "info";  //no longer info.jsp
      }
    }
    ```

<hr>

[Prev](return_type.md) | [Up](../README.md) | [Next](command.md)
