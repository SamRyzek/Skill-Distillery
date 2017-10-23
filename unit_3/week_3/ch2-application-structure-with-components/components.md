# [Components][com]

* In AngularJS, a [Component][com] is a special kind of directive that uses a simpler configuration which is suitable for a component-based application structure.

* This makes it easier to write an app (giving it clear architectural structure).

* [Component][com]'s are also the core building block of Angular2 applications. Since the introduction of [component][com]s in Angular 1.5, they have become the recommended means of building an AngularJS application.

* Advantages of Components:

  * simpler configuration than plain directives

  * promote sane defaults and best practices

  * optimized for component-based architecture

  * writing component directives will make it easier to upgrade to Angular

### Creating a Component

* [Component][com]s are registered to [Module][mod]s.

* After retrieving an existing module, use the `Module.component(string, config{})` method on the module to create a new component.

  * *`string`* is the name of the component, and will be the name of the element which represents it in HTML. ***NOTE***: This name must be **camelCased**.

  * *`config{}`* is a JavaScript object that will handle additional configuration for the component.

```js
// ngApp.js

angular.module('bananaApplication',[]);
```

```js
// bananaList.component.js

angular.module('bananaApplication')
  .component('bananaList', {
    // Additional Configuration
  })
```

* The 'bananaList' component can now be added to HTML by it's **snake-cased** name:

```html
<!DOCTYPE html>
<html ng-app="bananaApplication">
<head>
  <title>Component</title>
  <script src="../angular.min.js"></script>
  <script src="ngApp.js"></script>
  <script src="bananaList.component.js"></script>
</head>
<body>
  <banana-list></banana-list>
</body>
</html>
```

* At the moment nothing will appear in the DOM, for that we need to add a template property to the [component][com]s configuration object.

```js
// bananaList.component.js

angular.module('bananaApplication')
  .component('bananaList', {
    template : `
      <ul>
        <li>Yellow</li>
        <li>Green</li>
        <li>Plantain</li>
      </ul>
    `
  })
```

#### Hands On
We are going to create a number of files and directories to structure your Angular app. The end result will look like this:

```bash
WebContent
├── WEB-INF
│   └── web.xml
├── app
│   └── appModule
│       ├── app.module.js
│       ├── helloWorld.component.html
│       └── helloWorld.component.js
├── index.html
└── js
    ├── angular.min.js
    └── angular.min.js.map
```

1: in `app/appModule` create a directory named 'appComponent'

* Inside of `helloWorld` create 'helloWorld.component.js' and 'helloWorld.component.html'

* This is the standard format we will use when creating additional components, a directory with the components camelCased name, and a *.js* and *.html* file with the component name followed by *.component*

2: in `app/appModule/helloWorld.component.js` create a new Angular component named 'helloWorld', assign the component a `template` property with `<h1>Hello World</h1>`

3: in `index.html` source the `helloWorld.component.js` file.

* in the `<body>` add the `<hello-world>Loading...</hello-world>` element.

4: You should see the component's "Hello App Component" render to the screen. If "Loading" is visible, something is amiss. Make sure your application is bootstrapped and check the console for errors.

#### [Prev](module.md) | [Next](components_in_application.md)

[com]:https://docs.angularjs.org/guide/component

[mod]:https://docs.angularjs.org/api/ng/function/angular.module
