# [`ng-class`][class]

* `ng-class` dynamically assigns/re-assigns class names to an HTML element.

* `ng-class` is typically provided a variable, behavior, or ternary operator to evaluate each *digest* cycle. If the value, returned value, or result changes, then it automatically updates and applies the class.

* `ng-class` should be assigned variables, behaviors or ternary operators which return strings.

### Example

```css
/* app.css */

.danger {
  color: red;
}
.warning {
  color: yellow;
}
.safe {
  color: green;
}
```

```html
<!-- criticalityMonitor.component.html -->

<h3 ng-class="vm.checkNuclearCriticality()">{{vm.criticalityLevel}}</h3>
```

```js
// criticalityMonitor.component.js
angular.module('reactorMonitor')
.component('criticalityMonitor', {
  templateUrl : 'criticalityMonitor.component.html',
  controller : function() {
    var vm =this;

    vm.criticalityLevel = 7;

    vm.checkNuclearCriticality = function() {
      if (vm.criticalityLevel > 10) return 'danger';
      if (vm.criticalityLevel > 5) return 'warning';
      return 'safe';
    }
  }
})
```

#### [Prev](filters-js.md) | [Next](lab.md)

[class]:https://docs.angularjs.org/api/ng/directive/ngClass
