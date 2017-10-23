# Promise Primer
* JavaScript possesses an asynchronous object aptly named a *Promise*.
  
* *Promises* can be used to provide a return value to asynchronous functions.
  
* The returned promise from an asynchronous function will wait for the designated change in state and then fulfill a callback function.
  
*Promises* are useful in mitigating 'callback hell', and provide a simplified syntax for dealing with asynchrony.
  
* We will be using *Promises* built into Angular's `$http` service, and won't need to create our own, the following examples exist to illustrate what is happening behind the scenes and how you could use promises on your own.
  
### Use
* A *Promise* is a JavaScript object, the first step in using a Promise, is creating a new one.
  
  * ALL Promises are created using the `new` keyword and are provided a single function as an argument.
  
```js
new Promise(function(resolve,reject) {
  // Asynchronous operation...
})
```
  
* The provided function will be passed to arguments which are aliased above as `resolve` and `reject`.
  
  * `resolve` - this is a function, invoking it with an argument will produce a successful return, and will provide a success callback with whatever value is passed to it.  
  * `reject` - this is also a function, invoking it will pass an error callback a value.
  
* In the following example, we wrap an `XMLHttpRequest` with a promise, and store the Promise object in a variable (`p`):
  
```js
var p = new Promise(function(resolve,reject) {
  var xhr = new XMLHttpRequest();
  
  xhr.open('GET', 'http://someurl.com');
  
  xhr.onreadystatechange = function() {
    if (xhr.status < 400 && xhr.readyState === 4) {
      resolve(xhr.response)
    }
    if (xhr.status >= 400 && xhr.readyState === 4) {
      reject(xhr.response)
    }
  };

  xhr.send();
});
```
  
* Now, if the `XMLHttpRequest` completes successfully it will pass the response to `resolve`, if it errors, it will pass the response to `reject`.
  
* What makes this useful is that the Promise is stored in a variable `p`. We don't need to nest callback after callback inside of the `onreadystatechange`, instead we can chain provided `then` and `catch` callback functions off of the Promise.
  
```js
var p = new Promise(function(resolve,reject) {
  var xhr = new XMLHttpRequest();
  
  xhr.open('GET', 'http://someurl.com');
  
  xhr.onreadystatechange = function() {
    if (xhr.status < 400 && xhr.readyState === 4) {
      resolve(xhr.response)
    }
    if (xhr.status >= 400 && xhr.readyState === 4) {
      reject(xhr.response)
    }
  };

  xhr.send();
});

// success handler
p.then(function(response) {
  console.log(response);
  // do something with data
});

// error handler
p.catch(function(err) {
  console.error(err);
  // handle error
});
```
  
* Obviously this is extremely useful as it reduces the likelihood of deeply nested callbacks and the difficulty of maintaining deeply nested code.
  
### Chaining callbacks
* It is possible to chain multiple `.then()` handlers.
  
```js
var p = new Promise(function(resolve,reject) {
  var xhr = new XMLHttpRequest();
  
  xhr.open('GET', 'http://someurl.com');
  
  xhr.onreadystatechange = function() {
    if (xhr.status < 400 && xhr.readyState === 4) {
      resolve(xhr.response)
    }
    if (xhr.status >= 400 && xhr.readyState === 4) {
      reject(xhr.response)
    }
  };

  xhr.send();
});

// success handler
p.then(function(response) {
  console.log(response);

  return response; 
  // return the data from the function to use in the 
  // next callback
})
.then(function(response) {
  // do some other cool thing
});
```
  
### Returning Promises from Methods
* Obviously, if you can store a Promise in a variable, you can return it from a function:
  
```js
var getData = function() {
  return new Promise(function(resolve,reject) {
    var xhr = new XMLHttpRequest();
    
    xhr.open('GET', 'http://someurl.com');
    
    xhr.onreadystatechange = function() {
      if (xhr.status < 400 && xhr.readyState === 4) {
        resolve(xhr.response)
      }
      if (xhr.status >= 400 && xhr.readyState === 4) {
        reject(xhr.response)
      }
    };

    xhr.send();
  });
};

getData()
  .then(function(res) {
    // do stuff!
  })
```
  
* As you will see in Angular, you could make a dynamic, reusable function for Asynchronous calls:
  
```js
var myAwesomeHttp = function(config) {
  return new Promise(function(resolve,reject) {
    var xhr = new XMLHttpRequest();
    
    xhr.open(config.method, config.url);

    if (config.headers) {
      for (var h in headers) {
        xhr.setRequestHeader(h, headers[h]);
      }
    }
    
    xhr.onreadystatechange = function() {
      if (xhr.status < 400 && xhr.readyState === 4) {
        var response = {};
        try {
          response.data = JSON.parse(xhr.responseText);
        } catch (e) {
          response.data = xhr.responseText;
        }
        response.status = xhr.status;
        response.type = xhr.responseType;
        resolve(response);
      }
      if (xhr.status >= 400 && xhr.readyState === 4) {
        var error = {};
        error.status = xhr.status;
        error.message = xhr.responseText;
        reject(error);
      }
    };

    if (config.data) {
      config.data = JSON.stringify(config.data);
    } else {
      config.data = null;
    }

    xhr.send(config.data);
  });
};

var myData = {
  fname : 'Andrew',
  lname : 'Conlin'
};

var createdUserPromise = myAwesomeHttp({
  method : 'POST',
  url : 'http://some-cool-url.com',
  headers : {
    'Content-Type' : 'application/json'
  },
  data : myData
});

createdUserPromise
  .then(function(res) {
    authenticationService.login();
    return res;
  })
  .then(function(res) {
    $location.path(`/user/${res.data.id}`);
  })
  .catch(function(err) {
    if (err.status === 404) {
      return $location.path('/_404');
    }
    if (err.status > 500) {
      return $location.path('/error');
    }
  });
```
  
* The above `myAwesomeHttp` function is very similar to Angular's `$http` service, hopefully, seeing how you could build it is useful in understanding the service.