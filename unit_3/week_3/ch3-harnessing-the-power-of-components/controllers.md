# [Component Controllers][component]

### `controller` property

* So far, we've been using components as static templates and little else, but they are much more powerful than that.

* The *controller* property allows us to assign a component a function (known as a controller) which adds logic and additional functionality to our component.

* Variables and functionality can be attached to the component within a *controller* and because of the shared state of the *Model & View* in Angular, these variables will also be available in HTML.

* Example:

```js
angular.module('appModule')
.component('productCard', {
  templateUrl : 'productCard.component.html',
  controller : function() {
    // 1
    var vm = this;

    // 2
    vm.product = {
      name : 'Whacky Wavy Arm Inflatable Tube Man',
      price : 65.0,
      numAvail : 13,
      imageUrl : "http://cdn1.bigcommerce.com/server3600/abecwu/products/345/images/1142/American_Flag_Air_Dancer__73184.1374001438.500.521.jpg?c=2"
    };

  },
  // 3
  controllerAs: 'vm'
})
```

```html
<div class="product">
  <div class="product-image">
    <img src="{{vm.product.imageUrl}}" alt="{{vm.product.name}}">
  </div>
  <h3>{{vm.product.name}}</h3>
  <i>{{vm.product.price}}</i>
  <div>Instock: {{vm.product.numAvail > 0}}</div>
</div>
```

* The above example illustrates how you can use a components *controller* to dynamically display content in the view.

1: `var vm = this;`

  * this line assigns the current scope (`this`) to a variable named `vm`. We do this for several reasons. First, because it is easy in JavaScript for `this` to be reassigned within closures, if we assign it to a specific scope's `this` to a local variable, it will always reference the same `this`. Second, clarity. We assign `this` to a variable named `vm` as a shorthand for *view-model*, this helps us remember that this property will be shared between both the *model* -> our controller, and the *view* -> our template. [Detailed Example](this-variable-example.md)

2: `vm.product = { }`

  * here we assign a property to the scope of our component's controller. The value of this variable is now accessible from this object, both within the *controller* and the template.

3: `controllerAs : 'vm'`

  * by default, the controller will be aliased as `$ctrl` in the template...however...this lacks clarity as it does not harmonize with the name of the variable we have assigned our *controller* scope to (`vm`). Thus, we use the `controllerAs` property on the component to harmonize the name of the controller's scope (as well as shorten it). This will reinforce that the value you reference in the controller ***is the same*** value you are referencing in the view.

### Hands On

We will not be creating any new files, only modifying existing code.

1: In `productList.component.js` add a `controller` property and a `controllerAs` (`vm`) property.

2: In the controller function, assign the scope (`this`) to a variable (`vm`).

3: In the controller function, assign a property to `vm` named 'list', which is equal to an array of Strings (these should be your product list items).

4: In your `productList.component.html` replace each of the hard-coded list item names with angular bindings accessing each of the indices of your `vm.list` array (e.g. `{{vm.list[0]}}`)

5: Refresh your browser, everything should look the same.

#### [Prev](README.md) | [Next](ngRepeat.md)

[component]:https://docs.angularjs.org/guide/component
