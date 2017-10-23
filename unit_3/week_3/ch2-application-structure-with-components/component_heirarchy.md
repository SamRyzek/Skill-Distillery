# Component Heirarchy

* In Angular applications, components naturally adopt a heirarchical structure. Parent components 'have' sub (children) components. 

* As an example, a 'home' component may have a 'navigation' component, 'newsFeed' component, and 'login' component all included in it's template.

```html
<!-- home.component.html -->
<navigation></navigation>
<div class="jumbotron">
  <img src="http://bigimage.com" alt="SlideShow">
</div>
<news-feed></news-feed>
<div>
  <h3>Get more from your news!</h3>
  <login></login>
</div>
<footer>
  <div>Copyright MyCompany 1995</div>
</footer>
```

  * Each of the components in the above example will have their own template and functionality that is both well encapsulated and maintainable.

* It is convention that the top most component in this architecture be named ***'appComponent'*** (literally, *the application component*), and that it is the entry point for the rest of the application.

* Other components should be named in a way that makes them easily identifiable. 

* Large areas of functionality can (and should) be organized into their own modules.

### Including supporting modules as dependencies

* It is entirely possible to have an entire Angular application contained within a single module, however this is an organizational nightmare and does not encapsulate functionality.

* Instead, you can create additional modules with specific roles and responsibilities in an application.

* The first step is creating an additional Angular module.

```js
// foo.module.js

angular.module('fooModule', []);
```

* Once this module has been sourced in the `index.html`, you can include it as a dependency in your `appModule` by name:

```js
// app.module.js

angular.module('appModule', ['fooModule']);
```

* Now, any components, or other configured elements included in 'fooModule' will be available to 'appModule'.

* We will 

### Hands On
We are going to create a number of files and directories to add an additional module to your app. The end result will look like this:

```bash
WebContent
├── WEB-INF
│   └── web.xml
├── app
│   └── appModule
│       ├── app.module.js
│       ├── app.component.js
│       └ productList
│         ├── productList.component.html
│         └── productList.component.js
├── index.html
└── js
    ├── angular.min.js
    └── angular.min.js.map
```


1: In `productList.component.js` create a new Angular component named 'productList'

* add a `templateUrl` property which references the `productList.component.html` file.

2: Source the `productList.component.js` just after `app.module.js` in your `index.html`

3: Edit the `productList.component.html` file, add an unordered list with four items in it (hard code the values).

4: Add a `<product-list>` component element to your `index.html`.

5: Re-run your application (refresh the browser), you should now see the list of product items displayed.

#### [Prev](components_in_application.md) | [Next](lab.md)
