### AJAX convenience methods
jQuery has also added some methods that further simplify ajax requests. Methods for GET and POST HTTP request have been added to the library. These can be used when you don't need to be as verbose with your request.

```javascript
$.get(url[, data][, callback][, type])
$.post(url[, data][, callback][, type])
$.getJSON(url[, data][, callback])
```

These methods take similar parameters:
* **url**: The URL to hit with a request
* **data**: Any additional information that we need to send as part of a request to the server.
* **callback**: The function to be called when data is returned
* **type**: what type of data to expect in the response.

Similarly there are shorthand methods like `$.getJSON()`. This is equivalent of an ajax call where we set the `dataType: json`. These convenience methods operate in the same manor as a standard ajax call, but with some settings taking default values specific to that method.

### load
We can also use the ajax process to load HTML partials. jQuery includes a function called `$.load()` that will load HTML from a file in the same project. This way you can have HTML templates for forms, headers, footers...

The function takes the following arguments:
```js
 $('#content').load('partials.html #form', function(){});
```
* `$('#content')` : is the location where you want the partial to load.
*  `'partials.html #form'` : is what information you want to load into your current document. In this case `partials.html` is the file you want to access and `#form` is an additional selector that we can choose to add.
* `function(){}` : is the success callback function.

[Previous](example_requests.md) | [Next](../ch4/README.md)
