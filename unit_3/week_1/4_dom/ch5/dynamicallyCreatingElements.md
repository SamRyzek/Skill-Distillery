### Dynamically Creating Elements
* jQuery is capable of creating new `Element` objects programmatically.

```javascript
var $div = $('<div>');
```

* Once created, elements can have attributes assigned to them.

```javascript
var $newDiv = $('<div>');
$newDiv.html('this is my new div');
$newDiv.attr('id','myDiv')
console.log($newDiv)
```

* Creating a new element is similar to how we select elements using jQuery. To target, we put the css selector that corresponds to an element in the page. To create we put the html tag that corresponds to the element we want to create.

```javascript
$('<h1>') // yields <h1></h1> ,the closing tag is automatically added.
$('<h1></h1>') //yields <h1></h1>, as we would expect.
$('<h1>Hello World</h1>') //yields <h1>Hello World</h1>
```

* Created elements have no relationship to the DOM, until they are appended (i.e. added) to a Document element using `.append(element)`. Once an element is appended, it is visible to the user.

```javascript
var $div = $('<div>');
$div.text('Hello World');
$div.attr('id','hello')

// add the div to the end of the body
$('body').append($div);
```

### Hands On
* Create a `<h1>` element using jQuery
* Set the `<h1>` elements text to Hello World
* Append the element to the body

<hr>

* While `append` is the most often used function, jQuery provides a number of other functions to append content to a specific location in the dom.

* `.append()`: adds an element you have created as a child of the selected element.
```javascript
var $li = $('<li>new list item</li>');
$('#myList').append($li);
```
Results in :
```html
  <ul id="myList">
    <li>original list item</li>
    <li>new list item</li>
  </ul>
```

* `.prepend()`: adds an element you have created as the first child of the selected element.
```javascript
var $li = $('<li>new list item</li>');
$('#myList').prepend($li);
```
Results in :
```html
  <ul id="myList">
    <li>new list item</li>
    <li>original list item</li>
  </ul>
```
* `.after()`: adds an elements after the selected element or elements.
* `.before()`: adds an elements before the selected element or elements.

#### Appending Nested Elements Dynamically
* To populate a list of items dynamically from an array of unknown size, you can use a series of loops, appending each item to the unordered list and then appending the updated element to the document.

```javascript
var items = [
		'apple',
		'banana',
		'coconut'
	];

var $ul = $('<ul>');

items.forEach(function(value, index, array) {
	// create a new list item;
	var $li = $('<li>');

	// assign the value at the current position
	// in the array to the list item's text value
	$li.text(value);

	// append the list item to the unordered list
	$ul.append(li);
});

// append the entire unordered list to the body
$('body')append(ul);
```

### Hands On
* Create an array of your favorite foods.
* Create an ordered list element using jQuery
* Loop over the array of foods creating a `<li>` for each food and setting its text accordingly.
* Append the entire ordered list to the body.

<hr>

#### Appending Forms to the DOM
* There are some situations in which you will want to create a form. These include users wanting to check out (they need to enter billing info), clicking on contact buttons, etc.

* Forms can be created and appended in the same way as any other elements:  

```html
<body>
    <script type="text/javascript">
		  // create the form, give it a name
			var $form = $('<form>');
			$form.attr('name','contactForm');

			// create an input field
			var $fname = $('<input>');
			$fname.attr('name','fname'); // assign a name attribute
			$fname.attr('id','fname'); // assign a id attribute
			$fname.attr('type','text'); // assign a type attribute
			$fname.attr('placeholder','First Name'); // assign a placeholder attribute

			// append the input to the form
			$form.append($fname);

			// create a submit input
			var $submit = $('<input>');
			$submit.attr('name','submit'); // assign a name attribute
			$submit.attr('type','submit'); // assign a type attribute
			$submit.attr('value','Post Name'); // assign a value attribute

			// Assign an event listener to the submit button
			$submit.click(function(e) {
				e.preventDefault();

				console.log($(contactForm.fname).val());

				// clear the form data
				contactForm.reset();
			});

			// add the input to the form
			contactForm.append($submit);


			// add the form to the body
			$('body').append($form);
    </script>
</body>
```

### Hands On
* Create a page load event listener
* Inside of this function create a form element using js and assign it a name attribute
* Create two input field elements and append them to the form element
* Create a submit button and append it to the form
* Append the form to the body


[Previous](formsAndEventListeners.md) | [Next](dynamicallyRemoveElements.md)
