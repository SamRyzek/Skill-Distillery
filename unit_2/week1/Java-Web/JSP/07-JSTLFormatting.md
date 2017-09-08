## JSTL — Formatting

* JSTL provides a set of tags to assist with Internationalization (I18N) of your JSP documents.

  * These tags are also referred to as formatting tags.

  * To use these tags, you must add a different taglib directive to specify the tag library uri and prefix.

  ```html
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
  ```

* To format a number, use the `<fmt:formatNumber>` tag.

  * Use the value attribute to specify the number to format.

    * The value can contain JSP EL.

  * Use the type attribute to specify how to format.

    * Possible values are currency, percent, and number.

    ```html
    <fmt:formatNumber value="18.99" type="currency"/>
    ```

* To format a date, use the `<fmt:formatDate>` tag.

  * For the type attribute specify either `date`, `time`, or `both`.

<hr>

StocksWithJSP/WebContent/results.jsp

```html
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
 <head>
  <title>Stocks</title>
 </head>
 <body>
  <table border="0">
   <tr>
    <th>symbol</th>
    <th>name</th>
    <th>price</th>
    <th>open</th>
    <th>trend</th>
   </tr>
   <tr>
    <td>${stock.symbol}</td>
    <td>${stock.name}</td>
    <td>
     <fmt:formatNumber value="${stock.price}"
type="currency" />
    </td>
    <td>
     <fmt:formatNumber value="${stock.openPrice}"
type="currency"/>
    </td>
    <c:choose>
     <c:when test="${stock.price < stock.openPrice}">
     <td><img src="images/downarrow.png" /></td>
     </c:when>
     <c:otherwise>
     <td><img src="images/uparrow.png" /></td>
     </c:otherwise>
    </c:choose>
   </tr>
  </table>
 </body>
</html>
```

[Prev](06-JSTLMapIteration.md) | [Up](../README.md) | [Next](08-JSTLEscaping.md)
