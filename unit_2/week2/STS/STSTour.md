## Quick Tour of Spring Tool Suite

### It's Still Eclipse

* You can still switch to the Java or the Java EE perspective.

* The Debugger, the Console and other views, and everything else you know are still there.

* You can install your favorite plugins and themes.

### The Spring Perspective

When you launch STS the first time it will open the Spring perspective. Let's take a quick look around:

* Servers is at the bottom left, along with Boot Dashboard (which we won't use).

* Console and Problems are still at the bottom middle.

* `File | New` still has _Java Project_ and _Dynamic Web Project_, but now includes some new wizards:

  * _Spring Starter Project_ creates a new Spring Boot project.

  * _Spring Legacy Project_ provides a number of templates for various types of Spring projects, including ...

### Hands On - Create and Test a New Spring/MVC project

Let's create a new Spring MVC project:

1. Select your JavaWeb working set.

2. File | New | Dynamic Web Project

   * Project Name: _HelloSTS_
   * Target Runtime: `<None>`
   * Add the project to the JavaWeb working set.
   * **Next**
   * **Next**
   * _This kind of project is associated with the Java EE perspective. Do you want to open it?_ **No**
   * **Finish**

3. Right-click | _Configure_ | _Convert to Maven Project_

   * Add the usual dependencies to `pom.xml`:
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
	</dependencies>
   ```

4. Under `src/`, create a `web` package and add:

   * Interface `HelloDAO` with a `String` method `getHello()`:
     ```java
     package web;
     public interface HelloDAO {
       String getHello();
     }
     ```

   * Class `HelloDAOImpl` implementing `HelloDAO`
     ```java
     package web;
     public class HelloDAOImpl implements HelloDAO {
       @Override
       public String getHello() {
     	  return "Hello";
       }
     }
     ```

   * Class `HelloController`
     ```java
     package web;
     import org.springframework.beans.factory.annotation.Autowired;
     import org.springframework.stereotype.Controller;
     import org.springframework.web.bind.annotation.RequestMapping;
     import org.springframework.web.servlet.ModelAndView;
     @Controller
     public class HelloController {
       @Autowired
       HelloDAO dao;
       @RequestMapping("hello.do")
       public ModelAndView hello() {
         ModelAndView mv = new ModelAndView("WEB-INF/hello.jsp");
         mv.addObject("data", dao.getHello());
         return mv;
       }
     }
     ```

5. Under `WebContent/WEB-INF`, create:

   * `hello.jsp`:
     ```html
     <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
     <!DOCTYPE html>
     <html lang="en">
       <head>
         <title>Hello</title>
       </head>
       <body>
         <p>STS says, "${data}"</p>
       </body>
     </html>
     ```

   * `web.xml`:
     ```xml
     <?xml version="1.0" encoding="UTF-8"?>
     <web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns="http://xmlns.jcp.org/xml/ns/javaee"
       xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
       version="3.1">
       <welcome-file-list>
         <welcome-file>hello.do</welcome-file>
       </welcome-file-list>

     </web-app>
     ```
     * Don't add or copy in anything else for now.

6. Now for the payoff: Right-click | _Spring Tools_ | _Add Spring Projecy Nature_

   * HelloSTS will now appear in the _Spring Explorer_ view

7. Let's go back to `WebContent/WEB-INF/`.

   * In `web.xml`, after the end of the welcome-file-list element, type `DS` and hit `Ctrl-Space`.

     * From the list select DispatcherServlet and let STS fill in the servlet definition.

     * Change the servlet-mapping from `url` to `*.do`.

     * In the `<init-param><param-value>` element, change `location` to `/WEB-INF/hello-servlet.xml`

   * Click on `WebContent/WEB-INF/` and go to _File_ | _New_ | _Spring Bean Configuration File_

     * Name it `hello-servlet.xml`

     * In the XML editor view, select the `Namespaces` tab and select `context` and `mvc` from the list.

       * Go back to `Source` - STS has added the correct namespaces to the `beans` element.

     * Inside the `<beans>` element, type `comp`, hit _Ctrl-Space_, and select `context:component-scan` from the list - STS will add the element.

       * Inside the quotes type `w` and hit _Ctrl-Space_ - STS will infer the package name.

     * Type `annot` and hit _Ctrl-Space_ and select `mvc:annotation-driven` from the list.

     * Type `bean` and hit _Ctrl-Space_ to add a `<bean>` element, type `c` in the opening tag and hit _Ctrl-Space_ to add the `class` attribute.

       * Inside the quotes of the `class` attribute, type `HDAO` and hit _Ctrl-Space_.

         * STS will infer your DAO implementation class name from the abbreviation!

8. Right-click | Run on Server

[Prev](README.md) | [Up](../README.md) | [Next](STSFeatures.md)
