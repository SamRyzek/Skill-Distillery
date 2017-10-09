#### FORMS
0: Create an HTML file named 'manipulate.html', and create a JS file named 'manipulate.js'

1: Write a form named 'contact' in HTML with the following inputs (all are type='text' except where noted):
  * fname
  * lname
  * street
  * city
  * state
  * zip
  * Add Shipping button => submit

2: In your JS file select the form, and add an Event Listener to its submit button. Remember to prevent the default behavior of the form submission.

3: Print out to your console each of the submitted form values from the event listener and ensure that you are capturing them correctly.

4: In your JavaScript file, create a function named `verifyFormData(fname,lname,street,city,state,zip)` which:
  * Checks that all of the values are completed (i.e. not blank)
  * That the zip can be converted to a number and is five characters long
  * That state is two characters long
  * If any of the above verifications fail, the function should throw an error explaining the problem (you can just return a String if you wish which explains the problem) (i.e. `'Zip code must be composed of 5 numbers'`)
  * **Hint** Try pushing any "errors" that arise into an array. If an error occurs push a message into the errors array. If the array is of length 0 once you test the fields, you are good to go. If not, display the errors in the array.
  * If the data is valid, return `true`.

5: Call `verifyFormData()` in your event listener's callback, and pass it your form data.

6: If `verifyFormData()` returns `true`, clear the form (i.e. remove it), and display the data to the screen.

7: If there are errors, `verifyFormData()` should return an array of Strings (your error messages). When this array is returned to your event listener iterate over the array and display them in a list below the form. The form should not be removed from the DOM, allowing the user to reenter their inputs.


[Previous](domMethods.md) | [Next](../README.md)
