## Controller Method Return Types

* Return a `String` from your request handler method (controller method) that identifies the name of the JSP or HTML file to display after the method completes. Spring will attempt to locate the corresponding file, and will display it (if it exists).

### `Model`
* Returning a `String` tells Spring what HTML/JSP file to return, but what if you need to return data to display dynamically with JSTL?

* We can use Spring's built in *Dependency Injection* to retrieve the `Model` object associated with the request.  

* Confused? Let's dig into what is happening during the request / response cycle.

  * When a user clicks a link or form with an action which routes to our application it is routed to a *request handler* (one of the methods in our *Controller* annotated with `@RequestMapping`:

    ```html
    <a href="GetInfo.do">Get More Information</a>
    ```

  * The *Servlet* will search through the Java Classes we have annotated with `@Controller` (which Spring has converted to beans in the background), and attempt to match the request's action (the `href` value above) and method (`href`'s are always GET requests) with one of our *request handlers*:

    ```java
    @Controller
    public class InfoController {
      @RequestMapping(path = "GetInfo.do", method = RequestMethod.GET)
      public String getInfo() {
        // ...
        return "info.jsp";
      }
    }
    ```

  * If a match is found, Spring will invoke the *request handler* method. The return value from the method will then be included in a response back to the origin of the request (client...in this case the browser).

  * When it invokes the *request handler* method, Spring can do something really cool called *Dependency Injection*. At it's core, *Dependency Injection* is the process through which resources are made available when and where they are needed. In our current example, Spring knows that our *request handler* is dealing with an HTTP Request (we annotated it with `@RequestMapping`), thus it is prepared to provide (inject) us with resources (dependencies) should we require them.

  * It is through this process that we can gain access to the `Model` object associated with a request just by asking for it. We can request the `Model` object by typing a variable in our parameters `Model`, Spring will detect that the type of this parameter exists, and provide us an instance of `Model` as an argument:

    ```java
    @Controller
    public class InfoController {
      @RequestMapping(path = "GetInfo.do", method = RequestMethod.GET)
      public String getInfo(Model model) {
        /*
          Spring will add an instance of Model as an argument when it in
          invokes the request handler
        */
        return "info.jsp";
      }
    }
    ```

  * The `Model` (which is technically an interface, we are dealing with a specific implementation of it, but that is irrelevant), is a representation of data we will communicate with the our *Response* (the returned value(s)). It contains several *model attributes* which are key-value pairs in the form of `Map<String, Object>`.

  * To assign values to the `Model` object (which will subsequently be available in our view), use the `Model.addAttribute(String, Object);` method, which will attach a key-value pair to the `Model` object.

    ```java
    @Controller
    public class InfoController {
      @RequestMapping(path = "GetInfo.do", method = RequestMethod.GET)
      public String getInfo(Model model) {

        model.addAttribute("year", 2017);
        model.addAttribute("description", "The world has been conquered by robots...");

        return "info.jsp";
      }
    }
    ```

  * When the response is sent to the client (the *request handler* method returns), the `Model` will be dispatched along with it.

  * This data will now be available in your JSP in the corresponding namespace:

    ```html
    <!-- ... -->
      <body>
        <h1>The year is ${year}</h1>
        <div>${description}</div>

        <!-- ... -->
      </body>
    </html>
    ```


### `ModelAndView`
* Or, return a `ModelAndView` object to both identify the view to display and load data into the model for presentation.

  * Create the `ModelAndView` object using the no-arg constructor and call the `setViewName()` method on the newly created object passing the filename that represents the view.

  * Call the `addObject(key,value)` method repeatedly for each data item you wish to make available to the view.

    ```java
    ModelAndView mv = new ModelAndView();
    mv.setViewName("result.jsp");
    mv.addObject("name", "Joe");
    mv.addObject("age", 12);
    return mv;
    ```

<hr>

### Example:
* The following example illustrates how the `ModelAndView` object can be used to designate a specific view (result.jsp), and forward some model data to it (the `State` object returned from `stateDao.getStateByName(n)`):

```java
// StateController.java
package controllers;

@Controller
public class StateController {
  @Autowired
  private StateDAO stateDao;

  @RequestMapping(path="GetStateData.do",
                  params="name",
                  method=RequestMethod.GET)
  public ModelAndView getByName(@RequestParam("name") String n) {
    ModelAndView mv = new ModelAndView();
    mv.setViewName("result.jsp");
    mv.addObject("state", stateDao.getStateByName(n));
    return mv;
  }
}
```

```html
<!-- result.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Results</title>
  </head>
  <body>
    <c:choose>
      <c:when test="${! empty state}  ">
        <ul>
          <li>${state.abbreviation}</li>
          <li>${state.name}</li>
          <li>${state.capital}</li>
        </ul>
      </c:when>
      <c:otherwise>
        <p>No State Found</p>
      </c:otherwise>
    </c:choose>
  </body>
</html>
```

[Prev](params.md) | [Up](../README.md) | [Next](views.md)
