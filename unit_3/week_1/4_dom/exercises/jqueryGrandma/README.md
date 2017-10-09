#jQuery Grandma
### Introduction / Goals
Remember *'Deaf Grandma'*? This is the new and improved version using jQuery.  

We will use an HTML form to submit statements to Grandma. Her hearing isn't so great so she won't understand us unless we shout. She has become an avid gamer since we spoke to her last, so no matter what we say she will be shouting l33t speak back at us.  

This exercise will further acquaint you with:  

* Using jQuery event listeners (create and remove)
* jQuery selectors
* Creating DOM elements with jQuery
* Appending jQuery DOM elements to existing DOM elements

### Requirements
* include jQuery from the CDN

#####1 : Build the conversation form
* The form has the id 'grandmaForm'

* The form has an input with the name 'say'

* The form has an input with the type 'submit'

#####2 : Create a div with the id 'conversation'
* There is a div with the id 'conversation'

#####3 : Talk to grandma!
* Create an event listener named `listenToGrandmaForm`, this will be the callback used when the submit button is clicked.

* Clicking the submit creates a div inside of #conversation
the added div contains the text entered in the form
grandma's response is also added to the #conversation div in a div

* If user enters lowercase, grandma responds 'U WAT M8?'

* If user enters uppercase, grandma responds 'UR A n00b HACKZOR!'

* If user enters 'GOODBYE!', grandma responds 'L8R M8'`

##### 4 : Disable conversation after 'GOODBYE!'
* Remove the event listener from the button after saying 'GOODBYE'.

* After 'GOODBYE!', no more text should be appended to the conversation if the button is clicked.
