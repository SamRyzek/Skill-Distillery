## Command Objects

* If you have multiple request parameters you may be able to use a *command object* to simplify your controller.

  * A *command object* is a JavaBean (POJO) which you list as a parameter to your controller method whose properties match the names of the request parameters.

  * A property name is derived from a setter method by removing the word "set" and lowercasing the first letter of the remaining string.

    * For example, the method `setLastName()` would result in a property *lastName*:

      ```java
      // Person.java
      public class Person {
        private String lastName;

        public void setLastName(String ln) {
          this.lastName = ln;
        }
      }
      ```

    * The name of the field does **NOT** matter. Only the name of the setter method is important.

  * Your *command object* will be automatically loaded with data by Spring MVC when the request is submitted.

* The *command object* will be automatically loaded with data by Spring MVC when the request is submitted.

  * You don't need to add it to the `ModelAndView` object like you would other objects that you wish to pass to your view. It will be available through the ***requestScope***.

<hr>

### Example:
```html
<!-- WebContent/newState.html -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>New State</title>
  </head>
  <body>
    <form action="NewState.do" method="POST">
      <label for="abbreviation">Abbrev:</label>
      <input type="text" name="abbreviation" value="PR">
      <br>
      <label for="name">Name:</label>
      <input type="text" name="name" value="Puerto Rico">
      <br>
      <label for="capital">Capital:</label>
      <input type="text" name="capital" value="San Juan">
      <br>
      <input type="submit" value="Add State">
    </form>
  </body>
</html>
```

```java
// src/data/State.java
package data;

public class State {
  private String abbr;
  private String name;
  private String cap;

  public void setAbbreviation(String a) {
    this.abbr = a;
  }

  public void setName(String n) {
    this.name = n;
  }

  public void setCapital(String c) {
    this.cap = c;
  }
}
```

```java
// src/controllers/StateController.java
package controllers;

@Controller
public class StateController {
  @Autowired
  private StateDAO stateDao;

  @RequestMapping(path="NewState.do",
                  method=RequestMethod.POST)
  public ModelAndView newState(State state) {
    stateDao.addState(state);
    ModelAndView mv = new ModelAndView();
    mv.setViewName("result.jsp");
    return mv;
  }
}
```

[Prev](views.md) | [Up](../README.md) | [Next](post_redirect_get.md)
