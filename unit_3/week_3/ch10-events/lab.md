# Lab
1: Inject the `$rootScope` into your `todoService`

* When a new todo is created, use `$broadcast` to fire a 'created' event and include the todo as the value.

2: In `todoList.component.js` inject `$scope` into the controller.

* Use `$on` to observe the 'created' event and log the todo to the console.