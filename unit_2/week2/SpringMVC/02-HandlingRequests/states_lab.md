## States Lab

### Objective

* Create an application which allows users to query data about states by state abbreviation or state name.

* Gain additional experience configuring SpringMVC projects.

* Have fun!

### Starter Files

* The following files have been provided to get you started on this project.

  * [`WebContent/`](WebContent) : HTML and JSP files for your project

  * [`WebContent/WEB-INF/states.csv`](WebContent/WEB-INF/states.csv) : A data file

  * [`controllers/StateController.java`](controllers/StateController.java) : A controller stub

  * [`data/State.java`](data/State.java) : A class representing a state

  * [`data/StateDAO.java`](data/StateDAO.java) : An interface for the DAO

  * [`data/StateDAOImpl.java`](data/StateDAOImpl.java) : A file reader to load state data from the CSV and several method stubs to access the data

  * [`test/controllers/MockStateDAO.java`](test/controllers/MockStateDAO.java) : A mock object implementing the StateDAO interface, with two states, for testing.

  * [`test/controllers/StateControllerTests.java`](test/controllers/StateControllerTests.java) : Spring MVC JUnit tests

  * [`test/controllers/StateControllerTests-context.xml`](test/controllers/StateControllerTests-context.xml) : servlet application configuration file which loads a mock object

  * As well as several views in the `WebContent` directory

### Instructions
1. Create a new Dynamic Web Project in Eclipse name 'USStates'.  

2. Convert the project to Maven project, and include the following dependencies:  

   ```xml
   <dependencies>
     <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-webmvc</artifactId>
       <version>4.3.2.RELEASE</version>
     </dependency>
     <dependency>
       <groupId>javax.servlet</groupId>
       <artifactId>javax.servlet-api</artifactId>
       <version>3.1.0</version>
     </dependency>
     <dependency>
       <groupId>javax.servlet</groupId>
       <artifactId>jstl</artifactId>
       <version>1.2</version>
     </dependency>
     <dependency>
       <groupId>junit</groupId>
       <artifactId>junit</artifactId>
       <version>4.12</version>
     </dependency>
     <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-test</artifactId>
       <version>4.3.2.RELEASE</version>
     </dependency>
     <dependency>
       <groupId>org.hamcrest</groupId>
       <artifactId>hamcrest-junit</artifactId>
       <version>2.0.0.0</version>
	   </dependency>
   </dependencies>
   ```

3. Create a `web.xml` in the `WEB-INF` directory. Configure the `web.xml` to use a dispatcher servlet named `States` and the `<url-pattern>*.do</url-pattern>`.  

4. Create a `States-servlet.xml` in the `WEB-INF` directory. Add a `<context:component-scan>` element which points at the `base-package` "controllers".  

   * Configure a bean with the `id` "dao" and the `class` "data.StateDAOImpl".

   * Add the `<mvc:annotation-driven/>` tag to allow Post-Redirect-Get with `RedirectAttributes`.

5. Create a `data` package and place the `State.java`, `StateDAO.java` and `StateDAOImpl.java` provided inside of it. Review the code in the `StateDAOImpl.java` file to see how the `.csv` data is being loaded.  

6. Add the `states.csv` file to the `WEB-INF` directory.

7. Create a `controllers` package and place the `StateController.java` in it.  

8. Move the `.html` and `.jsp` files from [`WebContent/`](WebContent) into your WebContent directory.

9. Configure the `StateController`.

   * Add an `@Autowired` `StateDAO`. Generate a `setter` for this field.

10. Configure the `StateControllerTests`.

   * Note that the XML configuration file creates a mock object, which is placed in the controller.

   * Configure the MockMvc object in `setUp()` using `MockMvcBuilders.webAppContextSetup(wac).build()`.

   * Write the tests based on their method names, and the example test method. Make sure to check the values of properties in the mock object. They will all fail when run.

11. Configure the `StateController`.

   * Create the controller methods as prompted by the "TODO"s.

   * Run JUnit tests to verify your methods.

12. Complete the `StateDAOImpl` methods as prompted by the "TODO"s.  

13. Each state object in the model of the USStates web application has an additional property for the population of the capital. Modify the State object, DAO implementation, and view so that this data is displayed as well.  

14. Each state object also contains properties for the latitude and logitude of the state capital. Search the internet for information on how you can use this extra data to embed a map in your view.  

15. Study `State.java`, `StateDAO.java`, and `StateDAOImpl.java` to see how the model data is loaded from `WebContent/WEB-INF/states.csv`. Add an additional column of data in the csv file for something else about the state that you wish to display (i.e. bird, flower, motto, flag, etc) and modify the application to also display this additional information.  

16. Comment out the entire test `test_POST_NewState_do_adds_state_and_returns_resultJSP()`. Copy-paste this test and rename it `test_POST_NewState_do_adds_state_and_redirects_to_stateAdded()`.

   * Change the test to check for a 3xx redirect instead of 200 OK.

   * Check flash attributes to see that the state is added.

   * Change the expected view name to `redirect:stateAdded.do`.

17. Uncomment and complete the test for `test_GET_stateAdded_do_returns_resultJSP_view()`.

18. Change your unit tests to check for `"result"` instead of `"result.jsp"`. Run the JUnit tests and see that they fail. Then change the Controller to no longer return the ".jsp" suffix, and verify the unit tests pass. Now add an [`InternalResourceViewResolver`](views.md) to your servlet configuration XML file. **Note:** Your JSP and HTML files live in the root directory `WebContent`. Therefore, your `InternalResourceViewResolver` will not need a `prefix`. Verify that the app itself works in the browser.

19. Use any HTML or CSS skills you have learned to improve the look and feel of the application.  

20. Build another Spring MVC web application based on the data stored in `presidents.csv`. The user should be able to type in a president's term number and pull up information about that president.  

21. Add to your Presidents application so that the user can also search for presidents using additional criteria: (last name, party, term length, etc).

<hr>

[Prev](unittesting.md) | [Up](../README.md)
