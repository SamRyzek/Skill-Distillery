## HttpServlet

* A servlet is a class that extends `javax.servlet.http.HttpServlet`.

  * HttpServlet declares `doGet()` and `doPost()` methods, that are called by the web container whenever it receives a **GET** or **POST** request for the servlet.

  * Your servlet should override the `doGet()` or `doPost()` methods.

    * This is where you process the request from the browser.

    * If you don't differentiate between **GET** and **POST** requests, have your `doPost()` method call your `doGet()`, or vice versa.

  * Other `doxxx()` methods are available, but rarely used for web applications.

* `doGet()` and `doPost()` are passed an HttpServletRequest and an HttpServletResponse as parameters.

  * The **HttpServletRequest** gives you information about the request.

    * Call the `getParameter()` method on the HttpServletRequest to retrieve HTML form data.

      ```
      String age = request.getParameter("age");
      ```

  * Use the **HttpServletResponse** to write content back to the browser.

    * The `getWriter()` method returns a PrintWriter that you can use to write a document to the browser.

    ```
    PrintWriter pw = response.getWriter();
    pw.println("<html>");
    ```

<hr>

Stocks/src/web/StockServlet.java
```java
package web;
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
    pw.print("<body>");
    if (amount != -1) {
      pw.printf("<p>%s = %.2f</p>", symbol, amount);
    }
    else {
      pw.println("<p>Invalid Symbol</p>");
      pw.println("<p><a href=\"select.html\">Try Again?</a></p>");
    }
    pw.println("</body>");
    pw.println("</html>");
    pw.close();
  }
  ...
}
```


[Prev](01-HTTPRequests.md) | [Up](../README.md) | [Next](03-ServletLifecycle.md)
