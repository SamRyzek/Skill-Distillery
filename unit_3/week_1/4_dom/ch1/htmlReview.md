## HTML Review  

Access to the DOM allows us to manipulate our existing HTML pages using javascript. Using the tools the DOM provides us we can add, remove, and update HTML elements to alter a users experience. It may seem trivial to review, but truly understanding an HTML element is key to getting the most out of our client side JS.

### Elements  

At this point we are very familiar with HTML elements. Since about week 6 we have been serving HTML documents to a browser. When writing these documents we add things like ``<div></div>``, ``<p></p>``, ``<h1></h1>``... you get the point. These tags are described as individual HTML elements. Each of these elements can have content inside of them, ``<div>HERE</div>``. This content can be additional HTML elements or text. When the page is loaded into the browser, this is what the user sees.

#### Attributes  
Additionally HTML tags can have attributes assigned to them. An HTML tag can have as many attributes assigned to it as we want. When an attribute is assigned to an element it is placed within the open tag of that element.
```html
<div id="myID"></div>
```
All attributes follow this convention, the name of the attribute we are assigning, an equal sign, and the value as a string. If you open the web console and inspect the elements in the page you will see attributes assigned to almost every HTML element you see.  

Assigning these attributes is easy but understanding their utility and how we can use them to our advantage with JS is key.  

* **id**: The id attribute is used to assign a unique id for an element. As we progress you will see having these unique values is valuable when trying to select a certain element in the DOM. The browser does not check to make sure these values are unique however, if you assign multiple elements the same id you may experience some odd behavior.  
* **class**: The class same class attribute can be assigned to multiple elements. This is usually used to apply certain styles to elements that are already defined in your CSS document.  
* **style**: Allows you to specify inline styles for that element.  

##### Form element attributes
* **action**: This attribute we should all be familiar with already. It specifies where to send the data when the form is submitted.  
```html
<form action="/user" method = "POST">
</form>
```
* **type**: Allows you to specify what type of element you want the user to see. For example `<input>` tags are used to create buttons, text-boxes, passwords, radio buttons, checkboxes and more. The only way the browser knows how to treat this element is by its type attribute.  
```html
<form>
  <input type = "text"> <!-- Creates a text box that a use can enter information in-->
  <input type ="submit"> <!-- Creates a button that when pressed submits the form  -->
</form>
```
* **name**: Is used to extract user input that was entered into a form. When a form is submitted it creates a key value pair between the name attribute (the key) and the value entered into the form (the value). Additionally we can store information inside of this attribute that we may deem valuable for later use.  
* **value**: This attribute stores the data entered by a user when filling out a form.  


[Previous](documentObjectModel.md) | [Next](../ch2/README.md)
