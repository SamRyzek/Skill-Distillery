# Using Filters in JS

* Both built-in filters, as well as the custom filters you create can be used in your components and services as well as in the template.

### `$filter` service

* The `$filter` service can be injected into services and controllers and used to expose the functionality of a filter.

* The `$filter('filterName')` method retrieves the returned function of a filter.

  * Example, consider this filter:

```js
angular.module('pokedex')
.filter('capitalize', function() {
  return function(str) {
    var result = "";
    result += str.split("").splice(0,1)[0].toUpperCase();
    result += str.split("").splice(1).join("");
    return result;
  }
})
```

  * to use this filter in a component controller:

    * inject the `$filter` service into the controller function, and retrieve the filter by name:

```js
angular.module('myModule')
.component('rolladex', {
  controller : function($filter) {
    var vm = this;

    var doCapitalize =  $filter('capitalize');
    /*
    Essentially...

    var doCapitalize = function(str) {
      var result = "";
      result += str.split("").splice(0,1)[0].toUpperCase();
      result += str.split("").splice(1).join("");
      return result;
    }
    */
  }
})
```

  * The variable 'doCapitalize' now holds the returned function from the service.

  * Now you can invoke the returned function and pass it arguments.

```js
angular.module('myModule')
.component('rolladex', {
  controller : function($filter) {
    var vm = this;

    var doCapitalize =  $filter('capitalize');

    var morty = doCapitalize('morty'); // => 'Morty'
    var matt = doCapitalize('Matt'); // => 'Matt'


  }
})
```

* An easy shorthand for the above, is to immediately invoke the returned function with arguments instead of storing a reference to it in a variable:


```js
angular.module('myModule')
.component('rolladex', {
  controller : function($filter) {
    var vm = this;

    var morty =  $filter('capitalize')('morty'); // => 'Morty'

  }
})
```

#### [Prev](custom.md) | [Next](ng-class.md)
