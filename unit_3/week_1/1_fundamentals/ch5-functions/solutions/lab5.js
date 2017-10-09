//1
// function square(num){
//   return num*num;
// }

//2
// function square(num){
//   if(isNaN(num)){
//     console.log("Invalid input, please enter a number");
//   }
//   else{
//     return num*num;
//   }
// }

//3
function square(){
  if(arguments.length === 1){
    return arguments[0] * arguments[0];
  }
  else{
    return Math.pow(arguments[0], arguments[1]);
  }
}

//4
// function sum(){
//   var total = 0;
//   for(var i =0; i<arguments.length; i++){
//     if(!isNaN(arguments[i])){
//       total += parseInt(arguments[i]);
//     }
//   }
//   return total;
// }

//5
function sum(){
  var total = 0;
  if(typeof arguments[0] == "function"){
    for(var i =0; i<arguments.length; i++){
      if(!isNaN(arguments[i])){
        total += arguments[0](parseInt(arguments[i]));
      }
    }
  }
  else{
    for(var i =0; i<arguments.length; i++){
      if(!isNaN(arguments[i])){
        total += parseInt(arguments[i]);
      }
    }
  }

  return total;
}

//6
function convertTemp(temp, scale){
  if(scale.charAt(0) === "c"){
    return (temp-32) * (5/9);
  }
  else if(scale.charAt(0) === "f"){
    return temp*(9/5) + 32;
  }
  else{
    return "Invalid";
  }
}
