# Angular Events and Callback Behaviors

* Angular is built with JavaScript, as such, it makes heavy use user events.

* There are a number of event *directives* available to use with AngularJS:

  * [`ng-blur`][ng-blur]
  * [`ng-change`][ng-change]
  * [`ng-click`][ng-click]
  * [`ng-copy`][ng-copy]
  * [`ng-cut`][ng-cut]
  * [`ng-dblclick`][ng-dblclick]
  * [`ng-focus`][ng-focus]
  * [`ng-keydown`][ng-keydown]
  * [`ng-keypress`][ng-keypress]
  * [`ng-keyup`][ng-keyup]
  * [`ng-mousedown`][ng-mousedown]
  * [`ng-mouseenter`][ng-mouseenter]
  * [`ng-mouseleave`][ng-mouseleave]
  * [`ng-mousemove`][ng-mousemove]
  * [`ng-mouseover`][ng-mouseover]
  * [`ng-mouseup`][ng-mouseup]
  * [`ng-paste`][ng-paste]

* These event *directives* decorate HTML elements, and are assigned *behaviors* to invoke when the event is observed. 

* The behavior assigned to the event is assigned as an expression inside of *double quotes* `ng-click="someFunction()"`.

* When dealing with *attribute directives* (directives assigned as attributes to HTML elements), everything in the quotes assigned to the directive is a JavaScript expression, thus it does not require a binding.

  * ***NOTE***: You must include the invoking parentheses inside of this expression.

For example:

  * Whenever the 'Login' button is click, it will call the *behavior* assigned with the `ng-click` directive. 

  * ***NOTE***: the default behavior is prevented automatically

```html
<!-- ex.component.html -->
<form>
  <input type="email" name="email" />
  <input type="password" name="password" />
  <input type="submit" value="Login" ng-click="vm.loginUser()" />
</form>
```

```js
// ex.component.js
angular.module('exampleModule')
.component('exComponent', {
  templateUrl : 'app/exampleModule/exComponent/ex.component.html',
    controller : function() {
      var vm = this;

      vm.loginUser = function() {
        // .. login logic
      }
      
    },
    controllerAs : 'vm'
})
```

* You can pass arguments to the *behaviors* assigned to events the same way you would if you were invoking any other function:

```html
<!-- pass the string 'refresh' to the vm.query behavior -->
<input type="submit" value="Refresh" ng-click="vm.query('refresh')" />
```

### Hands On
1: In your product list component, Create an HTML `<button>` element, and assign it a `ng-click` directive.

2: Define a behavior in your controller called 'log'. 'log' should take a string as a parameter, and use `console.log` to print it to the console.

3: Assign the 'log' behavior to the `ng-click` directive on the button. Pass 'log' a message.

4: Go to the browser, click the button, you should see the message you assigned 'log' appear in Console.

#### [Prev](behaviors.md) | [Next](ng-model.md)

[ng-blur]:https://docs.angularjs.org/api/ng/directive/ngBlur
[ng-change]:https://docs.angularjs.org/api/ng/directive/ngChange
[ng-click]:https://docs.angularjs.org/api/ng/directive/ngClick
[ng-copy]:https://docs.angularjs.org/api/ng/directive/ngCopy
[ng-cut]:https://docs.angularjs.org/api/ng/directive/ngCut
[ng-dblclick]:https://docs.angularjs.org/api/ng/directive/ngDblclick
[ng-focus]:https://docs.angularjs.org/api/ng/directive/ngFocus
[ng-keydown]:https://docs.angularjs.org/api/ng/directive/ngKeydown
[ng-keypress]:https://docs.angularjs.org/api/ng/directive/ngKeypress
[ng-keyup]:https://docs.angularjs.org/api/ng/directive/ngKeyup
[ng-mousedown]:https://docs.angularjs.org/api/ng/directive/ngMousedown
[ng-mouseenter]:https://docs.angularjs.org/api/ng/directive/ngMouseenter
[ng-mouseleave]:https://docs.angularjs.org/api/ng/directive/ngMouseleave
[ng-mousemove]:https://docs.angularjs.org/api/ng/directive/ngMousemove
[ng-mouseover]:https://docs.angularjs.org/api/ng/directive/ngMouseover
[ng-mouseup]:https://docs.angularjs.org/api/ng/directive/ngMouseup
[ng-paste]:https://docs.angularjs.org/api/ng/directive/ngPaste