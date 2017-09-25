# Controller Configuration

* Inject your DAO in your controller so you can access it from within your `@RequestMapping` methods.

```java
@Controller
public class FilmController {
  @Autowired
  private FilmDAO filmDAO;
}
```

* When you retrieve a JPA entity from a DAO, the returned entity is unmanaged.

```java
@Controller
public class FilmController {
  @Autowired
  private FilmDAO filmDAO;

  @RequestMapping(path = "GetFilm.do", method = RequestMethod.GET)
  public String show(@RequestParam("id") Integer id, Model model) {

    Film film = filmDAO.show(id);

    model.addAttribute("film", film);

    return "film.jsp";
  }
}
```

  * Any changes you make to the entity will have no effect on the database, unless you merge it back into the persistence context. 

### Hands On:
1: Create a new package called *controllers* (in your MVC project) and add a class called *FilmController.java* to that package. `@Autowired` your DAO and add an `@RequestMapping` method to interact with it.


* Create an HTML file called *index.html* that uses your controller's route in your `WebContent` directory (e.g. assign the action to a form or an `href`).

* Create a new directory inside of `WebContent` named `film`.

  * Create a JSP file called *show.jsp* that displays your controller’s response, inside of the `film` directory.

```
WebContent/
├── WEB-INF
│   ├── video-servlet.xml
│   └── web.xml
├── film
│   └── show.jsp
└── index.jsp
```

2: Testing a `@Controller`'s request mappings:

* We setup most of the file structure we need to test our routes when we configured the DAO test. Now we just need to add a new package and use *MockMVC* to test the route handlers.

* In your `test` directory, create a new package named `ctrl` with a `FilmControllerTest` file in it.

* We will load the same context file to assemble the *WebApplicationContext*, only this time we will auto-wire the *FilmController*, and add a `FilmDAO` manually with a `set` method.

  * (add a `setFilmDAO(FilmDAO dao))` method in your *FilmController*.

* Then we use *MockMVC* to construct an internal servlet using our controller.

* The code below is a good starting point for this configuration.

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"../WEB-INF/DaoTest-context.xml"})
@WebAppConfiguration
@Transactional // you will need this if you are using DAO methods with transactions
public class FilmControllerTest {
  @Autowired
  private WebApplicationContext wac;

  private MockMvc mockMvc;

  @Autowired
  private FilmController controller;

  private FilmDAO dao;

  @Before
  public void setUp() throws Exception {
    dao = wac.getBean(FilmDAOImpl.class);
    controller.setFilmDAO(dao);
    this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
  }

  @After
  public void tearDown() throws Exception {
    controller = null;
    mockMvc = null;
    wac = null;
  }
}
```

* Now that your file is configured, we can write a test for your request handler:

```java
  @Test
  public void test_get_film_returns_film_view_and_model(){
    try {
      // Use MockMVC to create a request to the test servlet and get a response
      MvcResult response = mockMvc.perform(get("/GetFilm.do?id=1"))
                            .andExpect(
                                status().isOk()
                            ).andReturn();

      // Extract the returned ModelAndView from the response
      ModelAndView mv = response.getModelAndView();

      // Extract the Model from the ModelAndView
      ModelMap map = mv.getModelMap();

      // Cast the Object value paired to the "film" key to a Film object
      Film f = (Film) map.get("film");

      // Check the values with JUnit tests
      assertEquals("film.jsp", mv.getViewName());
      assertEquals("ACADEMY DINOSAUR", f.getTitle());

    } catch (Exception e) {
      fail(e.toString());
    }
  }
```

[Previous](dao.md) | [Next](web_xml.md)
