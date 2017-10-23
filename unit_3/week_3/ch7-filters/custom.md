# Custom [Filters][filter]
* If none of the default filters are precise enough to return the subset, or modification of data required, you can create your own.

* Creating a filter is similar to creating a Service. Use the `Module.filter(string, function(){})`method.

  * The first (`string`) argument is the filters name

  * The second argument is the constructor function

* You will create a function which will be returned by the filter and applied to the value on the left side of the *pipe* (`|`).

  * The value to which the filter is applied will be provided as the first argument to the filter.

### Filter to Modify/Format Example

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

```html
<div>{{'blastoise' | capitalize}}</div>
```

<hr>
<div>Blastoise</div>
<hr>

### List Filter Example

```js
angular.module('pokedex')
.filter('evenIdFilter', function(){
  // 1
  return function(pokemons) {
    var results = [];
    pokemons.forEach(function(poke) {
      if (poke.pokeId % 2 == 0) {
        results.push(poke);
      }
    });
    return results;
  }
});
```

```html
<div ng-repeat="pokemon in vm.pokemons | evenIdFilter">
  {{pokemon.name}}
</div>
```

<hr>
  <div>ivysaur</div>
  <div>squirtle</div>
  <div>blastoise</div>
<hr>

### List Filter with Arguments Example

* It is also possible to provide additional arguments to the filter's function. Additional arguments are provided *colon* (`:`) seperated:

```js
angular.module('pokedex')
.filter('idRangeFilter', function(){
  // 1
  return function(pokemons, start, end) {
    var results = [];
    pokemons.forEach(function(poke) {
      if (poke.pokeId >= start && poke.pokeId <= end) {
        results.push(poke);
      }
    });
    return results;
  }
})
```

```html
<div ng-repeat="pokemon in vm.pokemons | idRangeFilter:7:9">
  {{pokemon.name}}
</div>
```

<hr>
<div>charmander</div>
<div>charmeleon</div>
<div>charizard</div>
<hr>

### Applying Multiple Filters Example
* The return value from a filter is the modified value

  * For lists, this is usually a list of reduced size, or sorted.

  * For individual values, this is the modified value.

* Filters are more powerful when combined:

```html
<div ng-repeat="pokemon in vm.pokemons | evenIdFilter | idRangeFilter:6:9">
  {{pokemon.name | capitalize}}
</div>
```

<hr>
<div>Blastoise</div>
<div>Charmeleon</div>
<hr>

### Hands On

You are going to modify your pokemon application to create a custom filter that filters by type.

1: In the 'pokedex' directory, create a `pokeType` filter in a file named `pokeType.filter.js`

This filter should modify a list of pokemon and return a sublist of those pokemon who possess the type specified as an argument (a string).

If the type provided as the argument is the string `'all'`, return the entire array of values.

2: Apply the filter before the `orderBy` to your list of pokemon in `pokeList.component.html`. For testing purposes, provide it the argument `'poison'`.

3: Once your filter is working, you should see a subset of the array of data.

This is cool, but we can make it much cooler...

We are going to modify the display to show a list of types. When the user clicks on one of those types, it will be used to filter the list dynamically.

4: In `pokeList.component.js`, add the following array:

```js
vm.types = [
  'all',
  'normal',
  'poison',
  'water',
  'fighting',
  'fire',
  'bug',
  'flying',
  'electric',
  'ground',
  'rock',
  'psychic',
  'ghost',
  'dragon'
];
```

* This is an array of each of the types of pokemon as strings.

5: In `pokeList.component.html` use an `ng-repeat` to display each of these types. If you want them all to appear on one line, I would recommend using a `<span>`.

6: Now we need to create a variable to hold the selected type and initialize it to `'all'` (because that will be the entire list).

* Create a property on the `vm` to hold the selected type and initialize it with the value `'all'`

7: Now, we need to assign a click event to each of the types. Use `ng-click` and in the assigned expression, set the selected type to the one that was clicked on.

8: Last but not least, where you are applying your pokeType filter, replace the `'poison'` argument with your selected type property on the vm.

9: Refresh the browser and click on some of the types, you should see the list of displayed pokemon dynamically change based on the type you clicked on.


#### [Prev](built-in.md) | [Next](filters-js.md)

[filter]:https://docs.angularjs.org/guide/filter
