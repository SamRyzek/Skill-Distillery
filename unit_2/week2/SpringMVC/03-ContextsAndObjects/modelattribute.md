## `@ModelAttribute`

* Spring provides an MVC annotation that allows us to automatically add objects to a Model. We use this annotation in Controllers.

* We could also say this annotation _binds_ a POJO method parameter or method return value to the model so it can be used by the web view.

### Using `@ModelAttribute` in a Controller

* Initialize the object you want in the model by returning it from a method annotated with `@ModelAttribute`.

  ```java
  public class MyController {
    @Autowired
    StateDAO stateDao;

    @ModelAttribute("currentDT")
    public LocalDateTime initCurrentTime() {
      return LocalDateTime.now();
    }

    @ModelAttribute("state")
    public void initState(Model model) {
      model.addAttribute("state", stateDao.getStateByName("Alabama"));
    }
  }

  ```

* This method is executed before any `@RequestMapping` methods. The idea is that the model object has to be created before any controller methods are processed.

* For session scoped data, this method is called once when the user first accesses this controller. (Session scoped data will be discussed in later chapters.)

  * **NOTE**: If the data will not be session scoped, this method will be called _before_ **every** request, and will initialize the object to a default value.

    * This could be degrade performance (say if it is a database lookup).

    * If it can be `null`, you do not have to initialize it, however, you will want to `null` check it before attempting to use it.

* The name you specify in the `@ModelAttribute` annotation is what you will use for further lookups on this object.

* The name is the key, the returned object is the value.

### `@ModelAttribute` and Method Parameters

Adding this annotation to a method parameter causes the object from the model to be injected to the method as a command object. The fields in the object are then set by request parameters that have matching names.

```java
@RequestMapping(value = "/addState", method = RequestMethod.POST)
public String submit(@ModelAttribute("state") State state) {
  // code that uses a State object

  return "stateData.jsp";
}
```

<hr>

[Prev](singleton.md) | [Up](../README.md) | [Next](states_lab_2.md)
