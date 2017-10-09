## jQuery Basics

### Getting started with jQuery
There are two ways to gain access to the jQuery library. The first is to link to the CDN (content delivery network) in your document.

```html
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
```

The second is to download jQuery [here][jQueryDownload]. Download jQuery 1.x if you need support for IE6-8. If not download the jQuery 3.x, this is a slimmed down version of the library. Download and save the jquery.min file locally. You can then path to it in your ``<script src="">`` tag to include it in your document.

```html
<script src="jquery-3.1.1.min.js">
</script>
```

Now that the library is included in your document, you can begin using it in your scripts.

### The global jQuery function
jQuery is accessed via the global jQuery function. This function can be accessed using ``jQuery`` but has been aliased to ``$`` for your convenience. This is called "bling" notation. Basic syntax of a jQuery call is:

```javascript
$('body').hide();
```
Here ``$`` is the call to the global jQuery function, ``('body')`` is the selector, and ``.hide()`` is the action.

[Previous](overview.md) | [Next](helloWorld.md)


[jQueryDownload]:http://jquery.com/download/
