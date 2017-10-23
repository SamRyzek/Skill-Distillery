# Modules

* The [`angular.module`][mod] is a global place for creating, registering and retrieving AngularJS modules. 

* It is the largest building block of an Angular application.

* All [modules][mod] (AngularJS core or 3rd party) that should be available to an application must be registered using this mechanism.

### Creating a Module

* To create a new module use the `angular.module(string, dependencies[])` two argument method.

  * *`string`* is a JavaScript String and represents the name of the module. e.g.

```js
angular.module('routingModule',[]);
// => a new module as been created
```

  * *`dependencies[]`* is a JavaScript array literal. Ultimately we will place the names of other modules (either modules we create or 3rd party dependencies) names in this array so that they will be included at runtime.

### Retrieving Modules by Name After Creation

* Instead of keeping references to your Angular [module][mod]s in the global scope by assigning them to a variable (which would be bad practice), Angular has provided a getter method for retrieving existing modules.

* The `angular.module(string)` one argument method will retrive a module by name.

```js
angular.module('routingModule'); // returns an existing module 
```

* Ultimately, we will use this 'getter' method to encapsulate our Angular code into multiple files.

### Hands On

We are going to create a number of files and directories to structure your Angular app. The end result will look like this:


```bash
WebContent
├── WEB-INF
│   └── web.xml
├── app
│   └── appModule
│       └── app.module.js
├── index.html
└── js
    ├── angular.min.js
    └── angular.min.js.map
```

1: To begin, we will start creating an application structure.

* In `WebContent` create a new directory named 'app'

* In `app`, create a new directory named 'appModule'

  * `appModule` will be your top-most module which coordinates other dependencies, is used to bootstrap the application, etc. This directory will contain the files directly related to/involved in configuring it.

2: in `app/appModule` create a file named 'app.module.js'

* in `app/appModule/app.module.js` create a new Angular module named 'appModule'

3: in your `index.html`, bootstrap your `<html>` element with `"appModule"` and add `app.module.js` as a source.

* Everything should still be working as before.

#### [Prev](README.md) | [Next](components.md)

[mod]:https://docs.angularjs.org/api/ng/function/angular.module
