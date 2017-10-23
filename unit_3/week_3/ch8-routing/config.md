# Routing Configuration Blocks
* A modules configuration block is where Angular application routes are set and configured.

* You could choose to create a new module specifically for route configuration, but conventionally it is acceptable to place routing in the `appModule`.

* Configuration blocks are chained off of a module with the `.config()` method.

* To configure routes, we need to inject the `$routeProvider` dependency exposed from the `'ngRoute'` module:

```javascript
angular.module('appModule', ['ngRoute'])
.config(function($routeProvider){
  // Route configurations...
});
```

### [`$routeProvider`][$rp]

* the `$routeProvider` service is used for configuring routes

* `$routeProvider` exposes a method (`$routeProvider.when('path', route{})`)

  * `path` is a string corresponding to the relative url path that this route should correspond to.

  * `route` is an object with properties which tell Angular what to do when the route is matched.

    * optional `route` properties:

      * `template` - literally the template to render for that route. Components make this trivially easy as you can render a component's template.

      * `templateUrl` - just like a Component's `templateUrl`, the path to the HTML file that will be rendered.

```js
angular.module('appModule', ['ngRoute'])
.config(function($routeProvider){
  $routeProvider
    .when('/', {
      template : '<home-component></home-component>'
    })
    .when('/pokemon', {
      template : '<pokemon-component></pokemon-component>'
    })
});
```

* As you can see from above, you can chain multiple route declarations (`.when()`) one after the other.

### `otherwise` - catch all
* If a route is entered that does not match any of your `.when()` route declarations, you can set a default with `otherwise(route)`

```js
angular.module('appModule', ['ngRoute'])
.config(function($routeProvider){
  $routeProvider
    .when('/', {
      template : '<home-component></home-component>'
    })
    .when('/pokemon', {
      template : '<pokemon-component></pokemon-component>'
    })
    .otherwise({
      template : '<not-found-component></not-found-component>'
    })
});
```


### Hands On

* You are going to create a number of components and add routing to them (in addition to your todo-list) component.

```bash
appModule
# ├── additional files excluded for brevity
  ├── about.component.html
  ├── about.component.js
  ├── contact.component.html
  ├── contact.component.js
  ├── home.component.html
  └── home.component.js
```

1: Create:

  * Create the following components:

    * 'home' component
    * 'about' component
    * 'contact' component

2: For now, simply give each component a template with an `<h1>` that displays it's component name.

3: Add routing to each component, placing the `ng-view` in your `app.component.html`. (test this by navigating to each)

4: Finally, add a '/todo' route which displays your `<todo-list>` component

#### [Prev](ng-route.md) | [Next](location.md)

[$rp]:https://docs.angularjs.org/api/ngRoute/provider/$routeProvider
