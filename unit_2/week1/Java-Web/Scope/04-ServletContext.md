## ServletContext

* A `ServletContext` allows a servlet to work with its application.

  * There is one `ServletContext` for each web application per container.

* Call the `getServletContext()` method on your `Servlet` object to retrieve the context.

```java
ServletContext context = getServletContext();
```

* You can set and retrieve attributes on the `ServletContext` that are available to any servlet or JSP in the web application using `getAttribute()` and `setAttribute()`, like you would with `HttpServletRequest` or `HttpSession`.

* You can also use `ServletContext`'s `getResourceAsStream()` method to retrieve an `InputStream` for reading in files within your web application.

<hr>

StocksWithSessions/src/web/StockServlet.java

```java
...
@WebServlet("/Stocks")
public class StockServlet extends HttpServlet {
  @Override
  public void init() throws ServletException {
    ServletContext context = getServletContext();
    StockDAO stockDAO = new StockFileDAO(context);
    context.setAttribute("stockDAO", stockDAO);
  }
  ...
  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
    String symbol = req.getParameter("symbol");
    ServletContext context = getServletContext();
    StockDAO stockDAO = (StockDAO)context.getAttribute("stockDAO");
    HttpSession session = req.getSession();
    ...
  }
}
```

StocksWithSessions/WebContent/select.jsp

```html
...
<body>
 <form action="Stocks" method="POST">
 <c:forEach var="stock" items="${applicationScope.stockDAO.allStocks}">
  <input type="radio" name="symbol" value="${stock.symbol}"/>${stock.name}<br />
 </c:forEach>
  <input type="submit" value="Submit" />
 </form>
...
</body>
</html>
```

[Prev](03-HttpSession.md) | [Up](../README.md) | [Next](Labs.md)
