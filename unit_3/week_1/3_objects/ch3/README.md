## Initializing an Object Literal with Properties
* Object literals can be assigned properties with values on creation.

* Object properties are *key-value pairs*.

* The property name is typically a string, and is colon seperated from it's value. NOTE: property names *can* be numbers, however it is usually preferable to use strings.

* Values assigned to properties can be of any type (String, Number, Array, Function, Object, Boolean).

* Additional properties are comma seperated.

```javascript
var dog = { name : "Spuds", breed : "Bull Terrier" };

var ralph = {
  "name" : "Ralph",
  "friendly" : false,
  "breed" : "Poodle"
};

var oskar = {
  name : "Oskar",
  age : 3,
  favFoods : [
    "apple",
    "banana",
    "coconut"
  ]
};

var fruit = {
  name : "banana",
  shape : "sphere",
  color : "yellow"
}
```

##### [Prev](../ch2/README.md) | [Next](../ch4/README.md)
