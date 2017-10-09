## jQuery Methods

* `.attr()`: can be used to access or set the value of an html elements attribute.
```javascript
$('#myDiv').attr('name')      //returns the value of the name attribute on the HTML element
$('#myDiv').attr('name', 'sweet')      //sets the value of the name attribute on the HTML element
```

* `.each()`: takes a collection and callback function as an argument. Iterates over the elements in the collection and executes that function on each element matched by the selector.
```javascript
$('p').each(function(index){
    console.log(this.id + " " + index);
    $(this).html('woooo');
});
```
Inside of the `each` function we can reference the current element with `this`. The `this` keyword gives you access to the raw HTML element, if we want to call additional jQuery methods on this individual element we can wrap this in the jQuery function. `$(this)`.

* `.wrap()`: adds an element you have created surrounding the targeted element.
```javascript
  $('#myList').wrap('<div class="list"></div>');
```
Results in :
```html
  <div class="list">
    <ul id="myList">
      <li>new list item</li>
    </ul>
  </div>
```

* `.css()`: can be used to alter the css of a targeted element.
* `.html()`: gets the html contents from the selected element.
* `.text()`: gets the text content of the selected elements.
* `.val()`: gets the value associated with an input field.
* `.addClass()`: Adds a class property to the selected element.
* `.empty()`: Empties the content (both text and html) inside of the selected element.

The full list of methods can be referenced in the [jQuery API docs][jQueryDocs].


[Previous](dynamicallyRemoveElements.md) | [Next](form.md)


[jQueryDocs]:https://api.jquery.com/
