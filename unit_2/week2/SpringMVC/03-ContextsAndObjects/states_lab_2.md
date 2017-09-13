## States Lab - Root and Servlet Contexts

Modify your USStates project to have a root and servlet WebApplicationContext. Also enable component scanning for the root context.

1. Split your Spring configuration file into two files.

	* create the folder in `/WEB-INF/spring`

	* Move `States-servlet.xml` to this folder.

	* Comment out your `StateDAOImpl` bean.

	* Create another Spring configuration file in this folder named `app-context.xml`. It will not contain any beans, nor have `mvc:annotation-driven` enabled.

2. Modify your USStates project's `web.xml` to use the two Spring configuration files.

3. Mark `StateDAOImpl.java` as a `@Component`.

4. Enable component-scanning in `app-context.xml` for the package `data` so that Spring can find your `StateDAOImpl` class.

5. Re-run your application and unit tests to verify that everything still works.


<hr>

[Prev](modelattribute.md) | [Up](../README.md)
