## Bean Scopes in JSPs

* JSP Expression Language can access any variable stored within the `page`, `request`, `session`, or `application` scope by name.

  * `page` scope is essentially local.

  * `request` and `session` scopes correspond to `ServletRequest` and `HttpSession`, respectively.

  * Use `application` scope when you wish to access data stored in the `ServletContext`.

* EL first searches within the `page` scope; if the variable cannot be found there, and then look in each of the other three scopes in turn.

```
${personBean}
```

* Once the variable has been found, EL will not continue to search for it under any other scopes.

  * If the variable can not be found under any of the four scopes, then its value will be null.

* You can also explicitly access a variable in a particular scope using an implicit object.

```
${sessionScope.personBean}
```

  * Available implicit objects include `pageScope`, `requestScope`, `sessionScope`, and `applicationScope`.

<hr>

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
 <c:if test="${! empty(sessionScope.stocks)}">
 <table border="0">
  <tr>
   <th>symbol</th>
   <th>name</th>
   <th>price</th>
   <th>open</th>
   <th>trend</th>
  </tr>
  <c:forEach var="stock" items="${sessionScope.stocks}">
   <tr>
    <td>${stock.symbol}</td>
    <td>${stock.name}</td>
    <td>
     <fmt:formatNumber value="${stock.price}" type="currency" />
    </td>
    <td>
     <fmt:formatNumber value="${stock.openPrice}" type="currency" />
    </td>
    <c:choose>
     <c:when test="${stock.price < stock.openPrice}">
      <td><img src="images/downarrow.png"/></td>
     </c:when>
     <c:otherwise>
      <td><img src="images/uparrow.png"/></td>
     </c:otherwise>
    </c:choose>
   </tr>
   </c:forEach>
  </table>
 </c:if>
 </body>
</html>
```

[Prev](01-ServletJSPData.md) | [Up](../README.md) | [Next](03-HttpSession.md)
