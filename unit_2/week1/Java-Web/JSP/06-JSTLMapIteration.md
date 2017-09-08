## JSTL — Map Iteration

* You can also use `<c:forEach>` to iterate over Maps.

* With a Map, the `var` attribute represents a map entry - a key/value pair.

  * You must use its `key` and `value` properties to access the actual data.

    ```html
    <select name="product">
      <c:forEach var="prod" items="${inventoryMap}">
        <option value="${prod.key}">${prod.value}</option>
      </c:forEach>
    </select>
    ```

<hr>

[Prev](06-JSTLListIteration.md) | [Up](../README.md) | [Next](07-JSTLFormatting.md)

