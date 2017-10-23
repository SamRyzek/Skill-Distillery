# Lab

### Part 1 : Navigation Module and Component

* Now that you have routing setup, it would be useful to have a nav-bar so that you don't have to type the actual paths in every time you want to get somewhere.

* Create a `navigation` component (***NOTE***: `<nav>` is an actual HTML element, so don't name your component `nav`). Do not forget to include this component's JS file in your `index.html`.

* Within `navigation.component.html` create a nav bar that has links to your resources.

  * ***NOTE*** with angular routing you need to precede the route with `#`, e.g. `<a href="about">` needs to be `<a href="#/about">`

* Include your navigation component in your `index.html` just above the `<ng-view>` --> this will make it appear everywhere in your application!

### Part 2 : Handling 404

* Create a component that display the error message "Not Found" in the `nav` module. (possibly named `notFound`)

* Create an `otherwise` route handler and assign it's template this component. (this means that if they attempt to navigate to a page in your app that does not exist they will get a nice 404 page).

### Part 3 : Creating a `show` route with route Parameters

* create a new route like `/todo/:id` that routes to the `todoList` component.

  * ***NOTE*** initially there will be no `todo` data to display (that's the next step)

### Part 4 : Using route parameters in a component

* We are going to use route parameters (or the lack there of) to tell the `todoList` component how to display content.

* To reuse this component for routing, we will need to add a conditional which determines if it was routed to.

1: Add a conditional that checks if there are route parameters.

```js
if (!vm.todo && parseInt($routeParams.id)) {
  // additional logic
}
```

* If this condition is true, it means that this was routed to, and that you need to use the corresponding `todo` data

2: We could use the `todoService` to retrieve the todo with the `id` from the `$routeParams` (`show` method). Assigning the data from the response to the `vm.selected` variable...but, we are already retrieving the entire list of todos on load. Iterate over the collection loaded todos looking for the one with the `id` which corresponds to the route parameter, and set that todo inside of `vm.selected`.

* If there is no `todo` with the provided `id`, redirect using `$location.path('path')` to a route that displays your 404 page.

#### [Prev](params.md) | [Next](../ch9-authentication/README.md)
