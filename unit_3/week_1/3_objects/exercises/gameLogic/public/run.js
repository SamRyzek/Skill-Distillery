var main = function() {
  try {
    if (square) {
      setInterval(function(){
        draw(square)
      },50);
    }
  } catch(e) {
    return;
  }
}

$(document).ready(main);