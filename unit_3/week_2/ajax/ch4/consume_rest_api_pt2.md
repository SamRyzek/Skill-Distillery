### Labs
**Overview**: Now that you know how to implement PUT/POST/DELETE, let's add full CRUD to you Quiz application. We are going to implement these features for quizzes not questions and answers.

1: It is usually a good idea to start with a CREATE method. Add a button to your `index.html` labeled 'Create Quiz'.

2: Create an event listener for the button you created in #1. When clicked, present a form with an input field for the name of the quiz. The submit button should have an event listener.

3: When the form in #3 is submitted, verify the form data is correct. If it is, send an AJAX request to the controller route you created in your API and clear the form. The callback should take the response object (the quiz), and append it to the table of quizzes.  

4: Add an 'Edit' button to the your Quiz table creation (i.e. each Quiz should have it's own edit button in a new column).  

5: Add an event listener to the button you created in #4. When clicked, create a form input field. Populate the form with the existing Name of that quiz, use the value attribute of the `<input>`.

6: Add an event listener to the submit button from the form in #5. Validate the inputs, if valid, send an AJAX request to the route you configured in your API. When the response returns, update the Quiz in the table.

7: Finally, add a 'Delete' button to your Quiz table creation (i.e. each Quiz should have it's own delete button in a new column).

8: Add an event listener to the button you created in #7. When clicked, fire a `confirm()` that checks if the user is sure they wish to delete the quiz.

9: Update the event listener from #8. If the user affirms that they wish to delete the quiz, use an AJAX request to send the quizzes id to the delete route you created in your API. If the response is true, remove the quiz from the table.

### Stretch Goals
* Add a 'Take' Button to your table that allows the user to take a quiz question by question.

[Previous](consume_rest_api_pt1.md) | [Next](../README.md)
