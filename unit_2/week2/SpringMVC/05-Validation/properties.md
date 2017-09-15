## Using a Properties File to Store Errors

### Setup

* In order to reference error messages from a file we must first create the file.

  * Create a file named `ValidationMessages.properties` file in the `WebContent/WEB-INF` directory.

* Spring will not automatically detect this file.

  * In order to make Spring aware of the files location and purpose we will configure a `ReloadableResourceBundleMessageSource` bean to point to it in the *DispatcherServlet*:

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

    <context:component-scan base-package="controllers,data" />
    <mvc:annotation-driven />

    <bean id="messageSource" class="org.springframework.context.support.ReloadableResourceBundleMessageSource">
        <property name="basename" value="/WEB-INF/ValidationMessages" />
    </bean>
  </beans>
  ```

* Note that the value assigned to the *"basename"* property is the location and name of the `ValidationMessages.properties` file.

### Overriding Default Validation Messages

* For improved maintainability and internationalization, it is possible to load error messaging from a file instead of hard coding the messages in annotations or controllers.

  * `ValidationMessages.properties`

    ```txt
    Email.user.email=Please enter a valid email
    Size.user.password=Password must be greater than 6 characters in length
    ```

  * The messages above are used to overwrite the default messages associated with the validation annotations.

* Reference validations with the following format:

`[Validation name].[lowercase class name].[property name]=Message`

  ```java
  public class User {
    @Email(message="Email.user.email")
    private String email;
    @Size(min=6, message="Size.user.password")
    private String password;

    // ...
  }
  ```

* Now the `User` classes validation messages will correspond to those provided in the `ValidationMessages.properties` file.

### Creating/Using Custom Messages

* Similar to how you can use the `ValidationMessages.properties` file to overwrite default messages, you can also use it to create custom messages.

* `ValidationMessages.properties`

  ```txt
  Email.user.email=Please enter a valid email
  Size.user.password=Password must be greater than 6 characters in length

  login.email=Email not found...are you registered?
  login.password=Email and password combination do not match...
  ```

* Once you have created the custom message, you can reference it with `Errors.rejectValue("propertyName", "customeMessageName")`

  ```java
  @RequestMapping(path = "login.do", method = RequestMethod.POST)
	public ModelAndView doLoginCustom(@Valid User user, Errors errors) {
		ModelAndView mv = new ModelAndView();
		User loggedInUser = authDao.validEmail(user.getEmail());
		if (loggedInUser == null) {
			errors.rejectValue("email", "login.email");
		}
		if (!authDao.validPassword(user)) {
			errors.rejectValue("password", "login.password");
		}
		if (errors.getErrorCount() != 0) {
			mv.setViewName("login.jsp");
			return mv;
		}
		mv.addObject("user", loggedInUser);
		mv.setViewName("profile.jsp");
		return mv;
	}
  ```

  * In the above example `"login.email"` and `"login.password"` will correspond to the error messages provided in the `ValidationMessages.properties` file, adding those error messages to the errors object if they fail validation.

<hr>

[Prev](custom_messages.md) | [Up](../README.md) | [Next](unittestingvalidation.md)
