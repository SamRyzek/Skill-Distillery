## jQuery Hello World

0: Download the jQuery library from the jQuery website or link to the CDN.  
1: Create an HTML document with a basic skeleton and include the jQuery library via a script tag.  
```html
<script src="jquery-2.2.3.min.js">
</script>
```
or
```html
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js">
</script>
```
2: Add a div to the body of the document and give it an id property.  
```html
...
<body>
    <div id="helloWorld">
    </div>
</body>
```
3: Write a script that used a selector to target the div you created by id.  
```javascript
<script>
  $('#helloWorld')
</script>
```
4: Check the docs for a method that allows you to set the contents of an element. **Hint: .text()**  
5: Set the content of the div you created to 'Hello World'.
```javascript
<script>
  $('#helloWorld').text('Hello World');
</script>
```
6: Move your code between the `<script>` tags to its own file. Include this file in your HTML by using
```html
<script src="myscripts.js"></script>
```

[jQuery API Docs][jQDocs]  


[Previous](jQuerybasics.md) | [Next](../ch3/README.md)


[jQDocs]:http://api.jquery.com/
