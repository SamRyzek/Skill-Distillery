# `$http` Promise Returns
* a [*`Promise`*] is an object which can be returned from an asynchronous operation and assigned a chain of callback functions to execute upon the operation's completion.

* The two exposed methods are:

  * `.then(function(response){})`

    * The callback function provided to `.then()` will be invoked if the request receives a response in the success range ( < 400).

  * `.catch(function(error){})`

    * The callback function provided to `.catch()` will be invoked if the request receives a response in the error range (400 +).

### Response object
* The response object returned asynchronously from an `$http` method has the following properties:
  
  * `data` -> {} or String
    * an object containing the response
    * what you will use most of the time
  * `status` -> Number
    * the numerical status code of the response
  * `statusText` -> String
    * the status text associated with the status code

### Examples

* Making an asynchronous request and attaching a handler with `.then()`

```js
angular.module('pokemonCard', {
  controller : function($http) {
    var vm = this;
    
    // 1
    vm.pokemons = [];

    // 2
    $http({
      method : 'GET',
      url : 'data/poke?sorted=true'
    })
    // 3
    .then(function(response) {
      vm.pokemons = response.data;
    });
  }
});
```

1: Create an initial value for `vm.pokemons`.

  * If the template loads and an `undefined` value is passed to `ng-repeat` it will throw an exception and break.

2: Make an asynchronous request, which will return a promise...and eventually return data.

3: When the data is returned and passed to the callback function as `response`, assign the `data` property to a controller property (`vm.pokemons`).

* Making an asynchronous request and assigning the returned promise to a variable:

```js
angular.module('pokemonCard', {
  controller : function($http) {
    var vm = this;
    
    vm.pokemons = [];

    // 1
    var $q = $http({
      method : 'GET',
      url : 'data/poke?sorted=true'
    });

    $q.then(function(response) {
      vm.pokemons = response.data;
    });
    
  }
});
```

1: explicitly assign the returned promise to a variable (`$q`)

* Making a function which returns the promise from a `$http` request:

```js
angular.module('pokemonCard', {
  controller : function($http) {
    var vm = this;
    
    vm.pokemons = [];

    // 1
    var loadData = function() {
      return $http({
        method : 'GET',
        url : 'data/poke?sorted=true'
      });
    }

    // 2
    loadData().then(function(response) {
      vm.pokemons = response.data;
    });
  }
});
```

1: Create a function which returns the *Promise* returned from the `$http` method.

2: Invoke the function (thus invoking the `$http`), and then chain a callback off of the returned *Promise* object.

#### [Prev](http.md) | [Next](http-service.md)

