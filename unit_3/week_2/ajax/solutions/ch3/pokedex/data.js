var DataService = (function(base){
  var service = {};

  service.index = function(func){
    $.ajax({
      type:'GET',
      url:base + "?sorted=true",
      dataType:'json'
    })
    .done(function(data, status){
      func(data);
    })
    .fail(function(xhr, status, error){
      console.log("INDEX Failed: " + error);
    });
  };

  service.show = function(id, func){
    $.ajax({
      type:'GET',
      url:base + "/" + id,
      dataType:'json'
    })
    .done(function(data, status){
      func(data);
    })
    .fail(function(xhr, status, error){
      console.log("SHOW Failed: " + error);
    });
  };

  service.create = function(obj,func){
    $.ajax({
      type:'POST',
      url:base,
      dataType:'json',
      contentType: 'application/json',
      data: JSON.stringify(obj)
    })
    .done(function(data, status){
      func();
    })
    .fail(function(xhr, status, error){
      console.log("CREATE Failed: " + error);
    });
  };

  service.delete = function(id, func){
    $.ajax({
      type: 'DELETE',
      url: base + '/' + id
    })
    .done(function(data, status) {
      func();
    })
    .fail(function(xhr, status, error) {
      console.log("DELETE Failed: " + error);
    });
  };

  return service;
})('http://52.25.225.137:8080/pokemon/data/poke');
