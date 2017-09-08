## JSTL Escaping Data

* The simple EL method of outputting data, `${object.member}`, is useful but can fail to display as desired in cases where data must be escaped (quotes, angle brackets, etc.).

```html
<!--
Note: A user has entered name as Robert "Bobby" Dobbs.
-->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
 <head>
  <title>Users</title>
 </head>
 <body>
  <c:forEach var="user" items="${users}">
    <a href="details.do?name=${user.name}">Go to ${user.name} details</a><br/>
  </c:forEach>
 </body>
</html>
```

* This link is written to the browser incorrectly - the double quote in the user's name breaks ends the `href's` value, so the link tries to go to `details.do?name=Robert `.

```html
<a href="details.do?name=Robert "Bobby" Dobbs">Go to Robert "Bobby" Dobbs details</a>
```

* Fix this by using `c:out` from the jstl core library.
  * Replace the `${user.name}` with `<c:out value="${user.name}"/>`.
  * Note how the EL token is the `value` of the `c:out` tag. This will escape characters so they can be safely displayed on by the browser.

```html
<c:forEach var="user" items="${users}">
  <a href="details.do?name=<c:out value="${user.name}"/>">Go to <c:out value="${user.name}"/> details</a><br/>
</c:forEach>
```

* Spaces become %20 and quotes %22.

* Escaping data is especially important when echoing user-entered data (such as data collected with form fields) to the screen. Not doing so leaves the site open to <a href="https://www.owasp.org/index.php/Cross-site_Scripting_(XSS)">Cross-site Scripting (XSS)</a> attacks.

[Prev](07-JSTLFormatting.md) | [Up](../README.md) | [Next](Labs.md)
