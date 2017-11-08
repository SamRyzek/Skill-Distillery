# Rating w/ Angular UI Bootstrap

### Overview
Simple example demonstrating how to use AngularUI Bootstrap to add a rating system to your application

### Dependencies

* AngularJS
* AngularUI Bootstrap
* ngAnimate
* Bootstrap CSS
* Bootstrap-Theme CSS
* Bootstrap JS

#### Set Up
* Download all of the above dependencies, and include them in your `index.html` file.
* In your app.js file inject `ui.bootstrap` and `ngAnimate` into your app.module:

### Example

```javascript
angular.module('appModule', ['ui.bootstrap', 'ngAnimate']);
```
* Create a new folder called `ratingComponent` with `rating.component.js` and `rating.component.html` files inside of it.
* Source your `rating.component.js` into your `index.html`

```JavaScript
angular.module('appModule')
.component("ratingComponent", {
	templateUrl : "app/ratingComponent/rating.component.html",
	controller : function(){

	  var vm = this;

	  vm.rate = 7;
	  vm.max = 10;
	  vm.isReadonly = false;

	  vm.hoveringOver = function(value) {
	    $scope.overStar = value;
	    $scope.percent = 100 * (value / $scope.max);
	  };

	  vm.ratingStates = [
	    {stateOn: 'glyphicon-ok-sign', stateOff: 'glyphicon-ok-circle'},
	    {stateOn: 'glyphicon-star', stateOff: 'glyphicon-star-empty'},
	    {stateOn: 'glyphicon-heart', stateOff: 'glyphicon-ban-circle'},
	    {stateOn: 'glyphicon-heart'},
	    {stateOff: 'glyphicon-off'}
	  ];
	},
	controllerAs : 'vm'
});
```

```html
<div>
    <h4>Default</h4>
    <span uib-rating ng-model="vm.rate" max="vm.max" read-only="vm.isReadOnly" on-hover="vm.hoveringOver(value)" on-leave="overStar = null" titles="['one','two','three']" aria-labelledby="default-rating"></span>
    <span class="label" ng-class="{'label-warning': percent<30, 'label-info': percent>=30 && percent<70, 'label-success': percent>=70}" ng-show="overStar && !vm.isReadOnly">{{percent}}%</span>

    <pre style="margin:15px 0;">Rate: <b>{{rate}}</b> - Readonly is: <i>{{vm.isReadOnly}}</i> - Hovering over: <b>{{overStar || "none"}}</b></pre>

    <button type="button" class="btn btn-sm btn-danger" ng-click="rate = 0" ng-disabled="vm.isReadOnly">Clear</button>
    <button type="button" class="btn btn-sm btn-default" ng-click="vm.isReadOnly = ! vm.isReadOnly">Toggle Readonly</button>
    <hr />

    <h4>Custom icons</h4>
    <div ng-init="x = 5"><span uib-rating ng-model="x" max="15" state-on="'glyphicon-ok-sign'" state-off="'glyphicon-ok-circle'" aria-labelledby="custom-icons-1"></span> <b>(<i>Rate:</i> {{x}})</b></div>
    <div ng-init="y = 2"><span uib-rating ng-model="y" rating-states="vm.ratingStates" aria-labelledby="custom-icons-2"></span> <b>(<i>Rate:</i> {{y}})</b></div>
</div>
```

* This is filled with default data and multiple examples of properties you can customize. Change the content of the HTML and JS code to fit your content needs.
