## Building and Deploying the WAR

* You build your application using these steps:

  1. Create a directory in which to build your web application.

  2. Compile your classes putting the resulting class files in WEB-INF/classes.

* If you create any JAR files, put them in WEB-INF/lib.

  3. Copy your JSP files, HTML files, and other supporting files into the application directory.

  4. Optionally, create your deployment descriptor in WEB-INF/web.xml.

* To build the WAR file, use the jar command to archive the application directory.

  ```
  jar cvf MyApplication.war webapp-directory
  ```

* You deploy a web application with these fundamental steps.

  1. Pass the WAR file to your web container.

* You might simply copy the file to a specific location or use a tool to locate the file.

  2. Specify the context path for the application.

* The context path often defaults to the name of the WAR file.

  3. Configure any container-managed resources as specified in the deployment descriptor.

* These might include database connections, JNDI services, and security roles.

<hr>
The mechanisms for performing the deployment steps is determined by your web container. Some container providers have GUI or web-based tools for deploying applications. You may need to create the appropriate configuration files manually and include them in your WAR file.

#### Try It:
Your instructor will show you how to build and deploy the HelloWorld web application on your system.


[Prev](04-WebXML.md) | [Up](../README.md) | [Next](Labs.md)
