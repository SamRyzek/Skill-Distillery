### Event Object
* When an event listener is triggered, the callback function is passed the Event object.  

* The Event object is created when the event occurs and has properties pertaining to the event:  
  * `timestamp`: when the event was created  
  * `type`: the type of event  
  * `target`: the target to which the event was originally dispatched.  
  * etc  

* In vanilla JS this last property is particularly useful as it contains a reference to the object that triggered the event. In the case of a button click event, the target will be the button.  

* jQuery gives us another way to reference the object that triggered an event, `$(this)`. With jQuery events you still have access to the event object injected into the callback function. Just as in standard JS we can access the element on which the click occurred with `e.target`. This however returns an HTML element object not a jQuery element object. The difference here is that we can't call jQuery methods on an HTML element. To get around this we can reference the object with a this call, `$(this)`.  

```html
<body>
  <button id='btn'>Request Information</button>

  <script type="text/javascript">
      var $btn = $('#btn');

      $btn.click(function(e) {
          $(this).text('This Button Has Been Clicked');
      });
  </script>
</body>
```

* Now, when the button is clicked, it will change the text on the button to 'This Button Has Been Clicked'  

### Hands On
* Add a button to you HTML document that says 'Off'.  
* When the button is clicked, change the text of the button to 'On'.  
* If the button is clicked it should toggle back to 'Off'  



[Previous](usingEventListeners.md) | [Next](keyLogger.md)
