## `@Controller` Annotation for Classes

* Annotate a POJO that encapsulates your controller logic with `@Controller`.

* Add methods that Spring's *DispatcherServlet* will call when requests are made.

  * Annotate each method with `@RequestMapping` specifying the URL pattern that the method is mapped to as the annotation's value.

  * Your method should return either a `String` or `ModelAndView` object.

    * Use a `String` to return the name of the JSP (`.jsp` file) to forward to for presentation.

    * Use the `ModelAndView` object to encapsulate both the JSP view as well as additional model data that the JSP can present.

  * Optionally, add parameters that match the incoming request data from the HTML form that populates the request.

    * Precede each parameter with the `@RequestParam` annotation which identifies the name of the request parameter to map to.

    * Spring will handle data type conversions for primitive types.

* The `@Controller` class is automatically configured as a Spring bean based on its package being listed in the `<context:component-scan>` element in the *DispatcherServlet*.

  * As a Spring bean it can take advantage of additional Spring features like auto wiring.

    * Any field that is annotated with `@Autowired` is injected with a Spring bean instance of the appropriate type as part of the instantiation process.

```java
// SpringLotto/src/web/LottoController
package web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lotto.Hopper;

@Controller
public class LottoController {
  @Autowired
  private Hopper hopper;

  @RequestMapping("lotto.do")
  public String welcome() {
    return "form.jsp";
  }

  @RequestMapping("GetNumbers.do")
  public ModelAndView getNumbers(@RequestParam("howmany") int count) {
    hopper.reset();

    List<String> nums = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      nums.add(hopper.drawBall().getValue());
    }

    ModelAndView mv = new ModelAndView();
    mv.setViewName("form.jsp");
    mv.addObject("listOfNumbers", nums);
    return mv;
  }
}
```

* The corresponding `.jsp` file could like like this:

```html
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lottery</title>
</head>
<body>
  <h3>Lottery Numbers</h3>
  <form action="GetNumbers.do" method="GET">
    <input type="text" name="howmany" value="6" size="2"/>
    <input type="submit" value="Get Numbers" />
  </form>
  <c:forEach var="number" items="${listOfNumbers}">
    ${number}
  </c:forEach>  
  <br/>
</body>
</html>
```

<hr>

### Hands On:
1. Create a controller like the one above which utilizes the `@Autowired` hopper you injected in the *DispatcherServlet* to return a `ModelAndView` object containing some lottery numbers to a `form.jsp`

* When you navigate to `http://localhost:8080/SpringLottoWeb/`, you should be presented with a form requesting the number of 'numbers' you would like to draw. Once the form is submitted, the returned numbers should appear after the form. Notice that the `GET` request from the form altered the URL (`http://localhost:8080/SpringLottoWeb/GetNumbers.do?howmany=6`).

[Prev](servletxml.md) | [Up](../README.md) | [Next](13_steps.md)
