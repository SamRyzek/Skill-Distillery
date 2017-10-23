# Configuring Components In Applications

* As we will see, components can be arranged heirarchically within an application.

* One *parent* component can contain multiple *child* components, which can contain their own children...etc etc.

* It is convention to begin an application with one top-most component named **appComponent**.

* It is also convention to use directories to store files related to an individual component (such as html files for templating).

### Application Structure

* Here is an example of the organization of an Angular application:

```bash
dogWalkerApplication
-> appModule
  -> appComponent
    -> app.component.js
    -> app.component.html
  -> dogComponent
    -> dog.component.js
    -> dog.component.html
  -> ngApp.js
index.html
```

* In the above example:

  * the application has one module, the declaration of which will be in the `ngApp.js` file

  * there are two components, each with their own *.js* files and *.html* files.

  * there is a single `index.html` files which is where all of the dependencies will be declared, components and services included with `<script src="">` tags and the application will be bootstrapped.

### `templateUrl` property
* Previously we used the `template` property to configure what a component would display:

```js
// bananaList.component.js

angular.module('appModule')
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

* While this certainly works, it does not follow the *Seperation of Concerns* principle (presentation should be seperate from application logic), nor is it particularly maintainable (HTML syntax highlighting is unavailable for instance).

* As an alternative, we can (and should) use the `templateUrl` property to reference a seperate HTML file for the template of our component.

  * the file is referenced via absolute path from root context (which, in this case, is the `WebContent` directory)

```js
// bananaList.component.js

angular.module('appModule')
  .component('bananaList', {
    templateUrl : 'app/appModule/bananaList/bananaList.component.html'
  })
```

```html
<!-- bananaList.component.html -->
<ul>
  <li>Yellow</li>
  <li>Green</li>
  <li>Plantain</li>
</ul>
```

### Hands On
1: Refactor your `helloWorld` component. Replace the `template` property with a `templateUrl` property and path to `app/appModule/helloWorld.component.html`.

2: Place the `<h1>Hello World from html file</h1>` to the HTML file.

3: Refresh your browser, everything should still work, but with new text in the heading.

#### [Prev](components.md) | [Next](component_heirarchy.md)
