# Lab

You will be updating your service to use `$http` to communicate with your API instead of using hard coded data.

### Part 1 : Load Data

1: in `todo.service.js` remove the hard coded todos array (we won't need it any more)

* remove the `generateId` function, the database will generate these for us now.

2: Modify the `todoService.index()` method to make a request to the API's index route. For the time being, hard code the User's ID as a user that exists in your database.

3: In `todoList.component.js` create a function named `reload` which uses the `todoService.index()` method to set `vm.todos` to the response data (e.g. the list of todos).

* Invoke the `reload()` function after creating it (when the controller loads this will populate the `vm.todos` array).

4: Refresh the browser, you should see the todos in your database load.

### Part 2 : Create

1: in `todo.service.js` make a `create(todo)` method which uses `$http`. 

* You should still set the 'completed' property to `false`.

* In `todoList.component.js` modify your `vm.addTodo` behavior to use the `todoService.create(todo)` method. Be sure to `reload()` the data if the request is successful.

### Part 3 : Destroy

1: in `todo.service.js` make a `destroy(id)` method which uses `$http`.

* In `todoList.component.js` modify your `vm.deleteTodo` behavior to use the `todoService.destroy(id)` method. Again, be sure to `reload()` the data on success.

### Part 4 : Update

1: in `todo.service.js` make an `update(todo)` method which uses `$http`.

* In `todoList.component.js` modify your `vm.updateTodo` behavior to sue the `todoService.update(todo)` method. As before, use `reload()` to update the data on success.

### Part 5 : Mark Todos Complete with Checkbox
This step, we will attach an event listener to the checkbox on the todo list. When the box is checked, or unchecked, we will perform an update request and persist it.

1: In `todoList.component.html` assign an `ng-change` to the checkbox, and assign the `vm.updateTodo(todo)` callback to it.



#### [Prev](rest-lab.md) | [Next](../ch7-filters/README.md)