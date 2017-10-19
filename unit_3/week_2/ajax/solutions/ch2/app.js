window.onload = function() {
  var xhr = new XMLHttpRequest();

  xhr.open('GET', 'https://kkane106.github.io/data.json', true);

  xhr.onreadystatechange = function() {
  	if (xhr.readyState === 4 && xhr.status < 400) {
  		var data = JSON.parse(xhr.responseText);
      console.log(data);

      printData(data);
  	}

  	if (xhr.readyState === 4 && xhr.status >= 400) {
  		console.error(xhr.status + ': ' + xhr.responseText);
  	}
  };

  xhr.send(null);
};

var printData = function(data){
  data.forEach(function(element){
    console.log("Name: " + element.fname + " " + element.lname);
  });
}
