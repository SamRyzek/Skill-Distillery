### Pokemon Delete  

**DO NOT DELETE POKEMON 1-151. This lab involves deleting resources from our pokemon API. We all share one data source. Please delete elements that you add to the list yourself.**

1: Open the files from the previous Pokedex labs.  

2: Now that we can add Pokemon via ajax lets implement delete functionality.  

3: In your code that dynamically builds the table, add an extra column that has a delete button next to every Pokemon.  

4: Assign an event listener to the button that fires an ajax `DELETE` to `http://52.25.225.137:8080/pokemon/data/poke/{id}` which deletes a Pokemon by its id.  

**Hint: you can embed the id of a Pokemon as a property of the delete button as you create them**

```html
<button name="1">Delete</button>
```

[Previous](pokemonCreate.md) | [Next](example_requests.md)
