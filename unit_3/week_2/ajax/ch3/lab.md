## Labs

### AJAX

### Goals
* Successfully include and use jQuery in your projects
* Get comfortable dynamically building elements in the DOM using jQuery
* Use jQuery ajax calls to execute GET requests

#### Ajax basics

0: Create an HTML document `ajaxList.html` and a script file `app.js`. Make sure to include the jQuery dependency.  

1: Use the provided json data from, http://kkane106.github.io/mlb.json, as your data source.

2: In your HTML document add a button element to the body. Don't forget to add an id property to the button.  

3: In your script file attach an event lister to the button you created.  

4: Inside of this event listener add an ajax request method, this will be a get, that retrieves the contents of the `.json` file you  created.  

5: Once you have the data returning refactor your success callback method to display the data on the screen.
  * The data should be displayed as a list of the objects returned  (`<ul>`,`<li>`).  
  * The list items should be hyperlinks with the team name that when clicked take you to their specific team sites.  

#### Hint
Your final HTML should look something like this:

```html
<ul>
  <li>
    <a href="http://www.Orioles.MLB.com">Baltimore Orioles</a>
  </li>
  <li>
    <a href="http://www.Redsox.MLB.com">Boston RedSox</a>
  </li>
  <!-- ...-->
</ul>
```



[Previous](using_response_data.md) | [Next](pokemonIndex.md)
