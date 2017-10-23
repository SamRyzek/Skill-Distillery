# Route Parameters
* Angular makes it possible to pass additional information with the url provided.
  
* You can add parameters (variables in the URL) to your routes with a simple syntax. Example: (`/resource/:id`)
  
```javascript
angular.module('routingApp', ['ngRoute'])
.config(function($routeProvider){
  $routeProvider
        .when('/resource/:id', {
          template : `<resource-detail></resource-detail>`
        })
        .otherwise({
            template: '<not-found></not-found>'
        })
});
```
  
* Angular's parameter routing functions like a wildcard.
  
* In the above example, any route matching `'/resource/*'` will fall into the route.
  
* As the route provider executes sequentially, you will need to provide more specific routes prior to this wildcard route.
  * example:
  
```javascript
angular.module('routingApp', ['ngRoute'])
.config(function($routeProvider){
  $routeProvider
        .when('/resource/new', {
          template : `<new></new>`
        })        
        .when('/resource/:id', {
          template : `<resource-detail></resource-detail>`
        })
        .otherwise({
            template: '<not-found></not-found>'
        })
});
```
  
* By placing, `/resource/new` prior to `/resource/:id`, Angular will route to it, if you reverse the order of these two routes, `/resource/new` will be unreachable.  

#### [Prev](location.md) | [Next](lab.md)