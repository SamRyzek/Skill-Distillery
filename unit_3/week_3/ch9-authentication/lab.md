# Lab

1: Create these files

```bash
authModule
├── auth.module.js
├── auth.service.js
├── login.component.html
├── login.component.js
├── logout.component.html
├── logout.component.js
├── register.component.html
└── register.component.js
```
2: Import dependent js files

```html
<!-- angular imports -->
<script src="app/authModule/auth.module.js"></script>
<script src="app/authModule/auth.service.js"></script>
<script src="app/authModule/login.component.js"></script>
<script src="app/authModule/register.component.js"></script>
<script src="app/authModule/logout.component.js"></script>
<!-- appModule import -->
```

3: Download and source angular-cookies:  https://code.angularjs.org/1.5.7/angular-cookies.min.js

```html
<script src="angular-cookies.min.js"></script>
```

4: Create a `register` component:

  * Make a registration form in `register.component.html` which binds email and password inputs to a `user.email` and `user.password` `ng-model`.

  * On submit, call a `vm.register(user)` behavior. Stub this behavior out in your controller.

5: Create a `login` component:

  * Make a login form in `login.component.html` which binds email and password inputs to a `user.email` and `user.password` `ng-model`.

  * On submit, call a `vm.login(user)` behavior. Stub this behavior out in your controller.

6: Create a `logout` component:

  * Make a button in `logout.component.html`.

  * On click, call a `vm.logout()` behavior. Stub this behavior out in your controller.

7: Complete the following `authService`:

```js
angular.module('authModule')
  .factory('authService', function($http, $cookies) {
    var service = {};

    var saveToken = function(user) {
      // TODO : Store the user's id and email in cookies
    }

    service.getToken = function() {
      // TODO : Return an object with id and email properties,
      // the values are the values of the cookies
    }

    var removeToken = function() {
      // TODO : Remove both the id and email cookies
    }

    service.login = function(user) {
      // TODO : Use the auth/login route to authenticate the user
      // On success, use saveToken to store the users id/email
    }

    service.register = function(user) {
      // TODO : Use the auth/register route to create and authenticate the user
      // On success, use saveToken to store the users id/email
    }

    service.logout = function() {
      // TODO : Use the auth/logout route to remove the users session
      // On success, use removeToken to remove the id and email cookies
    }

    return service;
  })
```

8: Create two angular routes in `app.module.js`:

  * `'/register'` -> template is your register component
  * `'/login'` -> template is your login component
  * Add the `<logout></logout` component to your nav bar.

9: Inject the `authService` into the controller of the `register.component.js`

  * use the `authService.register(user)` method in your `vm.register(user)` behavior. On success, use the `$location.path('/path')` method to redirect to your todo list.

10: Inject the `authService` into the controller of the `login.component.js`

  * use the `authService.login(user)` method in your `vm.login(user)` behavior. On success, use the `$location.path('/path')` method to redirect to your todo list.

11: Inject the `authService` into the controller of the `logout.component.js`

  * use the `authService.logout()` method in your `vm.logout()` behavior. On success, use the `$location.path('/path')` method to redirect to your '/' route (home component).

12: At this point you should be able to login/register and see all of the Todos for the user id you have hardcoded in your `todo.service.js`, now we need to make the todos requested contextual to the User who is logged in.

* Modify `todo.service.js`, inject the `authService` and use the `authService.getToken()` method to access the id for the logged in user.

* Additionally, add a private method `checkLogin`, which uses the `authService.getToken()` method to determine if a user is logged in. If no user is logged in, it should use the `$location` service to redirect to the `/login` route. Apply this method before each of your CRUD methods returns the `$http` service.

13: Finally, update your `navigation.component` so that if a user is logged in the `logout` button is visible and that if a user is not logged in, routes to `login` and `register` are visible.




#### [Prev](ng-cookies.md) | [Next]()
