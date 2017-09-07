## JSPs and Servlets

* The standard protocol for communication between browsers and servers is designed for static documents.

  * Typically, a web server returns the contents of a static file in response to a browser request.

* Use servlets and JavaServer Pages (JSP) to handle requests from a browser dynamically.

  * A servlet is a web component which receives an object encapsulating the browser request and constructs a response to the browser.

    * The response typically contains an HTML document.

  * JSP pages start as text documents containing HTML with special tags for executing Java code.

    * JSP pages are compiled into servlets automatically.

    * HTML designers do not need to learn Java.

    * Java developers do not need to learn HTML.

* You get some important benefits by using Java's web component architecture:

  * Your application will be portable across web containers.

  * You can make full use of the vast set of Java APIs.

<hr>
HelloWorld/src/web/HelloWorldServlet.java

```java
package web;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelloWorldServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = req.getParameter("nm");
    String outputText = "Hello " + name;
    PrintWriter pw = resp.getWriter();
    pw.println("<html>");
    pw.println("<head><title>Hello World</title></head>");
    pw.println(" <body>" + outputText + "</body>");
    pw.println("</html>");
    pw.close();
  }
}
```

[Prev](01-WebApplications.md) | [Up](../README.md) | [Next](03-WarFile.md)
