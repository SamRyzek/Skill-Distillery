## The Servlet Lifecycle

* The web container controls the lifecycle of the servlet.

  * When the first request is received, the container instantiates the servlet and calls the init() method on it.

  * For every request, the container uses a separate thread to call the doGet() or doPost() methods.

  * When the servlet is unloaded, the container calls the destroy() method.

  * There will typically only be one instance of the servlet created per web container.

  * The time between init() and destroy() can usually be measured in days or even months.

<hr>

Stocks/src/web/StockServlet.java

```java
package web;
...
@WebServlet("/StockPrice")
public class StockServlet extends HttpServlet {
  private StockDAO stockDAO;
  @Override
  public void init() throws ServletException {
    System.out.println("In init() method");
    stockDAO = new StockFileDAO(getServletContext());
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    ...
  }

  @Override
  public void destroy() {
    System.out.println("In destroy method");
  }
}
```

[Prev](02-HttpServlet.md) | [Up](../README.md) | [Next](04-WebServletAnnotation.md)
