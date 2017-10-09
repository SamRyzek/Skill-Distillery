## Selectors

### Overview
jQuery uses CSS style selectors to target elements in the DOM. Selectors follow the syntax below:
```javascript  
jQuery(selectorExpression);
  or  
$(selectorExpression);
```

* Normally you will target elements by tag, class, and id.
  * Target by tag name: ``$('h1')``  
  * Target by class name: ``$('.myClass')``  
  * Target by ID: ``$('#myID')``  
  * Target by Attribute: ``$('div[name]')``  or ``$('div[name = "test"]')``  

* You can select multiple elements at the same time by providing a comma separated list of elements to jQuery.

```javascript
$('h1,a,div')
```

* You are however not limited to these. Any valid CSS selector can be passed into jQuery to access an element. An example can be seen below.

``$("ul li:first-child")``

If there is only one element that matches your selector a jQuery object of that element will be returned to you. However, if there are multiple elements in the DOM that match your selector, an array of jQuery objects will be returned.

```html  
<body>
      <h1>Hello World</h1>

      <p>para 1</p>
      <p>para 2</p>
      <p>para 3</p>

      <ul class="list">
          <li>item 1</li>
          <li>item 2</li>
          <li>item 3</li>
          <li>item 4</li>
          <li>item 5</li>
      </ul>

      <div id='mainContent'>
          <div id='subContent'>
              <div id='nestedContent'></div>
          </div>
      </div>

      <script type="text/javascript">
          var paragraphs = $('p');
          var mainContent = $('#mainContent');
          var list = $('.list');

          console.log('paragraphs:');
          console.log(paragraphs);

          console.log('mainContent:');
          console.log(mainContent);

          console.log('list:');
          console.log(list);
      </script>
</body>
```

```bash
paragraphs:
[p, p, p, p, p]

mainContent:
div#mainContent

list
[ul.list]
```

* It is important to note that the items above that look like `Array`s are not actually `Array`s, they are `jQUery Collection`s. These are `Array`-like-objects that can be iterated over, but which do not have access to the the `Array` methods.

### Hands On
* Create an HTML document with the below content
```html
<body>
  <h1 class = "header" id="title1">Title 1</h1>

  <ul>
    <li>item 1</li>
    <li>item 2</li>
  </ul>

  <h2 class = "header" id="title2">Title 2</h1>
  <h3 class = "header" id="title3">Title 33</h1>
</body>
```
* Select all the Header tags in the page (h1-h6)  
* Select only the HTML element with 'Title 2' inside of it  
* Select the entire unordered list  
<hr>

With elements selected we can access the properties associated with them.

* For example, we can access the text within an HTML element with the `.text()` method from the jQuery library:

```html
<body>
    <p>para 1</p>
    <p>para 2</p>
    <p>para 3</p>
    <p>para 4</p>
    <p>para 5</p>

    <script type="text/javascript">
        var firstPara = $('p:first');

        console.log('Text Content: ' + firstPara.text()); //para 1
        firstPara.text('New Stuff');
        console.log('Text Content: ' + firstPara.text()); //New Stuff
    </script>

</body>
```

```bash
Text Content: para 1
Text Content: New Stuff
```

### Hands On
* Using the same HTML as the previous hands on example, select the header with text content 'Header 33' and change its value to 'Header 3'.



[Previous](traversingTheDom.md) | [Next](usingSelectedElements.md)
