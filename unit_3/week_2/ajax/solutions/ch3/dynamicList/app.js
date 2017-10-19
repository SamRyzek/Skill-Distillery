$('#button').click(function(event){
  $.ajax({
    type : 'GET',
    url : 'data.json',
    dataType : 'JSON',
  })
  .done(function(data){
    buildList(data);
    removeButton();
  })
  .fail(function(){
    console.log('failed');
  });
});

function buildList(data){
  var $ul = $('<ul>');
  data.forEach(function(elem, index){
    var $li = $('<li>');
    var $a = $('<a>');
    $a.text(elem.name);
    $a.attr('href',elem.url)

    $li.append($a);
    $ul.append($li);
  });
  $('#ajaxContent').append($ul);
}

function removeButton(){
  $('#button').remove();
}
