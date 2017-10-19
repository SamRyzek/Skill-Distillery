// show
function getPokemonById(pid) {
  return $.ajax({
    type : 'GET',
    url : "http://52.25.225.137:8080/pokemon/data/poke/" + pid,
    dataType : 'json'
  })
}

// index
function loadPokemon() {
  return $.ajax({
    type      : 'GET',
    url       : 'http://52.25.225.137:8080/pokemon/data/poke?sorted=true',
    dataType  : 'json'
  })
}

// update

// create
function create(pokemon) {
  return $.ajax({
    type        : 'POST',
    dataType    : 'json',
    url         : 'http://52.25.225.137:8080/pokemon/data/poke',
    contentType : 'application/json',
    data        : JSON.stringify(pokemon)
  });
}

// delete

function destroy(id) {
  return $.ajax({
    type: "DELETE",
    url : 'http://52.25.225.137:8080/pokemon/data/poke/' + id
  });
}
