## Validation Annotations

* You can take advantage of Java EE annotations to simplify the validation logic in your web applications.

  * Add the annotations above the fields in your Java class to indicate your validation preferences.

* Available validation annotations include:

  ```java
  // Minimum value
  @Min(0)
  private int age;

  // Maximum value
  @Max(500)
  private int weight;

  // Minimum and/or maximum length
  @Size(min=2, max=100)
  private String firstName;

  // Not null
  @NotNull
  private String lastName;

  // Regular Expression pattern matching
  @Pattern(regexp="\\d{5}(-\\d{4})?")
  private String zipCode;

  // Email pattern matching
  @Email
  private String email;
  ```

* Multiple annotations can be combined on the same field:

  ```java
  @Min(0)
  @Max(120)
  private int age;
  ```

<hr>

[Prev](setup.md) | [Up](../README.md) | [Next](controller.md)
