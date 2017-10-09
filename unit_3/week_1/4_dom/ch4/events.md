### Labs
0: Create an HTML file named `listen.html` and a JavaScript file named `listen.js`  

1: Write a well formed HTML document in `listen.html` and add an `<h1>` that says 'hello world'.  

2: Import your `listen.js` file into your `listen.html` file using `<script src=''></script>`  

3: Add an unordered list of 5 list items to the HTML (don't put any text between the `<li>`s)  

4: Next to each of the list items, place a button with the text 'Edit' on it.  
```html
<li></li><button>Edit</button>
```

5: In your `listen.js` file, assign a 'click' event listener to each of your 'Edit' buttons. Do not create 5 separate callback function, rather create 1 that works for all 5 buttons.

6: When the 'Edit' button is clicked, it should use a `prompt` to prompt the user for a new value to place in that list item.  

7: When the user enters a new value for the list item, select the list item, and change it's `text()` to match the entered text.

**Hint: the list item is the previous sibling of whichever edit button has been clicked. If there a jQuery function to find the previous sibling?**  

Stretch Goal:
Add a Delete button next to Edit button. When clicked it should remove the text inside of the `<li>`.

```html
<li>Stuff</li><button>Edit</button><button>Delete</button>
```

[Previous](keyLogger.md) | [Next](../ch5/README.md)
