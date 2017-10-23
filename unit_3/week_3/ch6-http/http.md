# [`$http` Service][http]

* The `$http` service is a core service included in Angular.

* `$http` exposes the ability to make asynchronous requests fro resources of HTTP through the browsers `XMLHttpRequest` object.

* You gain access to the service through dependency injection just like with services you create.

* Conventionally, you will create *services* which use `$http` to interact with RESTful APIs.

### Creating [`$http`][http] Requests

* `$http` is very similar to jQuery's `$.ajax`

* It is a function which is invoked with a configuration object.

  * The object has at a minimum a `method` and a `url` property:

    * `method` : 'GET', 'PUT', 'POST', 'DELETE' etc

    * `url` : the destination url as a string

##### 'GET'

```js
$http({
  method : 'GET',
  url : 'rest/products'
});
```

##### 'PUT', 'POST'

* When sending data, you will need to set a `Content-Type` in the `headers` property as well as include a `data` property.

```js
var pokemon = {
  pokeId : 1,
  name : 'bulbasaur'
}

$http({
  method : 'PUT',
  url : 'rest/pokemons/' + pokemon.pokeId,
  headers : {
    'Content-Type' : 'application/json'
  },
  data : pokemon
})
```

### Using the [`$http`][http] service

* Inject `$http` into the resource where it will be used.

```js
angular.module('pokedex')
.factory('pokemonService', function($http){})
```

* `$http` returns a [*`Promise`*](promise.md)

#### [Prev](README.md) | [Next](http-promise.md)

[http]:https://docs.angularjs.org/api/ng/service/$http