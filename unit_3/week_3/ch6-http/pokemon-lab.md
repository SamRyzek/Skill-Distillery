# Pokemon Lab
You are going to create a number of new files to display a table of pokemon.

The goal is to make a table which displays all of the pokemon, getting the data for the table from the `$http` service.

```bash
├── WEB-INF
│   └── web.xml
├── app
│   ├── appModule
│   │   ├── app.module.js
│   │   ├── pokeList.component.html
│   │   └── pokeList.component.js
│   │   ├── pokedex.module.js
│   │   └── pokemon.service.js
├── index.html
└── js
    ├── angular.min.js
    └── angular.min.js.map
```

1: Create a `pokemonService` in `pokemon.service.js`

* Source the 'pokemonService' in your index.html

* Your 'pokemonService' should have one method `index()` which asynchronously returns a sorted list of pokemon from the pokemon api.

```bash
http://52.25.225.137:8080/pokemon/data/poke
```

* ***NOTE***: This list will not be sorted, that is intentional, we are going to fix that with Angular later.

* see `http://52.25.225.137/` for additional api options.

3: Create a 'pokeList' component in `pokeList.component.js`

* Inject the pokemonService into the controller, and use the `index()` method to assign the returned pokemon list to a local controller property (like `vm.pokemons`).

* In the template, list the `pokeId` and `name` of each pokemon, use `ng-repeat` to dynamically create a div for each pokemon displaying the `pokeId` and the `name`. (***NOTE***: DO NOT use a table)

4: Add a form to the `pokeList.component.html` which can create a new pokemon.

* add a `create` method in the pokemon service which asynchronously creates a new pokemon with the API (similar to how you did this in the pokemon jQuery lab).

* Use the pokemon services `create` method in your `pokeList.component.js` make a function to create a new pokemon when the user clicks the button on the form (don't forget to us `ng-click` to assign that function to the form's submit button).

* In the `.then()` for the `create` method, be sure to update the list of pokemon (`vm.pokemons`).

#### [Prev](http-service.md) | [Next](rest-lab.md)

[show]:https://docs.angularjs.org/api/ng/directive/ngShow
[click]:https://docs.angularjs.org/api/ng/directive/ngClick
