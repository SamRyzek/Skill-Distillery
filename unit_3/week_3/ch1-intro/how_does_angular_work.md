# How does AngularJS work?

* AngularJS's functionality lives inside of the global `angular` object. 

* When you access this object, you will create new structural components within the application. Here is a diagram of those components and how they are inter-related:

![ng diagram](../imgs/ng-diagram.jpg)

* Most of these structures will be given a name when you create them. Behind the scenes, Angular will use this name and the corresponding value (usually a function or object) to register it into a key value store (like a HashMap). When you ask for a component by name later, it will look for it in this data structure, and provide the value.

* As an example, if we create two Angular modules , each with a name, you can think of them as being registered like this on a module:

```js
angular.module('apple', []);

angular.module('banana', ['ngRoute']);

/*
Behind the scenes this could look like this:

var modules = {
  apple : {
    injectables : []
  },
  banana : {
    injectables : ['ngRoute']
  }
}
*/
```

* When an Angular application is loaded, it ***compiles*** the HTML. (more on this later)

#### [Prev](why_when_angular.md) | [Next](angular_dependency.md)
