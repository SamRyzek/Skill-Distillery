// Very basic shift encryption program

// First solution exposes all functions to the global scope

var encrypt = function(word, shift) {
  return createEncodedStringFromCodeArray(
    shiftCharacters(
      transformToCharacterCodeArray(word), shift));
}

var transformToCharacterCodeArray = function(word) {
  var codeArray = [];
  var wordArray = word.split("");
  for (var i = 0 ; i < word.length ; i++) {
    // add the first character in the word array's ascii code to the codeArray
    codeArray.push(wordArray.shift().charCodeAt(0));
  }
  return codeArray;
};

var shiftCharacters = function(arr, shift) {
  for (var i = 0 ; i < arr.length ; i++) {
    arr[i] += shift;
  }
  return arr;
};

var createEncodedStringFromCodeArray = function(arr) {
  var encodedString = "";
  for (var i = 0 ; i < arr.length ; i++) {
    encodedString += String.fromCharCode(arr[i]);
  }
  return encodedString;
};

/*
// Use an Immediately Invoked Function Expression (IIFE)
// to create a closure. Less variables are exposed to the
// global scope this way, and all functionality is 
// encapsulated within the function scope as a closure.
var encrypt = (function(){
  var encrypt = function(word, shift) {
    return createEncodedStringFromCodeArray(
      shiftCharacters(
        transformToCharacterCodeArray(word), shift));
  }

  var transformToCharacterCodeArray = function(word) {
    var codeArray = [];
    var wordArray = word.split("");
    for (var i = 0 ; i < word.length ; i++) {
      // add the first character in the word array's ascii code to the codeArray
      codeArray.push(wordArray.shift().charCodeAt(0));
    }
    return codeArray;
  };

  var shiftCharacters = function(arr, shift) {
    for (var i = 0 ; i < arr.length ; i++) {
      arr[i] += shift;
    }
    return arr;
  };

  var createEncodedStringFromCodeArray = function(arr) {
    var encodedString = "";
    for (var i = 0 ; i < arr.length ; i++) {
      encodedString += String.fromCharCode(arr[i]);
    }
    return encodedString;
  };

  // only expose 'encrypt' function, the rest of the functionality
  // will be preserved within the closure
  return encrypt;
})();
*/