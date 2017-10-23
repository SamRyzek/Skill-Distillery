# Directives

### What are Directives?
* At a high level, directives are markers on a DOM element (such as an attribute, element name, comment or CSS class) that tell AngularJS's HTML compiler (`$compile`) to attach a specified behavior to that DOM element (e.g. via event listeners), or even to transform the DOM element and its children.

* AngularJS comes with a large set of these directives built-in, like `ngApp`, `ngModel`, and `ngClass`. 

>What does it mean to "compile" an HTML template? For AngularJS, "compilation" means attaching directives to the HTML to make it interactive. The reason we use the term "compile" is that the recursive process of attaching directives mirrors the process of compiling source code in compiled programming languages.

* In other words, an Angular directive is like a marker in HTML that when observed by AngularJS will be modified and given additional functionality / templating / etc...

* For example, the `ngHide` directive is similar to JQuery's `$(element).hide()` method, except, instead of using an element selector, in Angular we simply apply the directive with a boolean directly to the HTML:


```html
<!DOCTYPE html>
<html ng-app="myAppModule">
<head>
  <title>Document</title>
  <script src="angular.min.js"></script>
  <script src="ngApp.js"></script>
</head>
<body>
  <h1 ng-hide="true;">Hello World</h1>
</body>
</html>
```

* ***NOTE***: Obviously in the above example we would want to use something more dynamic than a literal boolean value.

* Behind the scenes the source code for the `ngHide` directive uses a library similar to JQuery (called *jqLite*) to modify the element it is applied to. Which, if we made it as a custom directive (`myHide`) could look something like this:

```js
// ngApp.js
angular.module('myApp',[])
  .controller('ctrl', function($scope){
    show = true;
  })
  .directive('myHide', function($compile) {
    return {
      restrict : 'A',
      link : function(scope, element, attr) {
        scope.$watch('show', function(bool) {
          if (scope.show) {
            element.css('display', 'initial');
          } else {
            element.css('display', 'none');
          }
        });
      }
    }
  });
```
```html
<!DOCTYPE html>
<html lang="en" ng-app="myApp">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <script src="angular.min.js"></script>
  <script src="ngApp.js"></script>
</head>
<body ng-controller="ctrl">
  <h1 my-hide="show" ng-model="show">Hello</h1>
  <button ng-click="show = (show) ? false : true;">
    Toggle Greeting
  </button>
</body>
</html>
```

* Luckily for us, since the release of Angular 1.5 in May 2016, there is a much easier way to handle DOM transformations and we don't need to rely as heavily on creating our own directives, this is just an example illustrating that if you really really needed to, you could.

* Directives can be applied as HTML *attributes* (as above -> that is what `restrict : 'A'` is indicating), or as there own *elements* (`<ng-view></ng-view>`). While there are directives which use *comments* and *CSS classes* these are much less frequently used by developers (mostly they are applied by the framework itself).

#### [Prev](bootstrapping.md) | [Next](../ch2-application-structure-with-components/README.md)
