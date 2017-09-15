## Validation using Spring's `Validator` Interface

Spring has a `Validator` interface that we can use to validate classes manually. There is also a `ValidationUtils` helper class with static methods to aid in validation.

We implement the `supports(Class)` method to indicate which classes this class can validate, and `validate(Object, org.springframework.validation.Errors)` to validate the object. We register errors with the given `Errors` object.

Using the `Errors` object, we can reject fields with the method `rejectValue(String field, String errorCode)`, where `field` corresponds to the object's properties (getters), and `errorCode` corresponds to an error code, interpretable as a message key (more on this later).

```java
// User.java
package data;

public class User {
	private int age;
	private int weight;
  	private String firstName;
	private String lastName;
	private String zipCode;
	private String email;
	// getters and setters...
}

// UserValidator.java
package data;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors e) {
		User user = (User) obj;

		// Check that the age is in bounds
		if (user.getAge() < 0) {
			e.rejectValue("age", "age.min");
		}
		else if (user.getAge() > 110) {
			e.rejectValue("age", "age.max");
		}

		// Make sure first and last name were entered
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "firstName", "firstName.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(e, "lastName", "lastName.empty");
		// ... more Validation
	}
}
```

We must create this `Validator` implementation in our Spring configuration file.

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
xmlns:context="http://www.springframework.org/schema/context" xmlns:tx="http://www.springframework.org/schema/tx"
xsi:schemaLocation="
  http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
  http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-4.3.xsd
  http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd
  http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.3.xsd">

  <!-- other beans, component scanning, annotation-config ... -->

  <bean id="userValidator" class="data.UserValidator"/>

</beans>
```

<hr>

[Prev](controller.md) | [Up](../README.md) | [Next](controller_validator.md)
