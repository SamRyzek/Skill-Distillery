## The WAR File

* You must organize your web application using a specific directory structure.

  * The application root directory acts as the document root for your application.

    * You put your JSP, HTML, and other supporting files here.

    * You can use subdirectories to organize your application.

  * Store your application files in a subdirectory named WEB-INF.

    * Place the optional web.xml configuration file here.

    * This subdirectory is not accessible via the web server.

  * Put your servlet classes and supporting classes in the WEB-INF/classes directory.

  * Put any JAR files specific to your application in the WEB-INF/lib directory.

    * This is the preferred method for storing your JavaBeans.

    * If a JAR file will be used by other applications, it may make more sense to put it in a system-wide or server-wide directory.

* You can package your application for distribution in a Web ARchive (WAR) file.

  * A WAR file is a JAR file that contains all of the files in your application.

  * Since WAR files must conform to the Java EE specifications, they are portable between different web containers.

<hr>

[Prev](02-JspServler.md) | [Up](../README.md) | [Next](04-WebXML.md)
