## Design patterns

Design patterns are used as templates to solve recurring problems. Think of them as a tried and true recipe to implement a solution to these problems. The patterns are not implementable code, but a template to design your code in such a way that it follows a common pattern.

A few examples of patterns we have seen throughout the course of the program are:

### The singleton design patterns
* The singleton pattern is used to make sure a class only has one instance, and provide a way of accessing it.
* The singleton also is responsible for initializing the instance when it is first needed.

* We experienced a flavor of a singleton using Spring beans. The object is created when you first need to access the class in your application.  
* Angular also works in a similar manner when looking for services.  

### The MVC design pattern
The MVC patterns benefits are similar to those of encapsulation. There is a separation of concerns between the individual elements that make up the model, view, and controller respectively. Changing code in one has no affect on the code in the others. Their interactions are discussed below.

##### The Elements
* The Model: Houses the data being used in the interaction. The data is received via the controller and passed on to the view.

* The View: Is what is displayed in the browser. For our purposes this will be a JSP or HTML document. These documents manipulate the models data and give it a user facing display.

* The Controller: The controller manages all of these interactions. It manipulates the model and passes this changed data to an appropriate view. During our time in JWeb the Controller will be our Servlets.

<img src="MVC.png" width ="300"/>

### The DAO design pattern
The DAO pattern is also something that we have been exposed to. This pattern has two elements:
* The Data Access Interface: maps out the methods and operations that you will need to implement in your DAO class.
* DAO concrete class: implements the methods defined in the DAO interface. The concrete class fetches the data from the data source (in our case mySQL db) and returns it to whoever invokes the DAO methods.
* A model object: A simple Java class that stores the data returned from the DAO. If you are querying a db for a list of users, it would be the matching User class.

### The revealing module design pattern
The revealing module pattern is a way to implement JS objects. First, we wrap code pertaining to a specific object in a function. This function encapsulates this functionality. We can then grant access to certain methods or variables via an object literal that is returned from the encapsulating function.

```js
var myModule = (function(){
  var number = 0;

  function increment(){
    number++;
  }

  function decrement(){
    number--;
  }

  function getNumber(){
    return number;
  }

  return {
    increment : increment,
    decrement : decrement,
    getNumber : getNumber
  };

})();

myModule.increment();
var num = myModule.getNumber(); //num = 1
```

Here is a link to the JS design patterns book [Revealing Module Pattern][Revealing Module Pattern].

[Revealing Module Pattern]:https://addyosmani.com/resources/essentialjsdesignpatterns/book/#revealingmodulepatternjavascript
