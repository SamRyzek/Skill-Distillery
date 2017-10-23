# Angular [Services][serv]

* Services are used to encapsulate fucntionality that you want to reuse in an application, or share model data between unrelated components.

* Services fall into one of two camps, either they are being used for networking, security or logging (in which case they are somewhat analogous to models), or they don't and they simply provide some utility/helper functions.

* In the most abstract way, services can be thought of as self contained, relatively well encapsulated classes which perform specific roles that don't quite fit in controllers because they don't respond to user interactions.

### Creating a [Service][serv]

* Services are created with the `factory(string, function(){})` constructor method.

  * This constructor registers a returned function closure to a namespace (the string provided), and makes it available throughout the app.

  * We can use the revealing module pattern to expose a public interface to an otherwise well encapsulated closure.

* Example:

```js
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

* In the preceding example, only the properties attached to the returned object (`service`) will be accessible. The `pokemons` variable is not assigned as a property of the object and will remain inaccessible within the closure.

### Hands On

We are going to move the product array into a service so that it is available anywhere we might need it (instead of trapped within the scope of productList and it's children).

1: Create a `product.service.js` file in `app/appModule`:

```bash
├── WEB-INF
│   └── web.xml
├── app
│   └── appModule
│       ├── app.module.js
│       ├── newProduct.component.html
│       ├── newProduct.component.js
│       ├── product.service.js
│       ├── productCard.component.html
│       ├── productCard.component.js
│       ├── productList.component.html
│       └── productList.component.js
├── index.html
└── js
    ├── angular.min.js
    └── angular.min.js.map
```

2: Create a service in the `product.service.js` file named `productService`.

Source the `product.service.js` in your index.html.

3: Remove the list of products from `productList.component.js` and assign it to a private variable (e.g. `var products`) in the service. (for now, for testing purposes, assign your list variable in the component's controller to an empty array)

4: Create a public `index` and `create` method.

5: Given that your product list now has an empty array, you shouldn't see any products display...albeit you also shouldn't have any errors.

#### [Prev](README.md) | [Next](di.md)

[serv]:https://docs.angularjs.org/guide/services
