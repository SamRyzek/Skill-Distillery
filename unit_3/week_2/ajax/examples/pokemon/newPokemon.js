function createPokemonButton() {
  var button = $('<button>');
  button.text('Create New Pokemon');
  button.on('click', function(e) {
    $('#content').empty();
    $('#newForm').show();

    $('#newForm input[type="submit"]').on('click', function(e) {
      e.preventDefault();
      var pokemon = {};
      var form = $('#newForm').children().first()[0];
      pokemon.pokeId = form.pokeId.value
      pokemon.name = form.pokeName.value
      pokemon.height = form.height.value
      pokemon.weight = form.weight.value
      pokemon.description = form.description.value
      pokemon.img = form.img.value

      create(pokemon)
        .done(function(poke) {
          // empty form
          $('#newForm input[type="text"]').val("");
          $('#newForm textarea').val("");
          // hide form
          $('#newForm').hide();
          createDetailViewForPokemon(poke);
        })
        .fail(console.error)
    })
  })
  button.insertAfter($('#btn'));
}
