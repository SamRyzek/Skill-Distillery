# Carousel w/ Angular UI Bootstrap

### Overview
Simple example demonstrating how to use AngularUI Bootstrap to add a carousel jumbotron to your application.

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
* Create a new folder called `carouselComponent` with `carousel.component.js` and `carousel.component.html` files inside of it.

* Source your `carousel.component.js` into your `index.html`


```JavaScript
angular.module('appModule')
.component("carouselComponent", {
	templateUrl : "app/carouselComponent/carousel.component.html",
	controller : function(){

		  var vm = this;

		  vm.myInterval = 5000;
		  vm.noWrapSlides = false;
		  vm.active = 0;

		  var slides = vm.slides = [];
		  var currIndex = 0;

		  vm.addSlide = function() {
		    var newWidth = 600 + slides.length + 1;
		    slides.push({
		      image: '//unsplash.it/' + newWidth + '/300',
		      text: ['Nice image','Awesome photograph','That is so cool','I love that'][slides.length % 4],
		      id: currIndex++
		    });
		  };

		  vm.randomize = function() {
		    var indexes = generateIndexesArray();
		    assignNewIndexesToSlides(indexes);
		  };

		  for (var i = 0; i < 4; i++) {
		    vm.addSlide();
		  }

		  // Randomize logic below

		  function assignNewIndexesToSlides(indexes) {
		    for (var i = 0, l = slides.length; i < l; i++) {
		      slides[i].id = indexes.pop();
		    }
		  }

		  function generateIndexesArray() {
		    var indexes = [];
		    for (var i = 0; i < currIndex; ++i) {
		      indexes[i] = i;
		    }
		    return shuffle(indexes);
		  }

		  // http://stackoverflow.com/questions/962802#962890
		  function shuffle(array) {
		    var tmp, current, top = array.length;

		    if (top) {
		      while (--top) {
		        current = Math.floor(Math.random() * (top + 1));
		        tmp = array[current];
		        array[current] = array[top];
		        array[top] = tmp;
		      }
		    }

		    return array;
		  }
	},
	controllerAs : 'vm'
});
```

```html
<div>
  <div style="height: 305px">
    <div uib-carousel active="vm.active" interval="vm.myInterval" no-wrap="vm.noWrapSlides">
      <div uib-slide ng-repeat="slide in vm.slides track by slide.id" index="slide.id">
        <img ng-src="{{slide.image}}" style="margin:auto;">
        <div class="carousel-caption">
          <h4>Slide {{slide.id}}</h4>
          <p>{{slide.text}}</p>
        </div>
      </div>
    </div>
  </div>
   <div class="row">
    <div class="col-md-6">
      <button type="button" class="btn btn-info" ng-click="vm.addSlide()">Add Slide</button>
      <button type="button" class="btn btn-info" ng-click="vm.randomize()">vm.randomize slides</button>
      <div class="checkbox">
        <label>
          <input type="checkbox" ng-model="vm.noWrapSlides">
          Disable Slide Looping
        </label>
      </div>
    </div>
    <div class="col-md-6">
      Interval, in milliseconds: <input type="number" class="form-control" ng-model="vm.myInterval">
      <br />Enter a negative number or 0 to stop the interval.
    </div>
  </div>
</div>
```

* This is filled with default data and multiple examples of properties you can customize. Change the content of the HTML and JS code to fit your content needs. The images are being sourced from UnSplash.it, if you want to add your own images you would need to replace the URL's to reference images from your local file system.
