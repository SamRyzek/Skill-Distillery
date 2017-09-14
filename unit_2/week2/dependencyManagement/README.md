## Dependency Management

We've been using Eclipse's `Run As` menu to build and deploy our Java projects.  Developers use many other _build automation_ tools to manage the build/test/deploy process.  Usually these center on a build configuration file for each project.

* `make` - Widely used in C-language open-source projects including GNU. File: `Makefile` (`make`-specific format)
* Apache Ant - Popular for Java projects. File: `build.xml` (XML)
* `npm` - Node.js build and package manager. File: `package.json` (JSON)
* Rake - Used to manage Ruby projects.  File: `Rakefile` (Ruby)
* Grunt - Used primarily for front-end development projects.  Files: `package.json` (JSON), `Gruntfile` (JavaScript)
* Apache Maven - Convention-based, popular for Java and other language projects.  File: `pom.xml` (XML)
* Gradle - Designed for large, multi-project builds, primarily for Java, Groovy, and Scala. File: `build.gradle` (Groovy)

Projects often depend on external libraries from other developers or organizations.  To make it easier for others to use their libraries, developers and organizations publish their code to external _repositories_.  In a project of any size or complexity, this can lead to:

* Difficulty managing versions among a team
* Build errors when libraries are not included
* Inconsistent or dangerous download locations

To help deal with this, build automation tools also include _dependency management_ to handle retrieving and including libraries.  

We've already used Maven for our web projects - let's take a closer look.

[Next](maven/README.md)
