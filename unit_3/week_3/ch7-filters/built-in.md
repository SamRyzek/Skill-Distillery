# Built In [Filters][filter]
* Angular *filters* modify, sort, or otherwise modify inputs.

* Common tasks like currency conversion and date formatting have *filters* built into Angular's API.

* Angular filters are applied to values (either variables or literals) by name following a *pipe* (`|`) character.

* Built in *filters* include:

### [`currency`][currency]

* Formats a number as currency, includes a currency symbol (default : `$`), and 2 decimal point precision:

```html
<div>{{12.5689898 | currency}}</div>
```

<hr>
<div>$12.57</div>
<hr>

### [`number`][number]

* Adds commas and decimal precision to a number

```html
<div>{{157878.89899999 | number:2}}</div>
```

<hr>
<div>157,878.90</div>
<hr>

### [`date`][date]

* Formats a date to a string based on provided configuration

```html
<div>{{1288323623006 | date:'MM/dd/yyyy'}}</div>
```

<hr>
<div>10/28/2010</div>
<hr>

### [`lowercase`][lowercase]

* Converts a string to lowercase

```html
<div>{{'BANANA' | lowercase}}</div>
```

<hr>
<div>banana</div>
<hr>

### [`uppercase`][uppercase]

* Converts a string to uppercase

```html
<div>{{'banana' | uppercase}}</div>
```

<hr>
<div>BANANA</div>
<hr>

### [`orderBy`][orderBy]

* Used in conjuction with `ng-repeat` to sort a collection of values.

```js
// assume pokemons looks like this

vm.pokemons = [
  {
    pokeId : 1,
    name : 'bulbasaur'
  },
  {
    pokeId : 78,
    name : 'abra'
  },
  {
    pokeId : 7,
    name : 'charmander'
  },
]
```

```html
<div ng-repeat="poke in vm.pokemons | orderBy:'name'">
  {{poke.name}}
</div>
```

<hr>
<div>
  abra
</div>
<div>
  bulbasaur
</div>
<div>
  charmander
</div>
<hr>


### Hands On

* You are going to modify the existing code from the Pokemon Lab in the previous chapter.

1: Modify `pokemon.service.js`, remove the query parameter to sort the pokemon in the `index()` method.

2: In `pokeList.component.html` modify your `ng-repeat` and add an `orderBy` filter to order the pokemon by their `pokeId`

* It is working when they are sorted correctly again.

3: Use the number filter to add a single point of decimal precision to the `height` and `weight`


#### [Prev](README.md) | [Next](custom.md)

[filter]:https://docs.angularjs.org/guide/filter

[filter]:https://docs.angularjs.org/api/ng/filter/filter
[currency]:https://docs.angularjs.org/api/ng/filter/currency
[number]:https://docs.angularjs.org/api/ng/filter/number
[date]:https://docs.angularjs.org/api/ng/filter/date
[json]:https://docs.angularjs.org/api/ng/filter/json
[lowercase]:https://docs.angularjs.org/api/ng/filter/lowercase
[uppercase]:https://docs.angularjs.org/api/ng/filter/uppercase
[orderBy]:https://docs.angularjs.org/api/ng/filter/orderBy
