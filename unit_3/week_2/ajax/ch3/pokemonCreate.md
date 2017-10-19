### Pokemon Create  

**We all share one data source, please do not add anything inappropriate**  

1: Open the files from the previous Pokedex lab.  

2: Create a form where the user can type in information to create a new Pokemon. Include fields for:
* pokedex id
* name
* ht
* wt
* img
* description

3: Tie an event listener to the submit button that extracts the users input, and sends it in a `POST` request to the server to `http://52.25.225.137:8080/pokemon/data/poke`.  

* Don't forget to prevent default behavior on form submission.  

4: In the `.done()` function of your AJAX request call a function that rebuilds the table with the updated info.  

[Previous](ajax_delete.md) | [Next](pokemonDelete.md)
