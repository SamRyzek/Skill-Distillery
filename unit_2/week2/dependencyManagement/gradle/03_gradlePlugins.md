## Gradle Plugins

* Gradle supports *plugins* to add behavior to support specific types of projects.

### The `java` plugin

* The `java` plugin helps with compilation, testing, and packaging of Java projects.

  ```java
  apply plugin 'java'
  ```

* The default project assumes the following project layout:

  ```
  ProjectRoot/
              src/
                  main/
                       java/
                       resources/
              src/
                  test/
                       java/
                       resources/
  ```

  * Layout can be controlled in `build.gradle` with `sourceSets`.

  ```java
  sourceSets {
    main {
      java.srcDirs 'src/main/java'
    }
    test {
      java.srcDirs 'src/test/java'
    }
  }
  ```

### The `war` plugin

* This plugin helps with packaging JEE web apps.

  ```java
  apply plugin 'war'
  ```

* The `war` plugin assumes the root of your web content is `src/main/webapp`.

  * Override this in `build.gradle` with 

    ```java
    project.webAppDirName = 'WebContent'
    ```

* By default, running the `war` gradle task generates a WAR name _ProjectName_-_version_.war, under _ProjectRoot/build/libs/_.

  * You can override the name in `build.gradle`:

    ```js
    war {
      archiveName = "${baseName}.war"
      destinationDir = file("./")      // Project root
    }
    ```

### The `eclipse-wtp` plugin

* This pluging works with Eclipse's _Web Tools Platform_, which includes things like Server Tools, Java EE Tools, etc.

* A project that uses `eclipse-wtp` requires that all its included projects also use `eclipse-wtp`.

* It also requires the user to set source directories so that Eclipse can see them.

  * This is useful for adding test directories and resources.

  ```
  apply plugin: 'eclipse-wtp'
  \\...
  sourceSets {
    main {
      java.srcDirs 'src/main/java'
      resources.srcDirs 'src/main/resources'
    }
    test {
      java {
  		  srcDir 'src/test/java'
  	  }
      resources {
        srcDir 'src/test/java'
        srcDir 'src/test/resources'
        srcDir 'WebContent/WEB-INF/spring'
      }
    }
  }
  ```

[Back](02_gradleConfig.md) | [Up](../README.md) | [Next](04_gradleProjects.md)
