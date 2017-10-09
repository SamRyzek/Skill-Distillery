var searcher = (function(numsArr){
  var data = numsArr.sort(function(a,b){
    return a - b;
  });

  //1
  var linearSearch = function (num){
    var array= data;
    for(var i=0; i < array.length; i++){
      if(num === array[i]) return i;
    }
    return -1;
  }

  //2
  var binarySearch = function(value) {
    var searchArray = data;
    var notFound = true;
    while(notFound) {
      var medianIndexValue = searchArray[Math.floor(searchArray.length/2)];
      console.log(medianIndexValue)
      if (medianIndexValue === value) {
        notFound = false;
        return true;
      }
      if (searchArray.length <= 1) {
        return false;
        break;
      }
      if (medianIndexValue < value) {
        searchArray = searchArray.splice(
          Math.floor(
            searchArray.length/2
            ), searchArray.length - 1
          );
        console.log(searchArray);
        continue;
      }
      if (medianIndexValue > value) {
        searchArray = searchArray.splice(
          0,
          Math.floor(
            searchArray.length/2
            )
          );
        console.log(searchArray);
        continue;
      }
    }
  }

  return {
    binarySearch : binarySearch,
    linearSearch : linearSearch
  }
});

//3
function sum(array){
  var sum = array.reduce(function(a, b) {
    return a + b;
  }, 0);

  return sum;
}

//4
function top5(array){
  var top5 =[];
  array.sort(function(a,b){
    return b - a;
  });

  top5 = array.slice(0,5);

  return top5;
}
var searchArray = [
  8,99,76,90,1009,6520,32,
  102,109,68,392,324,203,
  230,12,23,546,234,1231,
  5346,4235234,109,1230,
  34230,123,242,124356,
  13,2,3,1,5,68,545,34,
  62,56
 ];
var array2 = [1, 45, 3, 23, 11, 6, 7, 100]

//examples
var searches = searcher(searchArray);
console.log("Linear Seatch (99): "+searches.linearSearch(99));
console.log("Linear Seatch (12342134): "+searches.linearSearch(12342134));

console.log("Bin Search (546): "+searches.binarySearch(546));
console.log("Bin Search (542225): "+searches.binarySearch(542225));

console.log("Top 5: " + top5(array2));
console.log("Sum : " + sum(array2));
