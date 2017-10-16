## Labs

When creating a new Spring REST project it is good practice to test that everything is configured properly. We will do this with standard Ping/Pong test
you will right with every new project.

1: Create a new dynamic web project called MyFirstRestProject

2: Convert the project to a gradle project and configure the build.gradle file.  
  * include all the appropriate dependencies, they will be the same as your MVC build dependencies.

  ```gradle
    dependencies {
        compile group: 'org.springframework', name: 'spring-webmvc', version:"$springVersion"
        compile group: 'javax.servlet', name: 'javax.servlet-api', version:'3.1.0'
        compile group: 'javax.servlet', name: 'jstl', version:'1.2'
    }
  ```

3: Configure your `web.xml` and `-servlet.xml` files.  
  * Remember to change the URL pattern to `/api/*` in the web.xml.
  * Add in the mvc and context namespaces
    * include `	<mvc:annotation-driven />` and `<context:component-scan base-package="controllers" />`

4: Create a controllers package.
  * Inside, create a file names TestController and add the `@RestContoller` annotation on top of the class declaration.

5: Write a method named ping() identical to the one below:
```java
@RequestMapping(path = "ping", method = RequestMethod.GET)
public String ping() {
  return "pong";
}
```

6: Launch your program and hit `http://localhost:8080/MyFirstRestProject/api/ping` in your browser or the Postman tool. You should receive a string response of 'pong'.

[Previous](configure_rest_controller.md) | [Next](route_naming.md)
