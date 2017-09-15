## Unit Testing Validation

* Unit testing Validation can be tricky because we have to closely examine some of Spring's internal objects.

  * We can use different `Matchers` to test validation, or we can examine objects directly.

### Testing Error Codes with Matchers

* Test error codes using the `model()` matcher. `attributeHasFieldErrorCode` tests a model attribute's member for an error.

* In this example the `@Size` annotation is used to check a field's size.

  * `attributHasFieldErrorCode` is passed the model object's name "user", the field name "password", and a Matcher for the annotation "Size".

  ```java
  //In User.java
  @Size(min=6, message="Size.user.password")
  private String password;

  //In unit test
  import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
  //...
  try {
    MvcResult result = mockMvc.perform(
      post("/register.do")
      .param("firstName", "Roger")
      .param("lastName", "Dodger")
      .param("password", "pwd")
      .param("age", "25")
      .param("email", "email@localhost.com")
      )
      .andExpect(status().isOk())
      //make sure there are errors
      .andExpect(model().errorCount(1))
      .andExpect(model().attributeHasFieldErrorCode("user", "password", is("Size")))
      .andReturn();
  }
      //...
  ```

* For a value rejected in code, the third parameter changes to `rejectValue`'s second argument.

  ```java
  //In Controller
  errors.rejectValue("email", "email.unique");
  ```

  ```java
  //In unit test
  .andExpect(model().attributeHasFieldErrorCode("user", "email", is("email.unique")))
  ```

* In fact, we could test all model attributes in using the `model()` Matcher.

  ```java
  .andExpect(model().attribute("user", hasProperty("email", is("test@localhost.com"))))
  ```

### Querying the Object Directly

* Another way to test for error codes is querying the ModelAndView directly.

  * The `key` to find the object is `org.springframework.validation.BindingResult`+`.`+`attributeName`.

  ```java
  ModelAndView modelAndView = result.getModelAndView();

  //Check errors another way
  BindingResult r = (BindingResult) modelAndView.getModelMap().get("org.springframework.validation.BindingResult.user");

  ObjectError e = r.getAllErrors().get(0);

  assertEquals(e.getObjectName(), "user");
  assertEquals(e.getCode(), "admin@admin.com");
  ```

  * This is not a recommended way to check error messages because the test is now tied to Spring's implementation of the `ModelMap`, specifically, the `BindingResult` key.

<hr>

[Prev](properties.md) | [Up](../README.md) | [Next](validation_lab.md)
