## Accessing response data

When a jQuery AJAX request is encountered in code, it will automatically be sent. The servers response, successful or otherwise, is returned to either the done or fail functions respectively.  

```javascript
.done(function(data, status){ /*code here*/ })
```
```javascript
.fail(function(xhr, status, error){ /*code here*/ })
```

##### .done()
The done method is executed if the request to the server is successful.

* A `data` variable is injected into the function arguments and is assigned the chunk of data returned from the server.

* The text status associated with the response is also assigned to a variable.

* The xhr object structured by jQuery is also injected into the method.   

##### .fail()
The fail method is executed if the request to the server is unsuccessful.

* The xhr object structured by jQuery is injected into the method.   

* The text status code associated with the response is also assigned to a variable.

* The error message returned to the server is also injected as a variable.  

### Chaining methods
To utilize these methods we can chain methods to our ajax call.

```javascript
$.ajax({
    type: "GET",
    url: "rest/employees",
    dataType: "json",
})
.done(function(data, status){
  console.log('It worked');
  console.log(data);
})
.fail(function(xhr, status, error){
    console.log('It blew up');
    console.log(error);
});
```

### Calling methods on the returned XHR object

The ajax method returns a jqXHR object. This object can be assigned to a variable which you can subsequently call methods on.  

```javascript
var myReq = $.ajax({
  type: "GET",
  url: "rest/employees",
  dataType: "json"
});

myReq.done(function( data, status ) {
  console.log('This is what was returned ' + data);
});

myReq.fail(function(xhr, status, error) {
  console.log('It blew up again');
});
```

#### Hands On:  
1: Create files ajaxTest.html and app.js.  
2: Source your js file into your HTML file.  
3: We are going to be using the jQuery library so we need to include it into the HTML file.  
4: In your app.js file, write an ajax `GET` request to `https://kkane106.github.io/data.json'`, the same data we accessed via traditional XHR.  
5: Write `.done()` and `.fail()` methods to print out the data if the request is successful or a error message if the request fails.  

[Previous](ajax.md) | [Next](using_response_data.md)
