# Storing an Object in the Session

* Using Servlets, we have seen how to store Objects in a user's session by getting the `HttpSession` object from the `HttpServletRequest`.

```java
@WebServlet("/Stocks")
public class StockServlet extends HttpServlet {
@Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
    String symbol = req.getParameter("symbol");
    Stock stock = stockDAO.getStock(symbol);
    HttpSession session = req.getSession();
    session.setAttribute("stock" , stock);
    ...
  }
}
```

* Objects in session are stored across requests, whereas data set as `HttpServletRequest` attributes or added to the Spring `Model` are available for a single request.

* Using Spring, inject the `HttpSession` object into your controller method by simply listing it as a parameter.

    ```java
    // src/controllers/DataController.java
    package controllers;

    @Controller
    public class DataController {
      @RequestMapping("addData.do")
      public void lotto(HttpSession session) {
        // ...implementation code
      }
    }
    ```

* Store data to the session like you would in a servlet by calling the `setAttribute(String, Object)` method on the session object, passing a key/value pair.

  ```java
  // src/controllers/DataController.java
  package controllers;

  @Controller
  public class DataController {
    @RequestMapping("AddData.do")
    public void addData(HttpSession session) {
      session.setAttribute("data", 27);
    }
  }
  ```

* You may retrieve data stored in a session with the `getAttribute(String)` method.

  ```java
  // src/controllers/DataController.java
  package controllers;

  @Controller
  public class DataController {
    @RequestMapping("AddData.do")
    public String addData(HttpSession session) {
      session.setAttribute("data", 27);
    }

    @RequestMapping("GetData.do")
    public String getData(HttpSession session) {
     return (String) session.getAttribute("data");
    }
  }
  ```

<hr>

### Example:
* The following example is a Java controller with a route ("GetNumbers.do") which draws some number of lottery numbers, and then stores those lottery numbers into a session (presumably for historical record).

```java
package contollers;

@Controller
public class LottoController {
  @Autowired
  private Hopper hopper;

  @RequestMapping("GetNumbers.do")
  public String lotto(@RequestParam("howmany") int count,
            HttpSession session) {
    List<Integer[]> lottoHistory = (List<Integer[]>) session.getAttribute("lottoHistory");

    if (lottoHistory == null) {
      lottoHistory = new ArrayList<>();
      session.setAttribute("lottoHistory", lottoHistory);
    }

    lottoHistory.add(getLottoNumbers(count));
    return "form.jsp";
  }

  private Integer[] getLottoNumbers(int howMany) {
    Integer[] drawing = new Integer[howMany];
    hopper.reset();

    for(int i = 0 ; i < howMany ; i++) {
      drawing[i] =
        Integer.parseInt(hopper.drawBall().getValue());
    }

    Arrays.sort(drawing);
    return drawing;
  }
}
```

```html
<!-- form.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lottery</title>
</head>
<body>
	<h3>Lottery Numbers</h3>
	<form action="GetNumbers.do" method="GET">
		<input type="text" name="howmany" value="6" size="2" /> <input
			type="submit" value="Get Numbers" />
	</form>
	<table>
		<c:forEach var="drawing" items="${sessionScope.lottoHistory}">
			<tr>
				<c:forEach var="number" items="${drawing}">
					<td>${number}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
```

[Prev](README.md) | [Up](../README.md) | [Next](spring_session.md)
