// 1
console.log("************* Equality Operator **************")
console.log("undefined, null: " + (undefined == null));
console.log("NaN, NaN: " + (NaN == NaN));
console.log("new String('foo'), 'foo': " + (new String('foo') == 'foo'));
console.log("'', false: " + ('' == false));
console.log("[1,2], '1,2': " + ([1,2] == '1,2'));
console.log("'1', true: " + ('1' == true));
console.log("NaN, false: " + (NaN == false));
console.log("0, '': " + (0 == ''));

// 2
console.log("************* Identity Operator **************")
console.log("undefined, null: " + (undefined === null));
console.log("NaN, NaN: " + (NaN === NaN));
console.log("new String('foo'), 'foo': " + (new String('foo') === 'foo'));
console.log("'', false: " + ('' === false));
console.log("[1,2], '1,2': " + ([1,2] === '1,2'));
console.log("'1', true: " + ('1' === true));
console.log("NaN, false: " + (NaN === false));
console.log("0, '': " + (0 === ''));

// 3
console.log("************* isNaN **************")
console.log("undefined: " + isNaN(undefined));
console.log("NaN: " + isNaN(NaN));
console.log("null: " + isNaN(null));
console.log("'': " + isNaN(''));
console.log("false: " + isNaN(false));
console.log("0: " + isNaN(0));