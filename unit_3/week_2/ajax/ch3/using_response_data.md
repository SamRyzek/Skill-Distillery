## Using response data

* Once you are getting a successful response and logging the data you need to start thinking about what you want to do with that data.  

* Most of the time you are going to be dynamically building and appending DOM elements so you can display the data to a user.  

* Due to the fact that we are writing asynchronous code, we do not know when the response from the server will return. When it does return we only have access to the response data inside of the `.done()` function.  

* We can pass the data to other functions in our program, but they must be called from within `.done()`


#### Example
* Assume the data we receive from the server looks like this:
```json
[
  {
    "name" : "Andrew",
    "age" : 26
  },
  {
    "name" : "Kris",
    "age" : 29
  },
  {
    "name" : "Cole",
    "age" : 32
  }
]
```

* We could display the names to the DOM by using the jQuery dom manipulation tools we discussed earlier.

```javascript
$.ajax({
  type: "GET",
  url: "rest/employees",
  dataType: "json"
})
.done(function( data, status ) {
  buildDOM(data);
});

function buildDOM(data){
  data.forEach(function(element){
    var $h1 = $('<h1>');
    $h1.text(element.name);
    $("body").append($h1);
  });
}
```

#### Hands On:
1: Open the files ajaxTest.html and app.js from the previous hands on.  
2: Add code to your `.done()` function to append the first and last names of the returned objects to the dom.  
3: The output should look like this.  

```
Aaron Aaronson

Bob Bobbers

Cindy Cinders
```

[Previous](ajax_response.md) | [Next](lab.md)
