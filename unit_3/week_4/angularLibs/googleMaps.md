# Google Maps w/ AngularJS
### Overview
This example illustrates how you can use the Google Maps API dynamically with the *angularjs-google-maps* module.

Before getting started, you MUST go and create a google developer account with the google developers console, then enable Google Maps Javascript API, and then get your own API_KEY.

### Documentation
* Module Docs : https://github.com/allenhwkim/angularjs-google-maps

* Detailed Directive Docs with Examples : https://ngmap.github.io/#/!marker.html

### Dependencies

* Download this file : https://github.com/allenhwkim/angularjs-google-maps/blob/master/build/scripts/ng-map.min.js

##### HTML w/ Dependencies

```html
<!DOCTYPE html>
<html ng-app="appModule">
<head>
	<title>Map App</title>
  <!-- Angular -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.7/angular.min.js"></script>
  <!-- Google API -->
	<script src="https://apis.google.com/js/api.js"></script>
  <!-- Downloaded NgMap Module (see link above) -->
	<script src="/js/ng-map.min.js"></script>

  <!-- Angular App Imports (modules/services/components etc ...) -->
</head>
<body>
    <!-- Content -->
</body>
</html>
```

##### App Module with Dependency

```js
// app.module.js
angular.module("appModule", ['ngMap']);
```

### Example 1 : Map with Multiple Location Markers
In this example, multiple markers are included dynamically with various options (animation/draggable/icon etc).

These are currently assigned to `vm.mapOptions` asynchronously as simulated by `$timeout`. ***NOTE*** you will not use a `$timeout`, you will request this data asynchronously from a service in much the same way...this is only an example.

```js
/* MAP STUFF */
// mapView.component.js
angular.module('appModule')
.component('mapView', {
  template : `
    <h1>Map</h1>
    <div ng-if="vm.mapOptions" map-lazy-load="https://maps.google.com/maps/api/js"
        map-lazy-load-params="{{vm.googleMapsUrl}}">
        <ng-map center="{{vm.mapOptions.center.lat}},{{vm.mapOptions.center.lng}}" zoom="{{vm.mapOptions.zoom}}">
          <marker ng-repeat="mark in vm.mapOptions.markers" position="[{{mark.lat}},{{mark.lng}}]" title="{{mark.title}}" icon="{{mark.icon}}" animation="{{mark.animation}}" draggable="{{mark.draggable}}"></marker>
        </ng-map>
    </div>
  `,
  controller : function($timeout) {
    var vm = this;
    vm.googleMapsUrl = "https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY_GOES_HERE"
    vm.mapOptions = null;

    $timeout(function() {
      vm.mapOptions = {
          center: {lat: -34.397, lng: 150.644},
          markers : [
            {lat: -34.397, lng: 150.644, title : "center", animation : "Animation.BOUNCE"},
            {lat: -34.380, lng: 150.644, title : "one", animation : "Animation.DROP"},
            {lat: -34.370, lng: 150.644, title : "two", draggable : "true"},
            {lat: -34.360, lng: 150.644, title : "three", icon : "https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png"},
          ],
          zoom: 8
      };
    },2000);

  },
  controllerAs : 'vm'
})
```

### Example 2 : Utilizing Geolocation to Plot a User's Current Location

This service uses the browsers `navigator` object to geolocate the user based on their IP. Doing so will prompt them to allow or disallow this behaviour. This example returns the geolocation of the user in a service, meaning it can be consumed asynchronously in a component with `.then`.

```js
/* GEOLOCATION SERVICE */
// geolocator.service.js
angular.module('appModule')
.factory('geolocator', function($window) {
  var service = {};

  service.geolocate = function() {
    return new Promise(function(resolve, reject) {
      $window.navigator
        .geolocation
        .getCurrentPosition(function(position) {
          resolve({
              lat : position.coords.latitude,
              lng : position.coords.longitude
          })
        })
    })
  }

  return service;
})
```

This component consumes the `geolocator` service above and uses it assign the user's position to the `vm.mapOptions`, it also assigns a marker based on that user's location.

***NOTE***: `$scope.$apply()` is used to force the values in the shared scope of the View Model to be reevaluated.

```js
/* Map w/ GEOLOCATION */

// mapView.component.js
angular.module('appModule')
.component('mapView', {
  template : `
    <h1>Map</h1>
    <div ng-if="vm.mapOptions" map-lazy-load="https://maps.google.com/maps/api/js"
        map-lazy-load-params="{{vm.googleMapsUrl}}">
        <ng-map center="{{vm.mapOptions.center.lat}},{{vm.mapOptions.center.lng}}" zoom="{{vm.mapOptions.zoom}}">
          <marker ng-repeat="mark in vm.mapOptions.markers" position="[{{mark.lat}},{{mark.lng}}]" title="{{mark.title}}" icon="{{mark.icon}}" animation="{{mark.animation}}" draggable="{{mark.draggable}}"></marker>
        </ng-map>
    </div>
  `,
  controller : function($timeout, geolocator, $scope) {
    var vm = this;
    vm.googleMapsUrl = "https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY_GOES_HERE"
    vm.mapOptions = null;

    geolocator.geolocate()
      .then(function(position){
        vm.mapOptions = {
              center: position,
              markers : [position],
              zoom: 8
          }
        $scope.$apply();
      })
  },
  controllerAs : 'vm'
})
```
