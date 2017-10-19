function capitalize(str) {
  var result = "";
  result += str.split("").shift().toUpperCase();
  result += str.slice(1);
  return result;
}
