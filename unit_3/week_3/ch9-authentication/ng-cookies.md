# Angular Cookies

### Dependency

* Use the CDN!:

```
https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.7/angular.min.js
```

* Angular provides the module `ngCookies` which makes accessing cookies simple

* In order to include the `ngCookies` module in your project, you must first include the dependency in your index.html:

```html
<head>
<script src="angular.min.js"></script>
<script src="angular-route.min.js"></script>
<script src="angular-cookies.min.js"></script>
<!-- etc -->
```

* The dependency is available here: https://code.angularjs.org/1.5.7/angular-cookies.min.js

* Once included, you will need to inject the `ngCookies` module into the module where you will use it:

```js
angular.module('authModule', [ 'ngCookies' ]);
```

### Use
* `ngCookies` exposes the `$cookies` service which can be used to access the browser's cookies.

* `$cookies` acts like a hash map allowing you to add, retrieve, and remove values by their key:

```js
// Add a cookie
$cookies.put('userId', 1);

// Retrieve the value assigned to a cookie
$cookies.get('userId'); // => 1

// Remove a cookie by name
$cookies.remove('userId');
```

* With `$cookies` you can store meta information about users locally for reference without necessitating a round trip to the browser.


#### [Prev](interceptors.md) | [Next](lab.md)
