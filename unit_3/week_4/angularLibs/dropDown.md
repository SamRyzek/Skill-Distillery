# Drop Down Menus w/ Angular UI Bootstrap

### Overview
Simple example demonstrating how to use AngularUI Bootstrap to add drop down menu functionality to your application.

### Dependencies

* AngularJS
* AngularUI Bootstrap
* Bootstrap CSS
* Bootstrap-Theme CSS
* Bootstrap JS

```html
<!DOCTYPE html>
<html ng-app="appModule">
<head>
	<title>Drop Down</title>
	<script
  		src="https://code.jquery.com/jquery-3.2.1.min.js"
 		 integrity="sha256-hwg4gsxgFZhOsEEamdOYGBf13FyQuiTwlAQgxVSNgt4="
  		 crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.7/angular.min.js"></script>

	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular-ui-bootstrap/2.5.0/ui-bootstrap-tpls.min.js"></script>
</head>
<body>
    <!-- Your content -->
</body>
</html>
```

```js
// app.module.js
angular.module("appModule", ['ui.bootstrap']);
```

### Example: A Simple Drop Down List

```js
// drop.component.js
angular.module('appModule')
.component('drop', {
  template : `
    <h1>drop</h1>
      <span uib-dropdown>
        <button class="btn btn-primary" id="simple-dropdown" uib-dropdown-toggle>
          Click me for a dropdown, yo!
        </button>
        <ul class="dropdown-menu" uib-dropdown-menu aria-labelledby="simple-dropdown">
          <li ng-repeat="choice in vm.items">
            <a href>{{choice}}</a>
          </li>
        </ul>
      </span>

  `,
  controller : function($timeout) {
    var vm = this;

    vm.items = ['apple','banana','coconut']

  },
  controllerAs : 'vm'
})
```
