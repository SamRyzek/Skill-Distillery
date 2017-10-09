### Dynamically Remove Elements
* When a resource is no longer needed you may want to remove it from the DOM, or remove it and replace it with something else.

* To remove elements from the DOM we use `remove()`. This function removes a selected node from the DOM.

```html
  <div id="div1">Div 1</div>
  <div id="div2">Div 2</div>
```

```javascript
$('#div1').remove();
```

Results in:
```html
  <div id="div2">Div 2</div>
```

If there were nested elements within the `<div>` those elements would be removed as well.

* If you want to remove a full list of items, simply remove the unordered list rather than each list item.

```html
<body>
	<ul id='list'>
		<li>things</li>
		<li>things</li>
		<li>things</li>
		<li>things</li>
		<li>things</li>
		<li>things</li>
		<li>things</li>
	</ul>


  <script type="text/javascript">
  	var $list = $('#list');

    $list.remove();
  </script>
</body>
```

### Hands On
* Create an ordered list with 5 `<li>` elements inside of it in your HTML document.
* Create an event listener for page load.
* Inside of the callback function target the entire list of items.
* Remove all of the nested `<li>` items.

<hr>

* With this syntax you can remove the form from the previous example at the end of the event listener's callback function (we will also print the value to the DOM):

```html
<body>
  <script type="text/javascript">
      // create the form, give it a name
			var $form = $('<form>');
			$form.attr('name','contactForm');

			// create an input field
			var $fname = $('<input>');
			$fname.att('name','fname'); // assign a name attribute
			$fname.att('id','fname'); // assign an id attribute
			$fname.att('type','text'); // assign a type attribute
			$fname.att('placeholder','First Name'); // assign a placeholder attribute

			// append the input to the form
			$form.append($fname);

			// create a submit input
			var $submit = $('<input>');
			$submit.att('name','submit'); // assign a name attribute
			$submit.att('type','submit'); // assign a type attribute
			$submit.att('value','Post Name'); // assign a value attribute

			// Assign an event listener to the submit button
			$submit.click(function(e) {
				e.preventDefault();

				var $form = $(this);
				// print the fname value to the console
				console.log($('#fname').val());

				// remove the form once submitted
				$form.remove();
			});

			// add the input to the form
			$form.append($submit);


			// add the form to the body
			$('body')append($form);
  </script>
</body>
```


[Previous](dynamicallyCreatingElements.md) | [Next](domMethods.md)
