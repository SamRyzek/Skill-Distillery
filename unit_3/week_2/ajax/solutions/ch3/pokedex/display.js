var Display = (function(){
  var obj = {};

  var table = function(data){
    $('#content').empty();

    var $div = $('<div id="container">');

    var $table = $('<table>');

    var $thead = $('<thead>');
    var $trHead = $('<tr>');
    var $th = $('<th>CONTENTS</th>');

    $trHead.append($th);
    $thead.append($trHead);
    $table.append($thead);

    var $tbody = $('<tbody>');

    data.forEach(function(element, index){
      var $tr = $('<tr>');
      $tr.attr('id', element.id);

      var $tdId = $('<td>');
      if(element.pokedexId < 10){
        $tdId.text("00"+element.pokedexId);
      }
      else if(element.pokedexId < 100 && element.pokedexId >= 10){
        $tdId.text("0" + element.pokedexId);
      }
      else if(element.pokedexId >= 100){
        $tdId.text(element.pokedexId);
      }

      var $tdName = $('<td>');
      $tdName.text((element.name).toUpperCase());

      $tdName.click(function(e){
        DataService.show($(this).parent().attr('id'), Display.showPokemon);
      });

      var $remove = $('<td>');
      var $deleteButton = $('<button>DELETE</button>');

      $deleteButton.click(function(e){
        console.log($(this).parent());
        DataService.delete($(this).parent().parent().attr('id'), function(){
          var confirmation = confirm('Ash, are you sure you want to delete this pokemon?');
          if(confirmation){
            DataService.index(Display.buildTable);
          }
        });
      });

      $remove.append($deleteButton);

      $tr.append($tdId, $tdName, $remove);
      $tbody.append($tr);
      $table.append($tbody);
    });

    $table.append($tbody);
    $div.append($table);

    // $('#content').append($table);

    var $h4 = $('<h4>Create a new Pokemon</h4>');
    var $form = $('<form name="newPokemon">');
    var $pokeID = $('<input name="pokeID" placeholder="Pokedex ID">');
    var $name = $('<input name="name" placeholder="Name">');
    // var $type = $('<input name="type">');
    var $ht = $('<input name="ht" placeholder="Height">');
    var $wt = $('<input name="wt" placeholder="Weight">');
    var $createButton = $('<br><input type="submit">');

    $createButton.click(function(e){
      e.preventDefault();
      var pokemon = {};
      pokemon.pokedexId = $(newPokemon.pokeID).val();
      pokemon.name = $(newPokemon.name).val();
      pokemon.height = $(newPokemon.ht).val();
      pokemon.weight = $(newPokemon.wt).val();

      DataService.create(pokemon, function(){
        DataService.index(Display.buildTable);
      });
    });

    $form.append($pokeID,$name,$ht,$wt,$createButton);
    $div.append($h4, $form);
    $('#content').append($div);
  };

  var displayOne = function(pokemon){
    $('#content').empty();
    var $div = $('<div id="showContainer">');

    var $pictureSpan = $('<div id="image">');
    var $id = $('<p>');

    if(pokemon.pokedexId < 10){
      $id.text("00"+pokemon.pokedexId);
    }
    else if(pokemon.pokedexId < 100 && pokemon.pokedexId >= 10){
      $id.text("0" + pokemon.pokedexId);
    }
    else if(pokemon.pokedexId >= 100){
      $id.text(pokemon.pokedexId);
    }

    var $img = $('<img src="imgs/bulbasaur.png">');
    $pictureSpan.append($img, $id);

    var $infoSpan = $('<div id = "info">');

    var $name = $('<h4>');
    $name.text(pokemon.name.toUpperCase());
    var $type = $('<h4>');
    $type.text('TYPE');
    var $ht = $('<h4>');
    $ht.text("HT " + pokemon.height + "'");
    var $wt = $('<h4>');
    $wt.text("WT " + pokemon.weight + " lb");

    var $hr = $('<hr>');

    var $descriptionDiv = $('<div>');

    var $button = $('<button>');
    $button.text('Return');
    $button.attr('value', 'Return');
    $button.click(function(e){
      DataService.index(Display.buildTable);
    });

    var $description = $('<p>');
    $description.text("Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");

    $descriptionDiv.append($description,$button);

    $infoSpan.append($name,$type,$ht,$wt);
    $div.append($pictureSpan,$infoSpan,$hr,$descriptionDiv);

    $('#content').append($div);
  }

  obj.buildTable = function(data){
    table(data);
  };

  obj.showPokemon = function(pokemon){
    displayOne(pokemon);
  };

  return obj;
})();
