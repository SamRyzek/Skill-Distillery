# Incorporating JPA into your Dynamic Web Project

* With our JPA project more or less complete, it is time to create a web interface for our end users to interact with.

* We will do this by creating a separate *Dynamic Web Project*, and using *Gradle* to pull the JPA project into it.

* This process will leave our JPA project unchanged, which is ideal as we may wish to create other interfaces later (maybe a desktop application, or a RESTapi etc...) that will rely on the same data layer.

* Gradle will aid us by automating the inclusion of the JPA project from the Dynamic Web Project. Gradle will ensure that each time our Web Project is built/deployed, it loads in the dependent JPA project.

### Hands On:
* ***NOTE***: This setup process is a good template for how to setup your group project.

* ***NOTE***: Eclipse and STS make multiple project builds a little bit difficult to manage with a single Github repository. As a result, we recommend that you create a new *workspace* as an umbrella for both projects. You will then initialize that *workspace* as a *Git* repository.

1: Open your *VideoStore* workspace.
* Execute a Gradle Refresh on your project to bring in all dependencies.

2: Test the *JPAVideoStore* project:

* When integrating two technologies, always ensure (if possible) that they work in isolation. This makes debugging much easier later.

3: Create a Dynamic Web Project:

* In STS, create a new Dynamic Web Project _File -> New -> Dynamic Web Project_.

  *  In the *Project Name* field, name it *MVCVideoStore*.

  * Click ***Next***, click ***Next*** again.

  * On the *Web Module* dialogue, check the ***Generate web.xml deployment descriptor*** box.

  * Click ***Finish***

4: ***Add a Gradle Nature*** to *MVCVideoStore*:

* Right click on *MVCVideoStore* and then select _Configure -> Add a Gradle Nature_

* It will be useful to have the *Gradle Tasks* view available:

  * Click on _Window -> Show View -> Other_ and select the *Gradle Tasks* view

* In the *Gradle Tasks* view, under _MVCVideoStore -> build setup_, double click *init* (this will generate a *build.gradle*, *settings.gradle* etc for the project)

  * Right click on the *MVCVideoStore* project, and select _Gradle -> Refresh Gradle Project_, the gradle files should be visible now.


5: Configure *MVCVideoStore*:

* We will be configuring the *build.gradle* file for our Dynamic Web Project much as we have in the past (the following file should look extremely familiar):

```groovy
// build.gradle

apply plugin: 'java'
apply plugin: 'war'
apply plugin: 'eclipse-wtp'

project.webAppDirName = 'WebContent'

group = 'com.videostore'
version = '0.0.1-SNAPSHOT'

ext {
  springVersion = "4.3.2.RELEASE"
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

eclipse {
  classpath {
    downloadSources = true
  }
}

sourceSets {
  main {
    java.srcDirs 'src'
    resources.srcDirs 'src/resources'
  }
  test {
    java {
      srcDir 'test'
    }
    resources {
      srcDir 'test'
      srcDir 'test/resources'
      srcDir 'WebContent/WEB-INF/spring'
    }
  }
 }

repositories {
     mavenCentral()
}

dependencies {
    compile group: 'org.springframework', name: 'spring-webmvc', version:"$springVersion"
    compile group: 'javax.servlet', name: 'javax.servlet-api', version:'3.1.0'
    compile group: 'javax.servlet', name: 'jstl', version:'1.2'
    compile group: 'org.hibernate', name: 'hibernate-validator', version:'5.2.4.Final'
    compile group: 'org.springframework', name: 'spring-orm', version:"$springVersion"
    compile "org.springframework:spring-test:$springVersion"
    compile "org.springframework:spring-tx:$springVersion"

    testCompile 'junit:junit:4.12'
    testCompile 'org.hamcrest:hamcrest-junit:2.0.0.0'
}
```

* after adding the groovy configuration above to your *MVCVideoStore/build.gradle* file:

  * Run a *Refresh Gradle Project*

  * Your file structure should have changed slightly and you should see external and system dependencies included

6: Incorporate *JPAVideoStore* into *MVCVideoStore*:

* The first step in including a *sub project* is letting the parent project know that it has to include it as a dependency. This is done in the *settings.gradle* file.

  * Open *MVCVideoStore/settings.gradle*

    * add `includeFlat 'JPAVideoStore'`:

```groovy
// settings.gradle
rootProject.name = 'MVCVideoStore'

includeFlat 'JPAVideoStore'
```

    * This tells *MVCVideoStore* that it has a *sub project* named *JPAVideoStore*

* Now that *Gradle* knows there is a *sub project* we have to tell it to compile the project as a dependency. This is done in the *build.gradle* file.

  * Open *MVCVideoStore/build.gradle*

    * add `compile project(':JPAVideoStore')` to your dependencies object:

```groovy
// build.gradle

//...

dependencies {

  compile project(':JPAVideoStore')

//...

}
```

* Run *Refresh Gradle Project* on your *MVCVideoStore* project, you should now see a *Web App Libraries* directory with *JPAVideoStore* inside of it. This is a good indication that the *sub project* build succeeded.

7: Test that the *JPAVideoStore* entities are available:

* Let's double check that everything is working correctly.

  * Create a *test* package in the *src* directory

  * Create a *TestDependency* class in the *test* package

    * add a `main`, and use your `ActorDAO.show()` method to return an *Actor* object, print out the objects `toString()`. If everything is configured correctly this will work.


### ***Troubleshooting***:

* The above instructions will work, though, there are mitigating factors which may cause Gradle to complain.

* First, clean your projects and refresh them. Be sure to run *build/clean* as well as *ide/cleanEclipse* and *ide/cleanEclipseWtp*, also, run *Refresh Gradle Project*

* Second, if some of your classes are in error state, read the corresponding error. In most cases, repeat step 1.

* Third, if you receive a `projectName cannot contain a reference to itself` exception...

  * In the terminal navigate to your project's directory, and delete the `.classpath` and `.project` hidden files

  * Run the Gradle Tasks -> `ide/cleanEclipse` and `ide/cleanEclipseWtp` then, in STS under _Project -> Clean_ clean your project

  * Right click on the project, select _Build Path -> Configure Build Path..._

    * Click on _Add Library..._

      * Select _JRE System Library_, add it to your build path

      * Select _Web App Libraries_, select your project (under *Project:*), and add it to your build path

  * Run the Gradle Task -> `build/build`

  * Perform a *Refresh Gradle Project* on your project

* Fourth, if you receive a Gradle build error referencing the `:runTime` task, or a `'default configuration'` it is highly likely that either the project import failed to assemble the Gradle environment correctly, or that you neglected to click the *copy projects into workspace* box. In either event. Delete this workspace and start over (trust me).

[Previous](README.md) | [Next](adding_dependencies_gradle.md)
