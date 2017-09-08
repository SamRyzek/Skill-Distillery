## Calling a JSP

* Execute a JSP with a RequestDispatcher.

  * Obtain the RequestDispatcher from the ServletContext.

  ```java
  ServletContext context = getServletContext();
  RequestDispatcher dispatcher =
  context.getRequestDispatcher("/jspName");
  ```

  * Call the forward() method on the RequestDispatcher.

  ```java
  dispatcher.forward(request, response);
  ```

    * You can not modify the response in any way after you have forwarded to a JSP.

* The calling servlet and JSP share the request object.

  * Use request attributes to share data between servlets and JSPs.

* You can set attributes on the request with the setAttribute() method.

  ```java
  request.setAttribute("stockPrice", 150.5);
  ```

  * Pass the attribute name as a String and the value as an Object.

  * There can only be one attribute with a given name on the request at a time.

* Access the attribute within JSP EL by name.

  ```java
  ${stockPrice}
  ```

  * You can optionally use the requestScope implicit object for clarity.

    ```java
    ${requestScope.stockPrice}
    ```

<hr>

StocksWithJSP/src/web/StockServlet.java

```java
package web;
...
@WebServlet("/Stocks")
public class StockServlet extends HttpServlet {
  ...
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
                     throws ServletException, IOException {
    String symbol = req.getParameter("symbol");
    Stock stock = stockDAO.getStock(symbol);
    if (stock != null) {
      req.setAttribute("stock", stock);
      req.getRequestDispatcher("/results.jsp").forward(req, resp);
    }
    else {
      req.getRequestDispatcher("/error.jsp").forward(req, resp);
    }
  }
}
```

StocksWithJSP/WebContent/results.jsp

```html
...
<body>
<table border="0">
...
 <tr>
  <td>${stock.symbol}</td>
  <td>${stock.name}</td>
  ...
</table>
</body>
</html>
```

[Prev](03-ExpressionLanguage.md) | [Up](../README.md) | [Next](05-JSTLConditionals.md)
