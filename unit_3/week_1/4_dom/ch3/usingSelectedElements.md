## Using a Selected Element

### Iterating over returned elements
Traditionally when we execute ``document.getElementsByTagName('p');`` a node list containing all of the matching elements on the page is returned. From here we have to iterate over this array to execute actions on these elements.

```javascript
  var pElements = document.getElementsByTagName('p');
  for(var i = 0 ; i< pElements.length; i++){
    pElements[i].style.display = 'none';
  }
```

Similarly with jQuery a selector returns list of all the elements, but we no longer need to iterate over this list. By chaining an action to the selector we can act upon all the elements in the returned collection.

```javascript
  $('p').hide();
```

### jQuery Objects
When you use a selector a jQuery object is returned. If you choose to save this return into a variable it is standard practice to begin the variable name with the jQuery ``$`` notation.

```javascript
var $h1 = $('h1');
```

If there are multiple ``<h1>`` tags on the page your variable would store an array of jQuery objects.


A list of all the possible jQuery selectors can be found [here][w3Schools]

### Traversing the DOM
Traversing the DOM means to move through elements in an html page. We can use tools the jQuery library provides us to select specific HTML elements based on their proximity to other elements. If you look at a well formed HTML document you can see the relationships through indentation. Any element in the page can have parent nodes, child nodes, and sibling nodes.

```html
<h1>I Like to</h1>
<ul>
  <li>Hike</li>
  <li>Sleep</li>
  <li>Code</li>
</ul>
```
**Parent**: A parent element is an element that has other html elements inside of it. Each `<li>` element's parent is the `<ul>` element.

**Child**: A child element is an element that exists inside of another html element.
The `<ul>` element has 3 children, the `<li>`s.

**Sibling**: Sibling elements are elements that exist at the same level of the HTML document structure. All the`<li>` elements are siblings. Additionally the `<h1>` and `<ul>` elements are siblings as well, siblings do not need to be of the same type.

* Once an HTML element has been selected you can access that element's children, as well as it's parent with jQuery:

```html
<body>
    <ul id="list">
        <li>item 1</li>
        <li>item 2</li>
        <li>item 3</li>
        <li>item 4</li>
        <li>item 5</li>
    </ul>

    <script type="text/javascript">
        var list = $('#list');

        console.log(list.children().length);

        // List of child elements
        console.log(list.children());

        // One single parent
        console.log(list.parent());
    </script>
</body>
```

```bash
5
[li,li,li,li,li]
<body>...</body>
```

### jQuery traversal methods
Once you have made a jQuery selection you can access other nodes up and down the tree, relative to the current selection. We have already seen a few of these in our examples above

* `.find()`: Finds all elements from the initial element that match an additional selector.
* `.parent()`: Find the parent of the selected element. Additionally `.parents()` finds all parent elements.
* `.children()`: Finds all the children of the selected element.
* `.siblings()`: Finds all the siblings of the selected element.
* `.next()`: Finds the next sibling of the selected element.
* `.prev()`: Finds the previous sibling of the selected element.
* `.first()` : Reduce the result set to the first element.
* `.last()` : Reduce the result set to the final element.

* From a list of children you can select and access a single elements properties:

```javascript
var list = $('#list');
console.log(list.children().eq(0);
console.log(list.children().eq(0).text());

```

```bash
item 1
```

### Hands On
* Use the following HTML for this example.
```html
<body>
  <div id="wrapperDiv">
    <ul>
      <li>List 1</li>
      <li>List 2</li>
    </ul>
  </div>
</body>
```
* Select the unordered list and return a list of its children
* Select the parent element of the unordered list
* Select the parent element of the div
* Select the second list item and print out its text


[Previous](selectingDomElements.md) | [Next](traverse.md)


[w3Schools]:http://www.w3schools.com/jquery/jquery_ref_selectors.asp
