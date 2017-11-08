# Accordions w/ Angular UI Bootstrap

### Overview
Simple example demonstrating how to use AngularUI Bootstrap to add accordion functionality to your application.

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
* Create a new folder called `accordianComponent` with `accordian.component.js` and `accordian.component.html` files inside of it.

* Source your `accordian.component.js` into your `index.html`

```JavaScript
angular.module('appModule')
.component("accordionComponent", {
	templateUrl : "app/accordionComponent/accordion.component.html",
	controller : function(){
		var vm = this;

		 vm.oneAtATime = true;

		  vm.groups = [
		    {
		      title: 'Dynamic Group Header - 1',
		      content: 'Dynamic Group Body - 1'
		    },
		    {
		      title: 'Dynamic Group Header - 2',
		      content: 'Dynamic Group Body - 2'
		    }
		  ];

		  vm.items = ['Item 1', 'Item 2', 'Item 3'];

		  vm.addItem = function() {
		    var newItemNo = vm.items.length + 1;
		    vm.items.push('Item ' + newItemNo);
		  };

		  vm.status = {
		    isCustomHeaderOpen: false,
		    isFirstOpen: true,
		    isFirstDisabled: false
		  };

	},
	controllerAs : 'vm'
});
```

```html
<div>
  <script type="text/ng-template" id="group-template.html">
    <div class="panel-heading">
      <h4 class="panel-title" style="color:#fa39c3">
        <a href tabindex="0" class="accordion-toggle" ng-click="toggleOpen()" uib-accordion-transclude="heading">
          <span uib-accordion-header ng-class="{'text-muted': isDisabled}">
            {{heading}}
          </span>
        </a>
      </h4>
    </div>
    <div class="panel-collapse collapse" uib-collapse="!isOpen">
      <div class="panel-body" style="text-align: right" ng-transclude></div>
    </div>
  </script>

  <p>
    <button type="button" class="btn btn-default btn-sm" ng-click="vm.status.open = !vm.status.open">Toggle last panel</button>
    <button type="button" class="btn btn-default btn-sm" ng-click="vm.status.isFirstDisabled = ! vm.status.isFirstDisabled">Enable / Disable first panel</button>
  </p>

  <div class="checkbox">
    <label>
      <input type="checkbox" ng-model="vm.oneAtATime">
      Open only one at a time
    </label>
  </div>
  <uib-accordion close-others="vm.oneAtATime">
    <div uib-accordion-group class="panel-default" heading="Static Header, initially expanded" is-open="vm.status.isFirstOpen" is-disabled="vm.status.isFirstDisabled">
      This content is straight in the template.
    </div>
    <div uib-accordion-group class="panel-default" heading="{{group.title}}" ng-repeat="group in vm.groups">
      {{group.content}}
    </div>
    <div uib-accordion-group class="panel-default" heading="Dynamic Body Content">
      <p>The body of the uib-accordion group grows to fit the contents</p>
      <button type="button" class="btn btn-default btn-sm" ng-click="vm.addItem()">Add Item</button>
      <div ng-repeat="item in vm.items">{{item}}</div>
    </div>
    <div uib-accordion-group class="panel-default" heading="Custom template" template-url="group-template.html">
      Hello
    </div>
    <div uib-accordion-group class="panel-default" is-open="vm.status.isCustomHeaderOpen" template-url="group-template.html">
      <uib-accordion-heading>
        Custom template with custom header template <i class="pull-right glyphicon" ng-class="{'glyphicon-chevron-down': vm.status.isCustomHeaderOpen, 'glyphicon-chevron-right': !vm.status.isCustomHeaderOpen}"></i>
      </uib-accordion-heading>
      World
    </div>
    <div uib-accordion-group class="panel-danger" heading="Delete account">
      <p>Please, to delete your account, click the button below</p>
      <button class="btn btn-danger">Delete</button>
    </div>
    <div uib-accordion-group class="panel-default" is-open="vm.status.open">
      <uib-accordion-heading>
        I can have markup, too! <i class="pull-right glyphicon" ng-class="{'glyphicon-chevron-down': vm.status.open, 'glyphicon-chevron-right': !vm.status.open}"></i>
      </uib-accordion-heading>
      This is just some content to illustrate fancy headings.
    </div>
  </uib-accordion>
</div>
```

* This is filled with default data and multiple examples of properties you can customize. Change the content of the HTML and JS code to fit your content needs.
