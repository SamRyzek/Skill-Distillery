# Additional Functionality with `$location`

### [`$location`][location] Service

* The `$location` service parses the browsers URL and provides an interface for extracting information from it, and redirecting to other pages.

* The most common use for `$location` is redirecting to other angular routes (linking to other views).

  * Redirecting with `$location` uses the `$location.path()` method.

  * `.path()` is a getter that returns the current path.

  * `.path('/somepath')` is a setter that redirects to a new path.

* In order to use the `$location` service you need to inject it as a resource where you want to use it.

  * Example: 

    * ***note*** example assumes that the current path is `/todo`

```js
angular.module('myModule')
.component('navigation', {
  controller : function($location) {
    var vm = this;

    $location.path() // => '/todo'
    $location.path('/home') 
/*
  - asynchronously redirects to the '/home' route and loads the template for that view.
*/
  }
})
```

* This is particularly useful when paired with error handling with the `$http` service:

```js
angular.module('myModule')
.component('navigation', {
  controller : function($location, $http) {
    var vm = this;

    $http({
      url : '/todo/1',
      method : 'GET'
    })
    .then(function(res) {
      // success
    })
    .catch(function(err) {
      $location.path('/notfound')
    })
  }
})
```

### [`$routeParams`][route] Service

* `$routeParams` exposes the current routes parameters as an object.

* Must be injected where it will be used.

* Example output: `/todo/1`

```js
// in the route configuration :

$routeProvider
  .when('/todo/:id', {
    // config
  })
```

```js
// in a controller or service
console.log($routeParams)
/*
  {
    id : 1
  }
*/
```

* Example use : Extracting id for `$http` call:

```js
angular.module('myModule')
.component('example', {
  controller : function($routeParams, $http, $location) {
    var vm = this;

    vm.todo = {};

    $http({
      method : 'GET',
      url : '/todo/' + $routeParams.id
    })
    .then(function(res) {
      vm.todo = res.data;
    })
    .catch(function(err) {
      $location.path('/notfound')
    })
  },
  template : `
    <div>
      {{vm.todo.task}}
    </div>
  `
})
```

#### [Prev](config.md) | [Next](params.md)

[route]:https://docs.angularjs.org/api/ngRoute/service/$routeParams
[location]:https://docs.angularjs.org/api/ng/service/$location