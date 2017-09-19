## Hands On - A Spring/MVC Application Using JDBC

Let's put everything together and build a full-stack Spring/MVC application that accesses a back-end database using JDBC.

### 1: Create a New Project in Spring Tool Suite (STS):

1. File | New | Dynamic Web Project

   * Name: **MVCFilmSite**
     * Target Runtime: _None_
     * **Next**
   * Java
     * Source folders on build path:
     * Remove _src_
     * Add Folder...:
       * _src/main/java_
       * _src/test/java_
     * **Next**
   * Web Module
     * Check _Generate web.xml deployment descriptor_
     * **Finish**

### 2: Configure Gradle and Spring Nature

1. _MVCFilmSite_ | Configure | Add Gradle Nature

  * Drag _MVCFilmSite_ back into the _JavaWeb_ working set

2. Gradle Tasks view:

  * F5 to Refresh view

  * Select _MVCFilmSite_ | _build-setup_ | _init_

3. Package Explorer view

   * F5 Refresh to see gradle files

   * In _build.gradle_

     * Update the usual suspects:

     ```java
     /*
     * Sample Gradle build configuration for a Spring/MVC project 
     */
     
     version = '1.0.0-BUILD-SNAPSHOT'  // Bump this as you add features/fix bugs
     
     apply plugin: 'java'
     apply plugin: 'war'
     apply plugin: 'eclipse-wtp'
     
     sourceSets {
       main {
         java.srcDirs 'src/main/java'
       }
       test {
         java.srcDirs 'src/test/java'
       }
     }
     
     war {
       archiveName = "${baseName}.war"
       destinationDir = file("./")      // Project root
     }
     
     project.webAppDirName = 'WebContent'
     
     repositories {
        mavenCentral()
     }
     
     dependencies {
         compile group: 'org.springframework', name: 'spring-webmvc', version:'4.3.2.RELEASE'
         compile group: 'javax.servlet', name: 'javax.servlet-api', version:'3.1.0'
         compile group: 'javax.servlet', name: 'jstl', version:'1.2'
         testCompile group: 'junit', name: 'junit', version: '4.12'
         testCompile group: 'org.springframework', name: 'spring-test', version:"4.3.2.RELEASE"
     }
     
     eclipse {
       classpath {
         downloadSources = true
       }
       project  {
         natures 'org.springframework.ide.eclipse.core.springnature', 
                 'org.eclipse.buildship.core.gradleprojectnature'
       }
     }
     ```

   * Gradle | Refresh Gradle Project

     * Dependency JARs should appear under Project and External Dependencies.

### 3: Define a DAO

1. Select _src/main/java_ and go to New Package

   * **com.skilldistillery.film.data**

2. Define a DAO interface:

   * Select _com.sd.film.data_ and go to New Interface

     * Name: **FilmDao**

   * Define a method in _FilmDao.java_

     ```java
     String getFilmTitleById(int id);
     ```

3. Create a DAO Implementation:

   * Select _com.sd.film.data_ and go to New Class

     * Name: **FilmDaoDBImpl**

     * Interfaces | Add

       * Start typing "FilmDao" and select it when it appears

     * Finish

4. Use the DAO implementation's constructor to load the MySQL JDBC driver.

   * In _FilmDaoDbImpl_

     ```java
     public FilmDaoDbImpl() {
       try {
         Class.forName("com.mysql.jdbc.Driver");
       } catch (ClassNotFoundException e) {
         e.printStackTrace();
         System.err.println("Error loading MySQL Driver!!!");
       }
     }
     ```

5. Add connection information in _FilmDaoDbImpl_

   ```java
   private static String url = "jdbc:mysql://localhost:3306/sdvid";
   private String user = "student";
   private String pass = "student";
   ```

6. Implement the `getFilmTitleById()` method:

   ```java
   @Override
   public String getFilmTitleById(int id) {
     String title = null;
     try {
       Connection conn = DriverManager.getConnection(url, user, pass);
       String sql = "SELECT title FROM film WHERE id = ?";
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setInt(1, id);
       ResultSet rs = stmt.executeQuery();
       if (rs.next()) {
         title = rs.getString(1);
       }
       rs.close();
       stmt.close();
       conn.close();
     } catch (SQLException e) {
       e.printStackTrace();
     }
     return title;
   }
   ```

### 4: Springify

1. Open _WebContent/WEB-INF/web.xml_

   * Remove the extra `<welcome-file>` elements, leave just one that goes to `home.do` (not `home.jsp`).

   * Before the closind `</web-app>` tag: 
     * Type `DS` and hit `Ctrl-Space`
     * Select `dispatcherservletg` from the content assist menu.
     * Hit `Enter`
     * Change the `param-value` from `location` to `/WEB-INF/spring/context-config.xml`
     * Change the `url-mapping` from `url` to `*.do`.
     * Save.

2. Create a bean configuration file.

   * Under _WebContent/WEB-INF/_ create a new folder, `spring`.
   * Click the new folder and go to `New` | `Spring Bean Configuration File`
     * Name it `context-config.xml`.
     * In the _Namespaces_ tab, select `context` and `mvc` in addition to `beans`.
     * Back in the Source, between the `beans` tags, type `comp`, hit `Ctrl-Space`, and pick `context:component-scan` from the menu.
       * Set `base-package` to `com.skilldistillery`.
     * Add a `bean` element with the class `com.skilldistillery.film.data.FilmDaoDbImpl`.
       * `bean` then `Ctrl-Space`, select `bean` from the list.
       * Add the `class` attribute and inside the quotes type `FDDI` and hit `Ctrl-Space`.

### 5: Create a form in _home.jsp_

1. In _WebContent/WEB-INF/_, create a new Folder named `views`.
2. Create a new JSP file, `home.jsp`, in _WebContent/WEB-INF/views/_

   * Add a form.

     * For _method_, let's use `GET`.
     * For _action_, `getTitle.do`.

   * Add a text input field with the name `filmId`.
   * Add a submit button.

   * Change the title and add appropriate text/headers/form field labels.

### 6: Define a controller.

1. Select _src/main/java_ and go to New Package

   * **com.sd.film.controllers**

2. Select _com.sd.film.controllers_ and go to New Class

   * Name: **FilmController.java**

   * Add appropriate annotations.

   * Give it a field of type `FilmDao`

     ```java
     @Autowired
     private FilmDAO dao;
     ```

3. In _FilmController.java_, implement a method for the `getTitle.do` route.

   ```java
   @RequestMapping(path = "home.do")
   public ModelAndView home() {
     return new ModelAndView("WEB-INF/views/home.jsp");
   }

   @RequestMapping(path = "getTitle.do")
   public ModelAndView getFilmTitleById(@RequestParam(name = "filmId") Integer filmId) {
     String viewName = "WEB-INF/views/home.jsp";
     ModelAndView mv = new ModelAndView(viewName);
     String title = dao.getFilmTitleById(filmId);
     mv.addObject("filmTitle", title);
     return mv;
   }
   ```

### 7: Modify _home.jsp_ to show the results

1. In _WebContent/WEB-INF/views/home.jsp_

   * Below your form, add:

     ```html
     <c:choose>
       <c:when test="${filmTitle != null}">
         <h3>${filmTitle}</h3>
       </c:when>
     </c:choose>
     ```
    

### OK, LET'S TRY IT OUT!

* Run As | Run On Server

* Enter `33` for the film id and submit.

What happened?

Why?

Read the exceptions carefully.



### MySQL Driver Dependency

* In _build.gradle_'s dependencies, add:

  ```
  compile group: 'mysql', name: 'mysql-connector-java', version: '5.1.42'
  ```

* Gradle | Refresh Gradle Project

Try it again, and fix any problems until it works.

[Up](../README.md) | [Next](Lab.md)
