//1
for(var i =0; i < 10; i++){
  console.log("Number: "+ i + ", Square: " + (i*i) );
}

//2
var j=0;
while(j< 10){
  console.log("Number: "+ j + ", Square: " + (j*j) );
  j++
}

//3
var k=0;
while(k< 10){
  if((k*k*k)%2 === 0){
    console.log("Cube: "+ (k*k*k));
  }
  k++
}

//4
var fib0 =0;
var fib1=1;
console.log(fib0);
console.log(fib1);
for(var i=0; i< 20; i++){
  var fibCurr = fib0+fib1;
  fib0 = fib1;
  fib1=fibCurr;
  console.log(fibCurr);
}

//5
var fib0 =0;
var fib1=1;
console.log("1: " + fib0);
console.log("2: "+ fib1);
for(var i=3; i< 20; i++){
  var fibCurr = fib0+fib1;
  fib0 = fib1;
  fib1=fibCurr;
  console.log(i+ ": " +fibCurr);
}
