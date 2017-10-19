## AJAX

### Overview
jQuery also gives us a utility that simplifies asynchronous XMLHttpRequest, the `.ajax` function. There are too many settings associated with this method to discuss them all, so we are going to focus on a few of the major ones.

The `.ajax()` function allows us to specify details about our request in a concise, object based format. It also allows us to execute actions based on the success or failure of the request.

Ajax allows us to asynchronously send request to a server and used the returned data in the browser. The callback function specified in our ajax request is automatically injected with the data returned from the server. From there we can manipulate it and display it to the user as we see fit.

### Creating an AJAX call
To make an ajax call we call the `.ajax()` method on the jQuery namespace.

```javascript
$.ajax();
```
Inside of this method call we can specify settings, which is a collection of key/value pairs that allow you to customize the configuration object of your request.

* type: specifies the type of the HTTP Request (GET, PUT, POST, DELETE)
* url: sets which url to hit when executing the ajax request
* data: add data to the request body
* dataType: sets what data you expect to be returned from the server
* contentType: what type of data you are sending in the body of a request

Below is an example of an ajax GET request:  
```javascript
$.ajax({
    type: "GET",
    url: "api/employee",
    dataType: "json",
});
```
* A complete list of what we can configure with an ajax call can be found [here][ajaxSettings].

[Previous](README.md) | [Next](ajax_response.md)

[ajaxSettings]:http://api.jquery.com/jQuery.ajax/#jQuery-ajax-settings
