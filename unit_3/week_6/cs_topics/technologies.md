### Technology Overview

One liners and brief explanations of the technologies you have encountered over the course of the program.

* 4 tenants of Object Oriented programming:
  * Abstraction
    * In Java, this is embodied by *`abstract`* and *`interface`*. The use of these makes it the responsibility of the developer to create an implementing class. This isolates the functionality of one implementation from another while keeping code loosely coupled enough to be expanded.

  * Encapsulation
    * Hiding values or state inside of a class (Java), thus preventing unauthorized components (unrelated classes, services etc) from altering the state except through a publicly accessible interface (getter/setter methods).

  * Inheritance
    * In Java/OOP is a means for having derived classes (classes which extend a parent) both share common functionality, as well as conform to a parent's archetype (common fields etc). This keeps code DRY as well as allows for specialization through shadowing and overriding while still allowing for the polymorphic use of objects.

  * Polymorphism
    * The presence of a common way of interacting with objects of different types. In Java, derived classes (be they an extension of a parent, or implementing an interface) share common functionality, allowing the classes (object type) to be used *as a* different type (the *reference type*)

* **D.R.Y**: Don't Repeat Yourself. A principle in coding to keep you from writing the same code in multiple locations.

* **DI**: Dependency Injection.
  * An aspect of *Inversion of Control* whereby an object or service supplies the dependencies required by another (client) object or service. An example of this would be how the SpringMVC Framework supplies the `HttpServletRequest` object to `@RequestHandler` annotated methods. When the method includes a typed parameter for `HttpServletRequest`, Spring *injects* the object to the method. The key distinction is that an existent object is provided to, not created by the method.

* **IOC**: Inversion of Control.
  * IoC dictates that instead of a service (method, implementing class, etc) calling to a library or service to perform a task, a framework or higher order piece of architecture performs this task automatically (perhaps requiring some configuration). An easy example of this behavior is the creation of a dispatcher servlet by the SpringMVC framework. When the application is run, the framework will scan the indicated packages (`controllers` in most of our apps) for classes annotated with `@Controller`, it then creates `beans` for each of these classes, using their `@RequestMapping` annotations to automatically configure an HttpServlet and route incoming requests to the correct handler method.

* **Java**: C based Object Oriented language. Was billed as "Write Once, Run Anywhere".

* **Gradle**: Build Tool. Build tools are technologies that automate the creating of an executable application. They compile source code, manage decencies,... A similar technology is Maven.

* **HTTP**: HyperText Transfer Protocol. Defines the Request/Response protocol for client-server communication.

* **Servlet**: A class that responds to network requests (HTTP).

* **JSP**: Java Server Pages. Allow for the creation of dynamic web pages. These documents allow for java code to be compiled down to HTML before being sent as part of the HTTP Response. This is an example of "Server Side Templating".

* **JSTL**: JavaServer Pages Standard Tag Library. Used in conjunction with JSP's it provides a library of tags for common programming tasks.

* **Spring**: A Java framework that leverages DI and IOC. Often billed as an "IoC container".

* **MVC**: Model View Controller. A pattern that divides an application into 3 parts to separate concerns over data received and passed to a user.  

* **REST**: Representational state transfer. Allows requests to access/manipulate representations of resources using a uniform set of operations.

* **XML**: Extensible Markup Language. A markup language designed to store and transport data. We primarily used XML to configure our web apps.

* **.war File**: Web Archive file.

* **.jar File**: Java Archive file.

* **JUnit**: Unit testing framework for Java.

* **SQL**: Structured Query Language. Language designed to manage data held in a relational database management system (RDBMS). We used MySQL as the specific implementation of a RDBMS.

* **JDBC**: Java Database Connectivity. An API for Java that how you can access a database. Allows for query/insert/update functionality.

* **JPA**: Java Persistence API. Manages the relationship between the database and Java entity classes. JPA is the guidelines that must be followed, like an interface.

* **JPQL**: Query language that mimics SQL syntax for executing queries against entities stored in a relational database.

* **Hibernate**: An object relational mapping tool. Provides the tools to map a Java class (entity) to a corresponding relational data model. Hibernate is an implementation of the JPA specification.

* **HTML**: Hypertext Markup Language. Uses elements to define the basic contents of a web page. Web browsers parse HTML documents and display them in a human readable format.

* **CSS**: Cascading Style Sheets. Language used to define the layout and presentation of an HTML document.

* **Javascript**: An event driven programming language primarily, but not exclusively, used in the browser.

* **DOM**: Document Object Model. JS object representation of an HTML document that has been loaded into the browser. All elements in the DOM can be accessed and manipulated with Javascript.

* **jQuery**: JS library that provides a number of convenience methods that can be used to manipulate the DOM. It also has an implementation of XMLHttpRequest with its `.ajax()` function.

* **Angular**: A JS framework developed by google.

* **JSON**: Javascript Object Notation. The stringified version of a JS object that can be transferred via HTTP.

* **AJAX (XMLHttpRequest)**: Asynchronous Javascript and XML. Client side technologies that allows web apps to send and receive data asynchronously. Allows the programmer to avoid full page loads.
