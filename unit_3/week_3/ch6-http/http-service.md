# Using `$http` with Services

* It is common practice to expose methods which interact with a RESTful data layer through a service.

* Below is an example of how you could refactor the `pokemonService` from previous examples to use `$http`:

```js
angular.module('pokedex')
.factory('pokemonService', function($http) {
  var service = {};

  var BASE_URL = 'http://52.25.225.137:8080/pokemon/data/poke';

  service.index = function() {
    return $http({
      method : 'GET',
      url : BASE_URL + '?sorted=true'
    })
  };

  service.show = function(id) {
    return $http({
      method : 'GET',
      url : `${BASE_URL}/${id}`
    })
  }

  service.create = function(pokemon) {
    return $http({
      method : 'POST',
      url : BASE_URL,
      headers : {
        'Content-Type' : 'application/json'
      },
      data : pokemon
    })
  };

  service.update = function(id, pokemon) {
    return $http({
      method : 'PUT',
      url : `${BASE_URL}/${id}`,
      headers : {
        'Content-Type' : 'application/json'
      },
      data : pokemon
    })
  };

  service.destroy = function(id) {
    return $http({
      method : 'DELETE',
      url : `${BASE_URL}/${id}`
    })
  };

  return service;
})
```

#### [Prev](http-promise.md) | [Next](pokemon-lab.md)
