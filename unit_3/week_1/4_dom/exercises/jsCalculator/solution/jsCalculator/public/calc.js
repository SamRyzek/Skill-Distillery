$(document).ready(function(){
  calculator();
});

var calculator = function() {
  var operations = [];
  var shiftKey = false;
  $('.number').on('click', function(e) {
    $('#display').text($('#display').text() + $(this).text())
  });

  /*
  * CALLBACKS
  */
  var clearDisplay =  function(e) {
    $('#display').text('');
    operations = [];
  };

  var addOperator = function(op) {
    operations.push($('#display').text());
    operations.push(op);
    $('#display').text('');
  };

  var sum = function(e) {
    operations.push($('#display').text());
    var total = parseFloat(operations.splice(0,1)[0]);
    while(operations.length) {
      var operator = operations.splice(0,1)[0];
      switch(operator) {
        case '+' :
          total += parseFloat(operations.splice(0,1)[0]);
          break;
        case '-' :
          total -= parseFloat(operations.splice(0,1)[0]);
          break;
        case '/' :
          total /= parseFloat(operations.splice(0,1)[0]);
          break;
        case 'X' :
          total *= parseFloat(operations.splice(0,1)[0]);
          break;
        default :
      }
    }
    total = parseInt(total * 1000000000)/1000000000;
    $('#display').text(total);
  };

  /*
  * EVENT LISTENERS
  */

  // Clear display on click
  $('#clear').on('click', clearDisplay)

  // Add operators on click
  $('.operator').on('click', function(e) {
    var op = $(this).text();
    addOperator(op)
  });

  // Add keyboard functionality in addition to clicks
  $(window).on('keypress', function(e) {
    // Clear display when 'c' OR 'C' are typed
    if (e.key.toUpperCase() === 'C') {
      clearDisplay();
      return;
    }
    // Add number value to display
    if (e.keyCode >= 48 && e.keyCode <= 57) {
      $('#display').text($('#display').text() + e.key);
      return;
    }
    // Support decimals (make sure there is only one)
    if (e.keyCode === 46) {
      if ($('#display').text().split('.').length === 1) {
        $('#display').text($('#display').text() + '.');
      }
      return;
    }
    // Support addition from '+' key
    if (e.keyCode === 43 || (e.keyCode === 61 && shiftKey)) {
      addOperator('+');
      return;
    }
    // Support subtraction from '-' key
    if (e.keyCode === 45) {
      addOperator('-');
      return;
    }
    // Support division from '/' key
    if (e.keyCode === 47) {
      addOperator('/');
      return;
    }
    // Support multiplication from '*' key
    if (e.keyCode === 42 || e.keyCode === 56 && shiftKey) {
      addOperator('X');
      return;
    }
    // // Support summation from '=' key
    if (e.keyCode === 13 || e.keyCode === 61) {
      sum();
      return;
    }
  });

  // Explicitly support 'delete' key and 'shift' key functionality
  $(window).on('keydown', function(e) {
    // Support removal of digits currently displayed
    if (e.keyCode === 8) {
      var displayArr = $('#display').text().split('');
      displayArr.pop();
      $('#display').text(displayArr.join(''));
    }
    // Support shift key by tracking when it is depressed with 'shiftKey' variable
    if (e.keyCode === 13) {
      shiftKey = true;
    }
  });

  // Reset shiftKey if shift is released
  $(window).on('keyup', function(e) {
    if (e.keyCode === 13) {
      shiftKey = false;
    }
  });

  // Sum values
  $('#equals').on('click', sum);
}
