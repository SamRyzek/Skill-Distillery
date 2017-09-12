## Receiving Data with `@RequestParam`

* Have Spring load data directly into your request handling method's parameters with the `@RequestParam` annotation.
  
  * Specify the name of the HTTP request param that you used in your HTML form within the parentheses of the annotation.
  
    ```html
    <form action="GetData.do" method="GET">
      <input type="text" name="age" />
    </form>
    ```
  
    maps to:  
  
    ```java
    @RequestMapping(path = "GetData.do")
    public String getData(@RequestParam("age") int a){ 
      // ... implementation code
    }
    ```
  
* Spring will automatically map the request parameter to your method parameter without need for the annotation if you use the same name for both.
  
  ```java
  @RequestMapping(path = "GetData.do")
  public String getData(int age){ 
    // ... implementation code
  }
  ```
  
* Use the `defaultValue` element to have Spring load the given value in the parameter if it is not present:
  
  ```java
  @RequestMapping(path = "GetData.do")
  public String getData(@RequestParam(name = "age", 
    defaultValue = "5") int a){ 
    // ... implementation code
  }
  ```
  
* Add the `required=false` element to the annotation to indicate that the parameter is optional and will be loaded with a `null` value if not provided:
  
  ```java
  @RequestMapping(path = "GetData.do")
  public String getData(@RequestParam(name = "age", 
    required = false) Integer a){ 
    // ... implementation code
  }
  ```
  
* Spring will automatically convert the data from the request to the datatype identified by the parameter.

<hr>

### Example:
* While Spring allows you to provide both the `required=true` and `defaultValue` elements, it will not honor the required instruction if the default value is present.
  
* Avoid using primitives when you specify `required=false` since there is no way to store a `null` value to a primitive. Use their wrapper equivalents to avoid a `500 : Internal Server Error` in your browser:
  
```html
<!-- States/WebContent/nameForm.html -->
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <title>States</title>
  </head>
  <body>
    <h3>States</h3>
    <form action="GetStateData.do" method="GET">
      <label for="name">Name:</label>
      <input type="text" name="name"><br />
      <input type="submit" value="Get State Data">
    </form>
  </body>
</html>
```
  
```java
// States/src/controllers/StateController.java
package controllers;

@controllers
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
  
[Prev](mapping.md) | [Up](../README.md) | [Next](return_type.md)
