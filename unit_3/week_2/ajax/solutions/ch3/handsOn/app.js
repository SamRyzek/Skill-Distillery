//hands on 1
// $.ajax({
//   type: "GET",
//   url: "https://kkane106.github.io/data.json",
//   dataType: "json"
// })
// .done(function(data, status, xhr){
//   console.log(data);
// })
// .fail(function(xhr, status, error){
//   console.log("Error! ");
// });

//hands on 2
$.ajax({
  type: "GET",
  url: "https://kkane106.github.io/data.json",
  dataType: "json"
})
.done(function(data, status, xhr){
  console.log(data);
  buildDOM(data);
})
.fail(function(xhr, status, error){
  console.log("Error! ");
});

function buildDOM(data){
  data.forEach(function(element){
    var h1 = $('<h1>');
    h1.text(element.fname + " " + element.lname);
    console.log(h1);
    $('body').append(h1);
  });
}
