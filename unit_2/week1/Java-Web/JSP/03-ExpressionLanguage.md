## JSP Expression Language Syntax

* JSP Expression Language (JSP EL) elements uses `${expression}` syntax.

```html
${stock}
```
  * The value within the curly braces is usually a JavaBean that the servlet created and saved to a scope accessible by the JSP.

* Use the `.` (dot) operator to access bean properties by name.

```html
${stock.price}
```

  * Specify the name of the property you wish to access after the dot.

    * The EL will automatically call the get method corresponding to the property.

  * You can navigate through a bean's nested properties by chaining multiple dots together.

* Use the `[ ]` operator when accessing data from a collection.

  * Place an integer within the square braces to access an item from an array or List based on its index (indexes are zero-based).

  ```html
  ${cart.item[1].description}
  ```

  * If the collection you are working with is a Map, then use the name of the key as a String within the square braces to access its corresponding value.

  ```html
  ${map["emp1234"].salary}
  ```

<hr>

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

If you want a comment to be visible to the client browser, use the HTML comment:

```html
<!-- This is an HTML comment -->
```
A JSP comment is not compiled into the servlet and is never visible to the client browser.

```
<%-- This is a JSP comment --%>
```

#### JSP EL Literals
* Boolean — Use the `true` and `false` literals to represent boolean content.
* Integer — The rules for integer literals in EL are the same as for Java.
* Floating Point — The rules for floating point literals in EL are also the same as for Java.
* String — To embed literal strings in an EL expression, surround them with single or double quotes.
* Null — Use the `null` literal to represent null content.

#### JSP EL Operators
* Binary arithmetic operators: `+`, `-`, `*`, `/`, `div`, `%`, `mod`
* Logical binary operators: `and`, `or`, `&&`, `||`
* Unary negation operators: `not`, `!`
* Binary relational operators: `<`, `<=`, `==`, `>=`, `>`, `lt`, `le`, `eq`, `ge`, `gt`
* Conditional/Ternary operator: `?:`
* Empty operator: `empty`.
  * The `empty` operator checks to see if a value is null or empty, and, if so, evaluates to true.

The EL is very forgiving. It will convert the variable to the correct type based on what you are trying to do with it. NullPointerExceptions and ArrayIndexOutOfBoundsExceptions are not thrown; instead, the expression will yield an empty string.

[Prev](02-IntroJSP.md) | [Up](../README.md) | [Next](04-CallingJSP.md)
