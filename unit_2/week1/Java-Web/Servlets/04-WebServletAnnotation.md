## The @WebServlet Annotation

* Add the @WebServlet annotation to your servlet class to define the alias that will be used to identify your servlet within a URL.

  ```java
  @WebServlet("/MyServlet")
  ```

* Use the URL pattern to access the servlet from an HTML form.

  ```java
  <form action="MyServlet" method="get">
  ```

* You can specify multiple URL patterns if you want to have multiple access points.

  ```java
  @WebServlet(urlPatterns = {"/MyServlet", "/srv/*"})
  ```

* Versions of the Servlet API prior to 3.0 used web.xml to accomplish this.

  ```xml
  <web-app ...>
    <servlet>
      <servlet-name>MyServletName</servlet-name>
      <servlet-class>web.TheServlet</servlet-class>
    </servlet>
    <servlet-mapping>
      <servlet-name>MyServletName</servlet-name>
      <url-pattern>/MyServlet</url-pattern>
    </servlet-mapping>
  </web-app>
  ```

<hr>

Stocks/WebContent/select.html
```html
<!DOCTYPE html>
<html>
 <head>
  <title>Stocks</title>
 </head>
 <body>
  <form action="StockPrice" method="GET">
   <input type="text" name="symbol" />
   <input type="submit" value="Submit" />
  </form>
 </body>
</html>
```

Stocks/src/web/StockServlet.java

```java
package web;
...
import javax.servlet.annotation.WebServlet;
...
@WebServlet("/StockPrice")
public class StockServlet extends HttpServlet {
  ...
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
    String symbol = req.getParameter("symbol");
    double amount = stockDAO.getPrice(symbol);
    PrintWriter pw = resp.getWriter();
    pw.println("<html>");
    pw.println("<head><title>Stocks</title></head>");
    ...
    }
  ...
}
```

[Prev](03-ServletLifecycle.md) | [Up](../README.md) | [Next](Labs.md)
