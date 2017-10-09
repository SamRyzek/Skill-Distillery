## Listening For Events
* Event Listeners are methods registered on specific targets. The target of an event listener could be an HTML element, the Document object, or the Window object itself.

* The method `target.on(type, callback)` registers the event listener (`type`) onto the target, when the event is observed on the target, it triggers the `callback` (or `listener`), which is usually a function:

```javascript
// Print loaded to console when the window object loads
$('#myDiv').on('click', function(e){
	console.log('clicked');
});
```

* Instead of using an anonymous function (as above), you can use a named function for the listener above.

```javascript
var confirmWindowLoad = function(e) {
	console.log('clicked');
};

$('#myDiv').on('click', confirmWindowLoad);
```

* jQuery has also aliased all of their events directly into callable functions. Setting up other event listeners is just as easy,
```javascript
$(selector).event(function(){});
```
or for a click event

```javascript
$('#myDiv').click(function(){});
```

When the event is triggered the code inside the callback function is executed. For example if we wanted to hide a div with id ``#myDiv`` on click we could write:

  ```javascript
    $('#myDiv').click(function(e){
      $(this).hide();
    });
  ```

### Making sure the DOM has been rendered
Trying to access an element before the DOM has fully loaded can cause issues in your code. jQuery gives us a method that ensures the document has been fully loaded before trying to execute scripts. JS has a native function, `Window.onload()`, which does something similar. The difference is that onload waits for everything included in the HTML to be loaded, (scripts, css, images), where `$(document).ready()` only waits for the DOM hierarchy to be completed.

This function is an event listener, listening for a 'load' event. When the browser fully loads the DOM it triggers an onload event by default. jQuery gives us the `.ready()` method, which listens for this event.

The method ``$(document).ready()`` takes a callback function as an argument that executes when the `ready` event is triggered.

```javascript
$(document).ready(function(){
  // do stuff
});
```

### Hands On
* Create two documents called index.html and test.js
* Create a basic HTML structure in the index file and link to the test.js file
* In your .js file write an event listener that notifies you when the document has loaded.


[Previous](README.md) | [Next](usingEventListeners.md)
