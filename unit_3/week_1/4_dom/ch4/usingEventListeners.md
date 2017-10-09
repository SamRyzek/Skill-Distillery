## Using Event Listeners
* There are a large number of events that you can observe and use. A full list can be found on [MDN Event Docs][mdn], or [jQuery Events Docs][jQueryEvents].

### Click
One of the most common uses for event listeners is to observe 'click' events from users. We used click events previously to demonstrate some of the event basics. These jQuery functions require a selector (the element with the click bound to it), and a callback function.

```html
<body>
    <button id='btn'>My Button</button>

    <script type="text/javascript">
        $('#btn').click(function(e){
            console.log('button clicked');
        });
    </script>
</body>
```

* The above example illustrates how you can add a 'click' event listener to a `<button>` element. Each time the user clicks the button, it will fire the anonymous function, and print 'CLICKED!' to the console.

#### Hands on
* Add a button element to your HTML document. Give it a unique id.
* Add a click event listener to the button. When the button is clicked print out a message and $(this).

<hr>

### Dbl click
The double click function is identical to the click event above. This method is extremely handy compared to its vanilla JS counterpart. In order to create this functionality without jQuery we would have to write a timer and an event listener. We would then see if the click event had been triggered twice in a certain window of time and act accordingly. With jQuery all we have to do is specify ``dblclick()``.

```javascript
    $('button').dblclick(function(e){
        console.log('button double clicked');
    });
```
### Key events
* `keyup()`: Keyup is fired when a user releases a key on the keyboard.
* `keydown()`: Keyup is fired when a user presses a key on the keyboard.
* `keypress()`: Keyup is fired when a user releases a key on the keyboard. Keypress, however, doesn't register modifier or non-printing keys (`Shift`, `Esc`, `delete`).

All of these events follow this format:
```javascript
    $(document).keypress(function(e){
      console.log("key pressed");
    });
```

When using any of these events you can access the code or value of the key that triggered the event. As we discussed earlier, an `event` object is injected into the triggered callback function. This object has a few properties on it that allow us to access these values.

If the `q` button is pressed the following properties will yield:
```javascript
    $(document).keypress(function(e){
      console.log(e.which);         //81
      console.log(e.keyCode);       //81
      console.log(e.key);           //q
    });
```

Browsers can have different properties so it is recommended to use `e.which` for keyboard input.

### Scroll
Scroll can be used in multiple situations. We can listen for a scroll and fire a callback function as normal.
```javascript
    $(window).scroll(function(e){
      console.log('you are scrolling');
    });
```

 It can also tell the browser to execute a scroll triggered by another event, say a click.
```javascript
    $('#scroll').click(function(e){
      $('#targetAnchor').scroll();
    });
```

### Turning off events
If you are in a situation where you want to remove an event from an element, you can use the `.off()` function to remove all events, or specify them individually.

```javascript
  $('#myDiv').off();    //removes all events from element with id myDiv
  $('#myDiv').off('click');     //removes the click event of element with id myDiv
```

### `alert()`, `confirm()`, `prompt()`
* The easiest way to take user input (for now), is to use `alert()`, `confirm()` and `prompt()`. These are methods on the Window object that will create popup windows and either present the user with information or ask for their input.

* Let's use these to practice event listeners:

```html
<body>
    <button id='btn'>Request Information</button>

    <script type="text/javascript">
        // create event listener
        $('#btn').click(function(e) {
        	// store boolean in response variable
            var response = confirm('Would you like to receive our newsletter?');

            // if 'ok'
            if (response) {
            	// prompt user to enter email
                var email = prompt('Enter your email');
                // popup message success
                alert('You will now receive our newsletter to ' + email);
            } else {
            	// popup message failure
                alert('Sorry, the newsletter is the only information available');
            }
        });
    </script>
</body>
```

#### Hands On
* Refactor your click event from the previous example to alert the user the button has been clicked.


[Previous](listeningForEvents.md) | [Next](eventObject.md)


[mdn]:https://developer.mozilla.org/en-US/docs/Web/Events
[jQueryEvents]:https://api.jquery.com/category/events/
