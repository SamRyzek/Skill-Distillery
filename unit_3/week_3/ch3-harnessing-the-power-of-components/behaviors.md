# Controller Functions (*behaviors*)

* The same way that Angular shares data values between component controllers and templates, so too can it expose functions (known as *behaviors*).

* *Behaviors* can be used to return values, calculations etc, or combined with events to dynamically respond to user interaction.

```js
angular.module('exampleModule')
.component('exComponent', {
  templateUrl : 'app/exampleModule/exComponent/ex.component.html',
    controller : function() {
      var vm = this;
      
      vm.friendsOnline = [
        'Sally',
        'Jimmy',
        'Francine',
        'Bobby'
      ];

      vm.getNumFriendsOnline = function() {
        return vm.friendsOnline.length;
      }
    },
    controllerAs : 'vm'
})
```

```html
<h3>Friends online : {{vm.getNumFriendsOnline()}}</h3>
```

<hr>

<h3>Friends online : 4</h3>

<hr>

* *Behaviors* are just functions assigned to a component's controller so that they are visible to the view. While these functions will be accessible in the template, other functions declared as variables (not attached to the controller) will not be.

```js
angular.module('exampleModule')
.component('exComponent', {
  templateUrl : 'app/exampleModule/exComponent/ex.component.html',
    controller : function() {
      var vm = this;
      
      vm.friendsOnline = [];

      /* this function IS available in the template */
      vm.getNumFriendsOnline = function() {
        return vm.friendsOnline.length;
      }

      /* this function IS NOT available in the template */
      var checkLogin = function() {
        // ... some implementation
      }
            
    },
    controllerAs : 'vm'
})
```

### Hands On:

1: Assign a *behavior* to the productList component's controller which returns the number of items in the product list.

2: In the productList template, use your behavior to display the number of product list items :

<hr>
<h3>Number of Products : 10</h3>
<hr>

#### [Prev](ngRepeat.md) | [Next](events.md)

