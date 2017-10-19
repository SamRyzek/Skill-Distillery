function loadPokeTable() {
  createRefreshButton();
  loadPokemon()
    .done(function(pocketMonsters){
      buildPokeTable(pocketMonsters, 'content');

    })
    .fail(function(){
      $('#content').append($('<h1>').text("OUR SERVERS ARE DOWN"));
    });
}

function buildPokeTable(pocketMonsters, parent) {
  // Stub out table
  var table = $('<table>');
  var thead = $('<thead>');
  var tbody = $('<tbody>');
  table.append(thead);
  table.append(tbody);
  // Make headers
  var headers = $('<tr>');
  headers.append($('<th>').text('Poke Id'));
  headers.append($('<th>').text('Name'));
  headers.append($('<th>').text('Types'));
  headers.append($('<th>').text('Image'));
  thead.append(headers);
  // Populate body content
  pocketMonsters.forEach(function(pokemon, idx, array) {
    var tr = $('<tr>');
    if (idx % 2 === 0) {
      tr.addClass('striped');
    }
    tr.append($('<td>').text(pokemon.pokeId));
    tr.append($('<td>').text(capitalize(pokemon.name)));
    // Assign types
    var types = $('<td>');
    pokemon.types.forEach(function(type, idx) {
      if (idx > 0) {
        types.text(types.text() + ", " + type.name);
      } else {
        types.text(type.name);
      }
    });
    tr.append(types);
    // Assign image
    var td = $('<td>');
    var img = $('<img>');
    img.attr('src', pokemon.img);
    img.attr('alt-text', pokemon.name + " image");

    /*
      Start : Details Event Listener
    */
    img.attr('poke_id', pokemon.pokeId);
    img.on('click', showPokemonDetail);
    /*
      End : Details Event Listener
    */

    var button = $('<button>')
      .text("DELETE")
      .attr("poke_id", pokemon.pokeId);
    button.on('click', function(e) {
      var id = $(e.target).attr('poke_id');
      destroy(id)
        .done(function(res) {
          if (res === true) {
            $(e.target).parent().parent().remove();
          }
        })
        .fail(console.error);
    })
    td.append(img);
    tr.append(td);

    tr.append($('<td>').append(button));

    tbody.append(tr);
  });

  $('#'+parent).append(table);
}
