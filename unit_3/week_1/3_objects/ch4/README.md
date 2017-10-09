# Assigning Properties to Objects
* After creation, objects can be assigned additional properties.

* This assignment is *Ex Nihilo* (latin for 'from nothing'). That is, you may assign properties to any object as needed.

* Properties are assigned to objects in two ways: *Dot Notation* and *Subscript Notation*

#### Dot Notation
* *Dot Notation* uses the common OOP syntax of `Object.property` to assign properties.

* The object reference is on the left of the period, and the property name is on the right.

```javascript
var obj = {};

obj.name = "value";
//  Assign a 'name' property to the object with a value of "value"

console.log(obj.name); // => "value"
```

#### Subscript Notation
* *Subscript Notation* uses the string representation of a property's name to access/modify the value of that property.

* The object is referenced on the left side of the statement, and the name of the property is placed within square brackets to the right.

```javascript
var obj = {};

obj['name'] = "value";
//  Assign a 'name' property to the object with a value of "value"

console.log(obj['name']); // => "value"
// You can use dot and subscript notation interchangeably
console.log(obj.name); // => "value"
```

* *Subscript Notation* is extremely powerful. It can be used to access properties of objects with the returned values from function calls, as well as make use of property names that would be invalid with *Dot Notation* (although for obvious reasons you should avoid this practice):

```javascript
// Don't do this even though you can...
var obj = {};
obj['birth year'] = 1986;
// Assign a property that is invalid with 'Dot Notation'

// Use a function's return to access a property
var getCategory = function() {
  return "science";
};

var research = {
  science : [
    "aliens",
    "planets"
  ]
};

research[getCategory()]; // [ "aliens", "planets" ]

// With the for...in loop
var dog = {
  name : "spot",
  age : 12,
  toys : ["rope","ball"]
};

for (p in dog) {
  console.log(p);
}
// name  
// age  
// toys

for (p in dog) {
  console.log(dog[p]);
}
// spot
// 12
// ["rope","ball"]
```

### `for...in` loops
* The `for...in` loop is used to iterate over the properties of a JS object.

* Syntactically, the `for...in` loop is constructed as `for (aliasForProperty in object) {}`, below is an example of how it can be used.

```js
var dog = {
  breed : "labrador",
  name : "scout",
  age : 4
};

for (var p in dog) {
  console.log(p + " : " + dog[p]);
}

// breed : labrador
// name : scout
// age : 4
```

* The `p` in the example above is a placeholder for the property being iterated over. `p` will be a string representation of the property name, as such, to access the value for that property from the object, you must use subscript notation.

### Hands On
* At first, this syntax may seem strange, but it is very similar to Java's `HashMap<>()`, instead of using `put()` and `get()` to read and write from the JS object literal, we simply use the name the of the property.

* Here is an example in Java:

```java
Map<String,String> data = new HashMap<>();
data.put("name","Bob Dobbs");
data.put("email","bdobbs@gmail.com");

System.out.println(data.get("name")); // Bob Dobbs
System.out.println(data.get("email")); // bdobss@gmail.com
```

* Here is the JavaScript equivalent:

```js
var data = {};
data.name = "Bob Dobbs";
data.email = "bdobbs@gmail.com";

console.log(data.name); // Bob Dobbs
console.log(data.email); // bdobbs@gmail.com
```

* Assign `name`, `email`, `age`, `employed`, and `favoriteMovies` properties to your `person` object.  

* Push your `person` object into the `people` array.  

* Modify the empty object you pushed into your `people` array earlier. Give it the same properties you assigned person (different values though). Use subscript notation this time (or dot notation if you used subscript notation before).

* Use a `forEach()` to iterate over the `people` array. Inside of the `forEach()`, use a `for...in` loop to print all of the properties and their values to the console.

##### [Prev](../ch3/README.md) | [Next](objectsAreKeyValuePairs)
