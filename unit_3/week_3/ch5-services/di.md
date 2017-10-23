# Dependency Injection

* Services act as the single source of truth, for model data and shared functionality.

* Services assist in keeping Angular applications DRY and encapsulating data and functionality.

* It is necessary to inject a service in the location where it will be used explicitly.

### Injecting Services

* Angular registers services by name to the Module. 

* When you want to use a service, you simply need to provide it by name as a parameter to the Component's controller function where you want to use it.

* ***NOTE***: Services can also be injected into other services, and filters (*which we haven't discussed yet*)

* Example:

* here is the service we created in the previous step:

```js
// pokemon.service.js
angular.module('pokedex')
.factory('pokemonService', function() {
  var service = {};

  // private
  var pokemons = [
    {
      pokeId : 1,
      name : 'bulbasaur'
    },
    // etc
  ];

  // public
  service.index = function() {
    return pokemons;
  };

  service.create = function(pokemon) {
    pokemons.push(pokemon);
  };

  return service;
})
```

* Now we can inject it into a component's controller by name and use it's functionality:

```js
angular.module('pokedex')
  .component('pokemonComponent', {
  templateUrl : 'app/pokedex/pokemon/pokemon.component.html',

  // 1
  controller : function(pokemonService) {
    var vm = this;

    // 2
    vm.pokemons = [];

    // 3
    vm.pokemons = pokemonService.index();

    // 4
    vm.addPokemon = function(poke) {
      // vm.pokemons.push(poke);
      pokemonService.create(poke);
      vm.pokemons = pokemonService.index();
    };
  },
  controllerAs : 'vm'
})
```

1: inject the service into the controller by name. - angular will take the returned object and place it in that parameters position as an argument, making the service's functionality accessible.

2: initialize the `vm.pokemons` to an empty array (***NOTE*** at the moment this isn't entirely necessary, but will be when we start getting data aynchronously)

3: assign the `vm.pokemons` array the list of pokemon from the service.

4: modify the local `vm.addPokemon` method to update the service's list of pokemon (the service is the single source of truth), and then update the local list (***NOTE*** again...this isn't necessary at the moment...but it will be).

### Hands On
1: Inject the `productService` into your `productList` component's controller.

2: Assign the component's list of products the list from the service.

3: Update the `addProduct` method to use the services `create` method.

#### [Prev](services.md) | [Next](lab.md)
