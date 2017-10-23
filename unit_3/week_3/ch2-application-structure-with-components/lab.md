# Lab

This week will have a single lab project, the end result of which will be a full stack application with user authentication. The objective is for you to have a working application which uses all of our technologies that will both prepare you for, and act a good reference during, your final project.

You will be making a Todo application.

1: Create a new 'Dynamic Web Project' in your `SD/ng` directory named `ngTodo`

2: You will be creating the same conventional file structure we began for your Hands On.

```bash
WebContent
├── WEB-INF
│   └── web.xml
├── app
│   └── appModule
│       ├── app.module.js
├── index.html
├── css
│   └── app.css
└── js
    ├── angular.min.js
    └── angular.min.js.map
```

* move the angular dependencies into a `js` directory

* create a `css` directory with an `app.css` file in it

* create an `app.module.js` and an `appModule` within.

* for now, just put `'Hello Angular'` within a binding in the `index.html`

* don't forget to source your `app.module.js` file in your index.html

3: Now we will start adding Todo functionality. 

```bash
WebContent
├── WEB-INF
│   └── web.xml
├── css
│   └── app.css
├── js
│   ├── angular.min.js
│   └── angular.min.js.map
├── app
│   └── appModule
│        ├── app.module.js
│        ├── todoList.component.html
│        └── todoList.component.js
└── index.html
```

4: Now create a 'todoList' component in `todoList.component.js`.

* use `todoList.component.html` as a template

  * for now, just put 'hello todoList' in the html template

* don't forget to source the `todoList.component.js` file in your `index.html`

5: Now you have the basic structure for the application. Run the dynamic web project and navigate to your application root in Chrome. You should see something akin to:

```html
hello angular hello todoList
```

If not, check your console for errors.

#### [Prev](component_heirarchy.md) | [Next](../ch3-harnessing-the-power-of-components/README.md)
