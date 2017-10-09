## jQuery

### jQuery vs JavaScript
jQuery is not a replacement for javascript!! In order to be a successful front end programmer you need to have a strong foundation in javascript regardless of what frameworks or libraries you are using. jQuery itself is a library filled with convenience methods to simplify the process of manipulating HTML with code. It specializes in DOM traversal, manipulation, event handling, animation, and AJAX. Inside of any jQuery function you are still writing standard javascript.  

### Overview
jQuery is a widely adopted open source JavaScript library. It is lightweight, its size is comparable to a standard JPG image, and is getting faster with every release. It is surprising to learn that jQuery was first released in 2006! Ten years is a long lifespan in the software world.

jQuery is not magic by any means, it does a few important things exceptionally well. At its most basic level, it makes writing JavaScript easier. In standard JS we may see some code as follows:

With javascript:
```javascript
// Select the body
var body = document.querySelector("body");

// Create a div
var div = document.createElement("div");

// Place "Hello World!" inside the new div
div.innerHTML = "Hello World!";

// Add the div to the body
body.appendChild(div);

var bigHello = document.createElement("h1");
bigHello.innerHTML = "Hello World!";
body.appendChild(bigHello);
```

We can simplify this code into a few lines using jQuery:

```javascript
var $div = $('<div>Hello World</div>');
var $bigHello = $('<h1>Hello World</h1>');

$('body').append($div, $bigHello);
```

Don't worry about the syntax for now, we will get into that soon. This simplification of code can save us a lot of time, but is not the only advantage of using jQuery. The library excels at:
* Traversing the DOM
* Manipulating its Elements
* Executing and simplifying AJAX requests

These are all fundamental functionalities to writing quality front end JS code.

### Resources
[jQuery API][jQueryAPI]  
[jQuery Download][jQueryDownload]  


[Previous](README.md) | [Next](jQuerybasics.md)

[jQueryDownload]:https://jquery.com/download/
[jQueryAPI]:http://api.jquery.com/
