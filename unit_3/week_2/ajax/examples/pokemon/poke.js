$(document).ready(main);

function main() {
  loadPokeTable();
  createPokemonButton();
}

function createRefreshButton() {
  $('#btn').on('click', function(e){
    e.preventDefault();
    loadPokemon()
    .done(function(pocketMonsters){
      $('#content').empty();
      $('#content').append(
        $('<div>').text('Refreshed list ' + Date.now())
      )
      buildPokeTable(pocketMonsters, 'content');

    })
    .fail(function(){
      $('#content').append($('<h1>').text("OUR SERVERS ARE DOWN"));
    });

  });
}

/*
function createNewPokemonButton() {
  var createButton = $('<button>');
  createButton.text("Create a New Pokemon");
  createButton.on('click', function(e){
    buildNewPokemonForm();
  });
  createButton.insertAfter($('#btn'))
}
*/
