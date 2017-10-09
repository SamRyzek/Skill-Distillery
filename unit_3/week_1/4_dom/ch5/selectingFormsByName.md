### Selecting Forms and Form Attributes by Name

* The Document object makes selecting forms incredibly easy using the `id` or `name` attribute on an HTML form.

```html
<body>
	<form id='myFormID' name='myForm'>
	</form>

    <script type="text/javascript">
	    console.log($('#myFormID')); // <form name='myForm'> ... </form>
	    console.log($(myForm)); // <form name='myForm'> ... </form>
    </script>
</body>
```

* Similarly you can select the `input`s from within a form using their name attributes with CSS style selectors:

```html
<body>
	<form id='myFormID' name='myForm'>
		<input type='text' name='fname' />
		<input type='text' name='lname' />
		<input type='submit' name='submit' value='submit' />
	</form>

  <script type="text/javascript">
    console.log($('#myFormID input[name="fname"]')); // <input type='text' name='fname' />
    console.log($('#myFormID input[name="lname"]')); // <input type='text' name='lname' />
    console.log($('#myFormID input[name="submit"]')); // <input type='submit' name='submit' value='submit' />
  </script>
</body>
```

* Luckily, there is a less verbose way to access form elements. HTML forms have a unique functionality to be accessed exclusively by name attributes.

* Using the same example as above we can chain together name attributes to return the exact form element we are looking for.

```html
<body>
	<form name='myForm'>
		<input type='text' name='fname' />
		<input type='text' name='lname' />
		<input type='submit' name='submit' value='submit' />
	</form>

  <script type="text/javascript">
    console.log($(myForm.fname)); // <input type='text' name='fname' />
    console.log($(myForm.lname)); // <input type='text' name='lname' />
    console.log($(myForm.submit)); // <input type='submit' name='submit' value='submit' />
  </script>
</body>
```
* We need to wrap the `myForm.fname` selector in `$()` to ensure we are being returned a jQuery object as opposed to an HTMLElement.

* With these elements selected, we can access their html attributes as properties on their objects:  

```html
<body>
	<form name='myForm'>
		<input type='text' name='fname' />
		<input type='text' name='lname' />
		<input type='submit' name='submit' value='submit' />
	</form>

  <script type="text/javascript">
    var $fname = $(myForm.fname);
    var $lname = $(myForm.lname);
    var $submit = $(myForm.submit);

		console.log($fname.attr('name')); // fname
		console.log($lname.attr('name')); // lname
		console.log($submit.attr('name')); // submit
		console.log($submit.val()); // submit
  </script>
</body>
```

* This means that we can select values users enter to our fields with the `val()` method when the form is submitted.

Lets use this HTML form as an example:
```html
<form name="createUser">
	<input name="email" value="andrew@skilldistillery.com">
	<input name="username" value="andrewc">
	<input name="password" value="password">
	<input name="submit" type="submit">
</form>
```

Each form element has a value associated with it. jQuery provides us with a method that we can use to extract this property. It is called `.val()`. If we want to extract a single value we can target an element and call `.val()` on it.
```javascript
$(createUser.email).val();        //yields andrew@skilldistillery.com
```

### Hands On
* Create a form with two text input fields and a submit button.
* Assign the input fields default values.
* Print out the values of those input fields to the console.

<hr>

We could also use advanced selectors and the `.each()` jQuery function to get all of the values out of a form:

```javascript
  var $formInputs = $(createUser).children().not(':input[type=button], :input[type=submit]');

$formInputs.each(function(index){
    console.log($(this).val());

    /*Would print:
      andrew@skilldistillery.com
      andrewc
      password
    */
});
```

### serializeArray()
Typically when you are submitting a form you would send a post request to a server with the data collected from the form. If we are using json the server will expect us to extract the information from the form and create a standard js object from this information. We can do this easily by extracting the values from the form via the name property of the elements. jQuery however provides us with a utility called `.serializeArray()` which extracts all information from a form and places it into an array of objects. For example with form

```html
<form name="myForm">
    <input name="fname" val="Andrew">
    <input name="lname" val="Conlin">
</form>
```
```javascript
  $(myForm).serializeArray();

  //returns [{name:"fname",value:"Andrew"},{name:"lname",value:"Conlin"}]
```
This is not a standard js object, but we can easily convert it into one using the jQuery `each` function.

```javascript
  var person = {};
  var $formValues = $(myForm).serializeArray();
  $.each($formValues, function(){
      person[this.name] = this.value;
  });

  //object ={fname:"Andrew",lname:"Conlin"}
```

[Previous](README.md) | [Next](formsAndEventListeners.md)
