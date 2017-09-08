## JSTL Conditionals

* The JSP Standard Tag Library (JSTL) was developed to encapsulate common functionality, such as conditionals and iteration into re-usable actions.

* To use the tags, you must add the taglib directive to specify the tag library uri and prefix.

```html
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
```

* For a simple if statement, use the <c:if> tag (there is no else tag).

```html
<c:if test="${boolean expression}">
  <%-- content to include if the conditional is true --%>
</c:if>
```

* For more complex conditionals, use the <c:choose> tag.

  * Use <c:when> tags for each condition and an optional <c:otherwise> tag for any conditions that do not match.

  ```html
  <c:choose>
    <c:when test="${boolean expression}">
      <%-- ... --%>
    </c:when>
    <c:when test="${boolean expression}">
      <%-- ... --%>
    </c:when>
    <c:otherwise>
      <%-- ... --%>
    </c:otherwise>
  </c:choose>
  ```

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
    ...
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

[Prev](04-CallingJSP.md) | [Up](../README.md) | [Next](06-JSTLListIteration.md)
