## Using `@Component` to Discover Beans

* We have seen how XML can be used to create and configure beans for use in an application.

* In large applications, as the number of beans increases the corresponding XML will grow as well; This can quickly become difficult to manage and maintain.

* Since Spring 2.0, Spring provided an alternative configuration method to XML using annotations:

  * `@Repository`: Used to mark a POJO as a DAO component

  * `@Controller`: Used to mark a POJO as a request handling component for SpringMVC

  * `@Service`: Marks a POJO as a service, an operation offered as an interface that stands alone in the model with no encapsulated data

  * `@Component`: The most generic annotation, used to designate a POJO as a bean.

    * The other annotations provide a more specific stereotype that can be useful in Aspect Oriented Programming.

    * If you are not sure which annotation to use, just use `@Component`.

> Aspect Oriented Programming seeks to eliminate *cross-cutting concerns* which entangle code making it difficult to maintain and often leads to repetition. Doing so by extracting common behavior into *Aspects* which implement code (*advice*) at specific points of execution (*pointcuts*) throughout and application.

* Once a POJO is annotated with one of the above annotations, it is eligible for auto-detection by the `<context:component-scan base-package="com.package.name"/>` in your `DispatcherServlet`'s XML configuration.

  ```java
  // data.MyDAO

  @Component
  public class MyDAO implements DaoInterface { }
  ```

* If your `@Component`s are spread across multiple packages, you can easily add additional packages to the `component-scan` by comma seperating them:

  ```xml
  <!-- Dispatcher-servlet.xml -->
  <context:component-scan base-package="controllers, data, entities, etc"/>
  ```

* Once beans have been annotated with `@Component`, and had their package added to the `component-scan`, they no longer require definition in xml.

* These beans are now eligible for autowiring with the `@Autowired` annotation:

  ```java
  // controllers.MyController

  @Controller
  public class MyController {
    @Autowired
    private DaoInterface dao;
  }
  ```

* In order for autowiring of an interface to work, _there must be only one @Component of that interface type_. Otherwise a runtime exception occurs, which will cause the application to fail on startup. For example:

  > nested exception is org.springframework.beans.factory.NoSuchBeanDefinitionException: No unique bean of type [data.DaoInterface] is defined: expected single matching bean but found 2: [myDao, jdbcDao]

* If multiple implementers of an interface exist, use `@Qualifier` to specify which implementer to use.

  * The name will be the class name, with the first letter lowercased.

    ```java
    // controllers.MyController

    @Controller
    public class MyController {
      @Autowired
      @Qualifier(value = "myDaoImpl")
      private DaoInterface dao;
    }
    ```

  * Or use @Resource to refer to a named @Component

    ```java
    // controllers.MyController
    @Controller
    public class MyController {
      @Resource(name = "myDaoImpl")
      private DaoInterface dao;
    }
    ```

    ```java
    // data.MyDaoImpl
    @Component("myDaoImpl")
    public class MyDaoImpl implements DaoInterface { }
    ```

[Prev](webappcontext.md) | [Up](../README.md) | [Next](singleton.md)
