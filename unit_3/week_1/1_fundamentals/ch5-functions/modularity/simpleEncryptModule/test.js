// Test simpleEncrypt module functionality
var test1 = encrypt('dog', 1); // should be: 'eph'
var pass1 = (test1 === 'eph') ? true : false;
console.log(`test1: dog => eph (${pass1})`);

var test2 = encrypt('ABC', 3); // should be: 'eph'
var pass2 = (test2 === 'DEF') ? true : false;
console.log(`test2: ABC => DEF (${pass2})`);

console.log(encrypt);
// The following three functions will be visible if a closure is not used
// These will throw an error when encapsulated within a closure (which is
// a good things as they will be completely inaccessible from outside of
// the function they are defined in)
console.log(transformToCharacterCodeArray);
console.log(shiftCharacters);
console.log(createEncodedStringFromCodeArray);