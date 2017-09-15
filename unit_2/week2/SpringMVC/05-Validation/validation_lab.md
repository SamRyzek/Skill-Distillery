## Validation Lab

 Use the [provided project][lab] as a starting point. As you make progress, run the JUnit tests. You will have to implement some tests on your own (but the existing tests are good examples).

1. Add validation annotations to the properties of the `User` class which are not yet annotated:  

   * `firstName` : size annotation, minimum 3, maximum 35

   * `lastName` : size annotation, minimum 3, maximum 35

   * `age` : minimum 16


2. Create a form in `register.jsp` using the `@taglib` directive's 'form' tags. (don't forget to add the `@taglib` directive)  

3. In the `RegistrationController`, complete the todos on the request handlers. Run the unit tests. Repeat this process for the `LoginController`.

4. Fill in the `AuthenticationDAOImpl`'s `emailIsUnique` function. Run the unit tests.

5. Run the tests and the app, make sure it is working.  

6. Overwrite the default messages for the `User` class validation annotations in the `ValidationMessages.properties` file.

7. Add an additional custom message in `ValidationMessages.properties` for email uniqueness, (`unique.email`). Use this message in your controller when you are adding the error for email uniqueness validation.

8. (Optional) Change your application to use the `Validator` interface. Remember to add a `BindingResult` to your handler method, and remove `@Valid` from the command object.

<hr>

[Prev](unittestingvalidation.md) | [Up](../README.md)

[lab]:../code/ValidationLab
