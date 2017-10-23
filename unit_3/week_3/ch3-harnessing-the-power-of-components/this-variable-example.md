# Why Store a Reference to `this` in a variable?

### The Problem
* It is necessary to store a reference to the value stored within `this` because if another function is invoked on an object, `this` will be assigned to that invoking object inside of the function's scope.

* Example:

```js
var dude = {
  fname : 'Jeffrey',
  lname : 'Lebowski',
  akas : ['Dude', 'El Duderino', 'Duder', 'His Dudeness'],
  display : function() {
    this.akas.forEach(function(aka){
      console.log(this.fname + " " + this.lname + " AKA: " + aka);
    })
  }
}

dude.display();
```

##### Output

```bash
undefined undefined AKA: Dude
undefined undefined AKA: El Duderino
undefined undefined AKA: Duder
undefined undefined AKA: His Dudeness
```

* The `forEach` takes a callback function which created a new scope and reassigned `this` to the Array class (not the `dude` object). Thus, `this` references a completely different object than the expected one.

### The Solution

* Thus, for clarity, it is much easier to store a reference to the original invoking object in a variable (assigning a reference to that object to some namespace). 

* Variable assignment will clarify that the object being referenced is the invoking object from the original scope.

* It is recommended that if you assign `this` to a variable you always use the variable and never reference `this` directly again.

```js
var dude = {
  fname : 'Jeffrey',
  lname : 'Lebowski',
  akas : ['Dude', 'El Duderino', 'Duder', 'His Dudeness'],
  display : function() {
    var person = this; // store the reference to 'this' in the current scope into a variable named 'person'
    person.akas.forEach(function(aka){
      console.log(person.fname + " " + person.lname + " AKA: " + aka);
    })
  }
}

dude.display();
```

##### Output

```bash
Jeffrey Lebowski AKA: Dude
Jeffrey Lebowski AKA: El Duderino
Jeffrey Lebowski AKA: Duder
Jeffrey Lebowski AKA: His Dudeness
```
