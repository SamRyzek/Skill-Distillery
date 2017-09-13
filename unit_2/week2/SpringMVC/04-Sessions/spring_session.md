## Storing an Object in a Session the SpringMVC Way

* SpringMVC advocates an alternative way to store data in the session.

* Identify the object as one that should be stored in the session by listing its name within the `@SessionAttributes` annotation on the class.

```java
package controllers;

@Controller
@SessionAttributes("state")
public class MyController {
  ...
```

* Using `@SessionAttributes` does two things:

  1. Declares that a model attribute should be saved to `HttpSession` _after_ handler methods are executed.

  2. Populates the model with a previously saved object from `HttpSession` _before_ handler methods are executed, if the object exists.

* Annotate a non-void method with `@ModelAttribute` to add the returned object to the session. This method is executed for each user only once, rather than before each request to the Controller.

```java
@Controller
@SessionAttributes("state")
public class MyController {
  @Autowired
  private StateDAO stateDAO;

  @ModelAttribute("state")
  public State initSessionState() {
    return stateDAO.getStateByName("Alabama");
  }
}
```

* It is possible to inject the session scoped object into your request method using the `@ModelAttribute` annotation.

```java
package controllers;

@Controller
@SessionAttributes("state")
public class MyController {
  @ModelAttribute("state")  //Makes sure the object is in session
  public State initSessionState() {
    return stateDAO.getStateByName("Alabama");
  }

  @RequestMapping("update.do")
  public ModelAndView updateState(@ModelAttribute("state") State s) {
    ModelAndView mv = new ModelAndView();
    stateDAO.updateState(s);
    mv.setViewName("stateDetail");
    return mv;
  }
}
```

> Note: if an object is listed in `@SessionAttributes`, it must be in the session (i.e. previously added to the model), before it can be used as a handler method's parameter.
> It can be useful to put an empty object in the session using `@ModelAttribute`.

```java
// add empty object as ModelAttribute
@ModelAttribute("state")
public State initSessionState() {
 return new State();
}
```

* Update the bean in session by setting it in the injected `Model` or the `ModelAndView`.

```java
package controllers;

@Controller
@SessionAttributes("state")
public class MyController {
  @RequestMapping("randomState.do")
  public ModelAndView getRandomState() {
    State nextState = stateDAO.getRandomState();
    ModelAndView mv = new ModelAndView();
    mv.getModelMap().addAttribute("state", nextState);  //updated in session as well
    mv.setViewName("stateDetail.jsp");
    return mv;
  }
}
```

* Access the session in JSP EL using the optional `sessionScope` implicit object:

  ```html
  <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html lang="en">
    <head>
      <meta charset="UTF-8">
      <title>State Detail</title>
    </head>
    <body>
      <h3>State:</h3>
      <p>${sessionScope.state}</p>
    </body>
  </html>
  ```

<hr>

### Example:
* The following example illustrates how you could track the history of lottery numbers with a session the SpringMVC way:

```java
package controllers;

@Controller
@SessionAttributes("lottoHistory")
public class LottoController {
  @Autowired
  private Hopper hopper;

  @ModelAttribute("lottoHistory")
  public List<Integer[]> initSessionObject() {
    List<Integer[]> list = new ArrayList<>();
    return list;
  }

  @RequestMapping("GetNumbers.do")
  public String lotto(@RequestParam("howmany") int count,
    @ModelAttribute("lottoHistory") List<Integer[]> list) {
    list.add(getLottoNumbers(count));
    return "lottoHistory.jsp";
  }

  private Integer[] getLottoNumbers(int howMany) {
    // ... code to generate lotto numbers
  }
}
```

```html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>Lotto History</title>
  </head>
  <body>
    <table>
      <c:forEach var="drawing" items="${sessionScope.lottoHistory}">
        <tr>
          <c:forEach var="number" items="${drawing}">
            <td><c:out value="${number}"/></td>
          </c:forEach>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
```

### Removing SessionAttributes
To remove the SessionAttributes you must pass a `SessionStatus` object (which is injected by Spring) to a controller method and call `setComplete()`. This is usually done when a path on a site (such as signing up a user or purchasing a shopping cart) is complete.

```java
@RequestMapping(path="cart/purchase.do", method = RequestMethod.POST)
public String createUser(@ModelAttribute("cart") ShoppingCart cart, SessionStatus sessionStatus) {
    //... check errors, purchase cart

    sessionStatus.setComplete();
    return "redirect:cart/done.jsp";
}
```

[Prev](store_object.md) | [Up](../README.md) | [Next](unittestsession.md)
