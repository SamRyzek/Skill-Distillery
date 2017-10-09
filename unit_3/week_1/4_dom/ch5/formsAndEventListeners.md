### Forms and Event Listeners
* Up until this point we have been using the default form behavior on submission. Namely, when the user submits a form, the data within is submitted and sent as a request to some route, and the response which returns dictates what should happen next.

* With JavaScript we need to prevent this behavior in order to use the data without page refresh.

* The Event object gives us a method which allows us to prevent the default behavior of the target (in this case the submit button), with a method fittingly named `.preventDefault()`

```html
<body>
    <form name='myForm'>
        <input type='text' name='fname' />
        <input type='text' name='lname' />
        <input type='submit' name='submit' value='submit' />
    </form>

    <script type="text/javascript">
        $(myForm.submit).click(function(e) {
            // Don't submit the form
            e.preventDefault();

            // print out the submit buttons => parent (form) => fname input => value
            console.log($(myForm.fname).val()); // Will print the user input value
            console.log($(myForm.lname).val()); // Will print the user input value
        });
    </script>
</body>
```

### Hands On
* Create a form with two text input fields and a submit button.
* Assign an event listener to the submit button. Remember, because it is a form submit we have to prevent the default action of the form.
* When the button is clicked, print out the values the user entered into the text fields.

<hr>

* Now that we have collected the form data (and printed it out in this example), we will want to clear the form data. This is also extremely easy using `reset()`  

```html
<body>
    <form name='myForm'>
        <input type='text' name='fname' />
        <input type='text' name='lname' />
        <input type='submit' name='submit' value='submit' />
    </form>

    <script type="text/javascript">
      $('#formSubmit').click(function(e) {
          // Don't submit the form
          e.preventDefault();

          // print out the submit buttons => parent (form) => fname input => value
          console.log($(myForm.fname).val()); // Will print the user input value
          console.log($(myFrom.lname).val()); // Will print the user input value

          myForm.reset();
      });
    </script>

</body>
```

### Hands On
* Using the form from the previous hands on, add the necessary code to clear the form fields when the form submit button is clicked.


[Previous](selectingFormsByName.md) | [Next](dynamicallyCreatingElements.md)
