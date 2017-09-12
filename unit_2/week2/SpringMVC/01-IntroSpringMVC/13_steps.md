# 13 Steps to create a SpringMVC application:
1: Create a new ***Dynamic Web Project*** in Eclipse:  

2: *Right click* on the project name in the *Project Explorer* and choose *Configure | Convert to Maven Project*. Click *Finish* on the Maven POM dialog.  

3: Modify the newly created *pom.xml* by adding the following just before the final `</project>` tag.  

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

4: Create a *web.xml* in your project's *WebContent/WEB-INF* directory.  

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
  version="3.1">
  <servlet>
    <servlet-name>NAME</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  </servlet>
  <servlet-mapping>
    <servlet-name>NAME</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
</web-app>
```

5: Create another XML file in the *WebContent/WEB-INF* folder. Name this file *NAME-servlet.xml* where *NAME* is the name you used for the `<servlet-name>` in your *web.xml*. Make sure to modify the *base-package* attribute on the *context:component-scan* element to match the package you will use in step 7. (If you have an existing file in another project it would be best to copy it.)  

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

  <context:component-scan base-package="PACKAGE-NAME"/>

</beans>
```

6: Build an HTML file with an embedded form to gather data from the user. The *action* you specify will have to match your request mapping in the controller class you will be creating soon. In Eclipse, right click on your *WebContent* folder and choose *New | HTML File*.  

```html
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Title</title>
  </head>
  <body>
    <form action="route.do" method="GET">
      <input type="text" name="data" /><br />
      <input type="submit" value="Submit" /><br />
    </form>
  </body>
</html>
```

7: Create a new package to contain your SpringMVC controller class(es). Make sure to match the package name with what you placed in the *NAME-servlet.xml* in step 5.  

8: Create a new Java class within the newly created package to serve as a controller.  

9: Add the `@Controller` annotation to your newly created class above the public class declaration. Use `⌘ + shift + o` to automatically import the dependency for the `@Controller` annotation. If Eclipse does not import the dependency, check you *pom.xml* to ensure that you are including the `spring-webmvc` dependency correctly.  

10: Add a method to your controller class with an `@RequestMapping` annotation set to the *action* you specified in your HTML file in step 6. The method should return a *ModelAndView* object and have parameters that match the request parameters from the HTML. Use the `@RequestParam` annotation to match request parameters with method parameters. The name of the method can be anything. Again, use `⌘ + shift + o` to import the necessary dependencies.  

11: Within the method, process the request appropriately, then build a new *ModelAndView* object to return. Call the `setViewName()` method on the object to specify the name fo the JSP file (the view) that will display the results. Call the `addObject()` method for each item you wish to place in the model that the view needs to access.  

```java
package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
  @RequestMapping("route.do")
  public ModelAndView processData(@RequestParam("data") String s) {
    String allCaps = s.toUpperCase();
    ModelAndView mv = new ModelAndView();
    mv.setViewName("view.jsp");
    mv.addObject("result", allCaps);
    return mv;
  }
}
```

12: Build a JSP as your view, using JSP EL to retrieve values from the Model to display. In Eclipse, you can right click on the *WebContent* folder and choose *New | JSP File*.  

```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>View</title>
  </head>
  <body>
    <p>The result is: ${result}.0</p>
  </body>
</html>
```

13: Run your program by right clicking on your project name and choosing *Run As | Run on Server*. The newly deployed application should be available on *http://localhost:8080/ProjectName* where *ProjectName* is the name of your project. If you do not specify an *index.html* file, then you should manually navigate to the location of your html file. *http://localhost:8080/ProjectName/Form.html*.

<hr>

[Prev](controller.md) | [Up](../README.md)
