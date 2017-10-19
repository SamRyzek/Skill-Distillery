function showPokemonDetail(event) {
  var pid = $(event.target).attr('poke_id');
  createDetailViewForPokemonById(pid);
}

function createDetailViewForPokemonById(pid) {
  getPokemonById(pid)
    .done(function(poke) {
      createDetailViewForPokemon(poke)
    })
}

function createDetailViewForPokemon(poke) {
  $('#content').empty();
  var img = $('<img>');
  img.attr('src', poke.img);
  img.attr('alt-text', poke.name + " image");
  $('#content').append(img);

  $('#content').append($('<div>').text(capitalize(poke.name)));
  $('#content').append($('<div>').text(poke.weight + "kg"));
  $('#content').append($('<div>').text(poke.height +  "m"));
  var ul = $('<ul>')
  poke.types.forEach(function(type) {
    ul.append($('<li>').text(capitalize(type.name)));
  })
  $('#content').append(ul);
  $('#content').append($('<p>').text(poke.description));
}
