# What is AngularJS?

* AngularJS is JavaScript. It's framework is written with JavaScript, the logic you write is JavaScript, it is interpreted by the browser as JavaScript.

* It is a framework:

> AngularJS is a structural framework for dynamic web apps. It lets you use HTML as your template language and lets you extend HTML's syntax to express your application's components clearly and succinctly. Angular's data binding and dependency injection eliminate much of the code you would otherwise have to write. And it all happens within the browser, making it an ideal partner with any server technology.
> ~*AngularJS Docs*

* Frameworks assist us by simplifying common problems developers approaching similar tasks have encountered previously.
  
* Instead of writing our own (often lengthy) solution to one of these problems, the framework provides us with some interface that makes our lives easier. This often comes in the form of opinionated structure, methods, or objects.
  
* The question to be asked when deciding on what framework to use is, "what problem am I trying to solve?". For SpringMVC, the problem is "How can I simplify the process of receiving and responding to HTTP requests?".

### What does Angular look like?

* Angular's functionality, much like JQuery's (`$`), is encapsulated within a single global object (`angular`).

* Angular applications of composed with building large building blocks called 'modules', which contain a variety of other configuration files, data services, and view templates.

* For example, this is a very simple Angular application which simply prints "Hello World":

```js
// ngApp.js
angular.module('myAppModule', [])
  .component('appComponent', {
    template : `<h1>{{vm.message}}</h1>`,
    controller : function() {
      var vm = this;

      vm.message = 'Hello World';
    },
    controllerAs : 'vm'
  });
```

* The code above creates a 'component' (one of Angular's building blocks), can now be included in HTML as an element named `<app-component></app-component>`.

```html
<!DOCTYPE html>
<html ng-app="myAppModule">
<head>
  <title>Angular Hello World</title>

  <script src="angular.min.js"></script>
  <script src="ngApp.js"></script>
</head>
<body>
  <app-component></app-component>
</body>
</html>
```

* Where the `<app-component></app-component>` element exists, the component's template will render `<h1>Hello World</h1>`

#### [Prev](README.md) | [Next](why_when_angular.md)
