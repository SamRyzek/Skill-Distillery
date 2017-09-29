# Modifying the Data Access Object to Utilize Spring

* Mark the whole class as `@Transactional` to have Spring automatically start a transaction for each DAO method and commit the transaction at the end of the method.

```java
@Transactional
@Repository
public class ActorDAOImpl implements ActorDAO {
  // ...
}
```


  * An unchecked (runtime) exception will trigger a rollback.

* Inject an *EntityManager* into a field using the `@PersistenceContext` annotation.

```java
@Transactional
@Repository
public class ActorDAOImpl implements ActorDAO {

  @PersistenceContext
  private EntityManager em;
  // ...
}
```

  * You can now use this field in your DAO methods to call `find()`, `persist()`, etc.

  * This is a container managed *EntityManager*, so you should not call `close()` on it.

### Hands On:
1: Create a package called *data* and an interface called *FilmDAO.java* that exposes a single method: `show()`.

2: Next create a class that implements the interface called *FilmDAOImpl.java*. Add code to retrieve a *Film* using the *EntityManager* `find()` method.

  * Instead of retrieving the *EntityManager* from the *Persistence*, declare an *EntityManager* as a field and annotate it with `@PersistenceContext`

  * Be sure to mark your *FilmDAOImpl* with both `@Transactional` and `@Repository`

3: Testing a DAO configured with Spring requires some additional considerations. In order to fully utilize Spring's convenience annotations (`@PersistenceContext`, `@Autowired`, `@Transactional`) with our tests, we must utilize the beans in the application context.

* We need to create a number of directories and files:

  * a `test` src folder at the same level as `src`. Which contains:

    * a `META-INF` directory.

      * with a copy of your `persistence.xml` from the JPA project.

        * rename your *PersistenceUnit* to `TestVideoStore` (failing to do so will create an exception later)

    * a `WEB-INF` directory.

      * with a `Test-context.xml`

        * create a new *Spring Bean Configuration File*, include:

          * a `context:component-scan` for your *controllers* package (we will need this later)

          * a bean configuring an *EntityManagerFactory*

            * provide it the `TestVideoStore` *persistenceUnitName* property

          * a bean configuring a *TransactionManager*

          * `mvc:annotation-driven`

          * a bean configuring a `FilmDAOImpl`

    * a `dao` package.

      * with a `FilmTest.java` in it.

* Ultimately, your file structure should look like this:

```
MVCVideoStore/
├── WebContent
│   ├── WEB-INF
│   │   ├── VideoStore-servlet.xml
│   │   └── web.xml
│   └── index.jsp
├── src
│   ├── controllers
│   │   ├── FilmController.java
│   │   └── TestController.java
│   └── data
│       ├── FilmDAO.java
│       └── FilmDAOImpl.java
└── test
    ├── META-INF
    │   └── persistence.xml
    ├── WEB-INF
    │   └── Test-context.xml
    ├── ctrl
    │   └── FilmControllerTest.java
    └── dao
        └── FilmTest.java
```

* Configuring `FilmTest.java`:

  * We need two key components to run our Spring application:

    * first, the *ApplicationContext*, in this case we will use a *WebApplicationContext*, below, we are auto-wiring it.

    * This is coming from the `@ContextConfiguration`, which is loading a bean configuration file and creating the context.

* Use the following configuration as a starting point for your test file.


```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "../WEB-INF/Test-context.xml"})
@WebAppConfiguration
@Transactional
public class FilmTest {

  @Autowired
  private WebApplicationContext wac;

  @Autowired
  private FilmDAO dao;

  @PersistenceContext
  private EntityManager em;

  @Before
  public void setUp() {
    dao = (FilmDAO) wac.getBean("filmdao");
  }

  @After
  public void tearDown() {
    dao = null;
    em = null;
    wac = null;
  }
}
```

* Write a test for your `FilmDAO.show()` method.



4: Now create implement the remaining CRUD methods to get some experience with the ease of JPA with Spring:

```java
public Film show(int id);

public List<Film> index();

public Film update(int id, Film film);

public boolean destroy(int id);

public Film create(Film film);
```


[Previous](servlet_xml.md) | [Next](controller.md)
