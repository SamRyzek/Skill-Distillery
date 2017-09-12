## Pathing with `@RequestMapping`

* Your controller class typically has one or more methods annotated with `@RequestMapping` whose purpose is to handle HTTP requests.

* At a minimum, identify the URL pattern that the method should map to by embedding a String within the parentheses of the annotation.

  ```java
  @RequestMapping("GetData.do")
  ```

  * If you wish to have the same method invoked for multiple URL patterns, set the ***path*** element to an array of strings.

  ```java
  @RequestMapping(path = {"GetData.do", "Data.do"})
  ```

* To identify which HTTP methods should be mapped to your Java method, add the ***method*** element.

  ```java
  @RequestMapping(path = "GetData.do", method = RequestMethod.GET)
  ```

  * This, too, can be an array:

    ```java
    @RequestMapping(path = "GetData.do",
      method = {RequestMethod.GET, RequestMethod.POST})
    ```

  * If you don't specify a *method* element, then your code will respond to all HTTP methods at the specified path.

* You can use the *params* element to narrow the choice of which method to invoke to those that include particular request parameters.

  ```java
  @RequestMapping(path="GetData.do", params="name")
  ```

  ```java
  @RequestMapping(path="GetData.do", params={"name","detailed"})
  ```

<hr>

### Example:

```java
package controllers;

@Controller
public class StateController {
  @Autowired
  private StateDAO stateDao;

  @RequestMapping(path = "GetStateData.do",
                  params = "name",
                  method = RequestMethod.GET)
  public ModelAndView getByName(@RequestParam("name") String n) {
    // implementation code
  }

  @RequestMapping(path="GetStateData.do",
			params={"name","detailed"},
			method=RequestMethod.GET)
	public ModelAndView getByNameDetailed(@RequestParam("name") String n) {
		// implementation code returning a different view
	}

  @RequestMapping(path = "GetStateData.do",
                  params = "abbr",
                  method = RequestMethod.GET)
  public ModelAndView getByAbbr(@RequestParam("abbr") String a) {
    // implementation code
  }

  @RequestMapping(path = "NewState.do",
                  method = RequestMethod.POST)
  public ModelAndView newState(State state) {
    // implementation code
  }
}
```

* **NOTE**: You can also use the `@RequestMapping` annotation at the class level. If you do, then all mappings at the method level are relative to the URL pattern defined on the class.

[Prev](controller.md) | [Up](../README.md) | [Next](params.md)
