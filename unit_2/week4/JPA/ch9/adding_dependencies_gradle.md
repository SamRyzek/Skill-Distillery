# Adding Dependencies

* Because Gradle is including the JPA project's dependencies in our MVC project, we only need to include one additional dependency in our Dynamic Web Project in order to complete our integration with Spring (and ultimately make our lives easier):

  * The Spring ORM implementation to integrate JPA with Spring.

* Either download the necessary JARs and manually add them to the build path, or use a dependency management tool, like Maven, to do the work for you.

### Hands On:
* Add the `spring-orm` dependency to your *MVCVideoStore/build.gradle* file:

```groovy
compile group: 'org.springframework', name: 'spring-orm', version:"$springVersion"
```

[Previous](jpa_with_web.md) | [Next](servlet_xml.md)
