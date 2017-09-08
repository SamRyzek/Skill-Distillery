## JSTL — List Iteration

* Use the `<c:forEach>` tag to iterate over arrays and collections.

  * Specify the loop variable using the `var` attribute.

  * The `items` attribute is used to indicate what to iterate over.

    * Iterator, List, Set, and arrays are all allowed datatypes.

    ```html
    <c:forEach var="item" items="${cartBean.contents}">
    <tr>
      <td>${item.id}</td>
      <td>${item.quantity}</td>
    </tr>
    </c:forEach>
    ```

<hr>

StocksWithJSP/WebContent/select.jsp

```html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
  <title>Stocks</title>
 </head>
 <body>
  <form action="Stocks" method="POST">
   <c:forEach var="stock" items="${stocks}">
    <input type="radio" name="symbol"
           value="${stock.symbol}"/>${stock.name}<br/>
   </c:forEach>
   <input type="submit" value="Submit" />
  </form>
 </body>
</html>
```

[Prev](05-JSTLConditionals.md) | [Up](../README.md) | [Next](06-JSTLMapIteration.md)
