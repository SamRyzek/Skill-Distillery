# Comprehensive Guide to Configuring Full Stack REST Project

### Part 0 - Make a new workspace / create .gitignore file

* See (final_project_day1.md)[../final_project_day1.md]

### Part 1 - Database
1. Create your database schema. Do this either in MySQL Workbench or a .sql file.

  * Create a User for the database and grant them limited permissions (`SELECT, INSERT, UPDATE, DELETE`) - See resources below for syntax

  * Add database DROP/CREATE/USE lines in your file. (see db.sql for example).

2. Load your database onto your mysql server (this is the same for how to load your database onto the server on AWS):

```bash
> mysql -u username -p < yourDb.sql
```

### Part 2 - JPA

1. In STS create a _File > New > Java Project_

2. In the `src` directory, create a new _Folder_ named `META-INF`.

3. Inside of `META-INF` create a new _File_ named `persistence.xml`. (see persistence.xml file for example)

  * Change the name of the _persistence-unit_ on line 5 to something semantic for your application.

  * Change the database name/location on line 12

  * Change the username on line 13

  * Change the password on line 14

4. Add gradle to the JPA project:

  * _Right Click_ on the project and _Configure > Add Gradle Nature_

  * Open the _Gradle Task_ view from _Window > Show View > Other > Gradle Task_

  * Under _Build Setup_, double click on the _init_ task (this creates several gradle related files in the project)

  * _Right Click > Refresh_ the project

5. Add build configuration to the `build.gradle` file (see buildJPA.gradle for example):

  * Add build config and dependencies within `build.gradle`

  * On the project _Right Click > Gradle > Refresh Gradle Project_

6. Create Entities:

  * Create classes which represent the data in your database, annotate them with JPA annotations

7. Tests:

  * On the project _Right Click > New > Source Folder_ name it test.

  * Create all of your tests in this folder.

### Part 3 - MVC & REST

1. In STS _File > New > Dynamic Web Project_

  * Give the project a name, click next twice and check the _Generate web.xml Deployment Descriptor_ checkbox, then click _Finish_

2. Add gradle to the JPA project:

  * _Right Click_ on the project and _Configure > Add Gradle Nature_

  * Open the _Gradle Task_ view from _Window > Show View > Other > Gradle Task_

  * Under _Build Setup_, double click on the _init_ task (this creates several gradle related files in the project)

  * _Right Click > Refresh_ the project

3. Add build configuration to the `build.gradle` file (see buildWeb.gradle for example):

  * Add build config and dependencies within `build.gradle`

  * On the project _Right Click > Gradle > Refresh Gradle Project_

4. Include JPA Project as a Dependency:

  * In the MVC project's `settings.gradle` file, add the following line below your rootProject:

```groovy
includeFlat 'JPAProjectName'
```

* ***NOTE*** : Where the `JPAProjectName` is the name of your JPA Project

  * On the project _Right Click > Gradle > Refresh Gradle Project_

  * In the MVC project's `build.gradle` file, within the `dependencies` task, compile the JPA project as a resource:

```groovy
compile project(':JPAProjectName')
```

* ***NOTE*** : Where the `JPAProjectName` is the name of your JPA Project, that colon is there intentionally.

  * On the project _Right Click > Gradle > Refresh Gradle Project_. Your JPA project should now be included in the clas path for your MVC project

5. Modify the web.xml:

  * Specify that a file named `index.html` will be your welcome file:

```xml
<welcome-file-list>
  <welcome-file>index.html</welcome-file>
</welcome-file-list>
```

  * Specify a dispatcher servlet for spring:
    * Where 'YourServletName' is the name of your `-servlet.xml` file.

```xml
<servlet>
    <servlet-name>YourServletName</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet
    </servlet-class>
</servlet>
```

  * Specify a servlet mapping (url-pattern):
    * Where 'YourServletName' is the name of your `-servlet.xml` file.

```xml
<servlet-mapping>
    <servlet-name>YourServletName</servlet-name>
    <url-pattern>/rest/*</url-pattern>
</servlet-mapping>
```

  6: Create a `-servlet.xml` file with the same name (preceding `-servlet.xml`) you specified in your web.xml file's `sevlet-name`. (Reference `Todo-servlet.xml` as an example)

    * In your project's _WEB-INF_ directory, _New > Spring Bean Configuration File_

    * In the _Namespaces_ tab, check off:

      * `context`
      * `mvc`
      * `bean`
      * `tx`

      * ***NOTE***: If any of these are not available, you are either missing a dependency, or need to run a _Gradle Refresh_

    * Configure your application context to scan for beans in designated packages:

```xml
<context:component-scan base-package="controllers, data" />
```

* ***NOTE***: Your packages may be named differently (e.g. not `controllers` and `data`), you can and should change them, possibly including more here.

    * Configure an _EntityManagerFactory_ bean:

```xml
<bean id="myEntityManagerFactory"
  class="org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean">
  <property name="persistenceUnitName" value="TodoPU" />
</bean>
```

* ***NOTE***: You will need to change the property's `value` attribute to the Persistence Unit name you specified in your `peristence.xml`.

    * Configure a _TransactionManager_ bean:

```xml
<bean id="myTransactionManager" class="org.springframework.orm.jpa.JpaTransactionManager">
  <property name="entityManagerFactory" ref="myEntityManagerFactory" />
</bean>
```

* ***NOTE***: The property's `ref` attribute must reference the `id` of your _EntityManagerFactory_ bean.

    * Set your application as annotation driven:

```xml
<mvc:annotation-driven />
<tx:annotation-driven transaction-manager="myTransactionManager" />
```

* ***NOTE***: The `transaction-manager` attribute must reference the `id` attribute of your _TransactionManager_ bean.

7: Make a `controllers` package in the `src` directory:

* ***NOTE*** If you specified a `base-package` other than 'controllers' in your `-servlet.xml` you will need to name this package the same as it is named there.

    * Create a new Java Class: _New > Class_

    * Annotate the class with `@RestController`
      * ***EXPLANATION*** : This annotation will ensure that the class is used to create a bean on application load (you indicated that it should be when you added it's package to the component-scan), and that it's `@RequestMapping` annotated methods will be used as request handlers in the DispatcherServlet created by Spring.

    * Add the following method for testing purposes:

```java
@RequestMapping(path = "ping", method = RequestMethod.GET)
public String ping() {
  return "pong";
}
```

* Run your application on a server, and either in Postman or a browser navigate to your 'ping' route, you should see `pong` as a response.

  * ***NOTE***: Your route to 'ping' will be your application root (probably something like `http://localhost:8080/ApplicationName`), followed by your `url-mapping` from the web.xml (like `/rest/`), followed by `ping`. All together, `http://localhost:8080/ApplicationName/rest/ping`, where 'ApplicationName' is the name of your application.

    * If your 'ping' works then you are ready to create the rest of your routes. Feel free to make multiple controller classes.

8: Create DAOs to access your data...

9: Create routes to access your your data (these will use the DAO methods to interact with the Database). Try to keep your controller methods 'skinny' by extracting the logic into DAO methods or helper methods.

### Part 4 : Front End (Angular)
1: In `WebContent` create an `app` directory with your Angular application code.

2: Create a `Module` to bootstrap your application with:

```js
// app.module.js
angular.module('appModule', []);
```
3: Include dependencies in and bootstrap `index.html` with your module:

```html
<!DOCTYPE html>
<html ng-app="appModule">
  <head>
    <title>My App</title>
    <!-- Angular CDN Dependency -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.7/angular.min.js"></script>

    <!-- App Module -->
    <sript src="app/appModule/app.module.js"></script>
  </head>
  <body>
    <!-- TODO: Include components -->
  </body>
</html>
```

4: Create components / services / filters etc to complete front end functionality. e.g.:

![owl](http://i0.kym-cdn.com/photos/images/original/000/572/078/d6d.jpg)

### Part 5 : Deployment

1: Create a dump file for your database (in your local terminal):

```bash
mysqldump -u username -p myDatabaseName > ~/Desktop/dump.sql
```

2: Secure copy your dump file to your AWS instance (in your local terminal):

```bash
scp -i ~/.ssh/aws.pem ~/Desktop/dump.sql ec2-user@123.45.6.78:~
```
* ***NOTE***: 123.45.6.78 is a placeholder for your IP address

3: In STS, export a WAR file of your project:
  * _File > Export > Web > WAR File > Next_ Select the project and the Destination (use desktop).

4: Secure copy your `.war` file to your AWS instance (in your local terminal):

```bash
scp -i ~/.ssh/aws.pem ~/Desktop/dump.sql ec2-user@123.45.6.78:/var/lib/tomcat8/webapps
```

5: Secure Shell into your server and import your dump.sql into your sql server:

* connect to your AWS server from your terminal:

```bash
ssh -i ~/.ssh/aws.pem ec2-user@123.45.6.78
```

* load your dump.sql into your server:

```bash
mysql -u username -p < ~/dump.sql
```

### Resources
* "I need to create an SQL User":
  * https://www.digitalocean.com/community/tutorials/how-to-create-a-new-user-and-grant-permissions-in-mysql

* "My MAMP server won't start":
  * https://github.com/SkillDistillery/SD-Files/wiki/MAMP---MySQL-server-won%27t-start

* "How do I configure my Entity?":
  * http://www.objectdb.com/java/jpa/entity

* "How do I do x y or z in Angular":
  * https://docs.angularjs.org/api

* "How do I use x y or z API/3rd Party Dependency":
  * Read it's documentation, and experiment until you figure it out e.g. [RTFM](https://en.wikipedia.org/wiki/RTFM)

* "I'm getting a 400/500 error code, what is wrong with my request"
  * Go back to STS, look at your console and read the error/stack trace, e.g. [RTFM](https://en.wikipedia.org/wiki/RTFM)

* "My JavaScript isn't working":
  * Step 1. Are you using the Chrome browser?
    * "YES" - Open the console, if there is an error, resolve it, if not, you either aren't calling a function, or something isn't being loaded properly
    * "NO" - Open it in the chrome browser, return to step 1.

* "When I navigate to my server it's telling me the server is unavailable"
  * Log into your AWS Console, go to _EC2 > Running Instances > Select the instance > Reboot_

* "Tomcat is giving me trouble in deployment"
  * try restarting it:

```bash
ssh -i ~/.ssh/aws.pem ec2-user@123.45.6.78

sudo service tomcat8 restart
```
