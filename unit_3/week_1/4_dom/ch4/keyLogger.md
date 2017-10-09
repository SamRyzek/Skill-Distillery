### Labs
0: Create files named keylogger.js and keylogger.html  

1: Create an eventlistener that prints the word 'Down' to console when a 'keydown' event is observed  

2: Refactor your eventlistener from #1 to print the keyboard character that was pressed. A link to all keyboard event key codes is shown below.  

3: Refactor your eventlistener from #2 to not print anything if a non-character value was pressed. (make sure that they are lowercase by default)  

4: Refactor your eventlistener from #3 to observe spaces (i.e. add an empty space when the spacebar was pressed).  

5: Refactor your eventlistener from #4 to observe backspacing.  
**Think string manipulation, how could you remove the last character of a string?**

6: Refactor your eventlistener from #5 to observe periods and commas.  

7: Now that you can observe character key presses, and spacebar presses, display them to the web page as they are pressed. Write a function that takes a string (the character pressed), selects a div on the page, and appends the character to the end of the text content of the div on each keydown event.  

KeyCodes: https://css-tricks.com/snippets/javascript/javascript-keycodes/


[Previous](eventObject.md) | [Next](events.md)
