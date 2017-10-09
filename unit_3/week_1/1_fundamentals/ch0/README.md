## Javascript Overview  

We are on to our second programming language! Over the course of this week we are going to learn about javascript as a browser scripting language. Because this is our second language, we are going to move through the basics much faster than we did with Java. You will see familiar syntax and structure in many aspects of the two languages.

### Where do I write Javascript?

When we are writing client-side js we can write code in two locations.

* Script tags  
HTML has an elements called script tags, `<script></script>`. Inside of this element we can write javascript which will execute on page load. These tags can be placed anywhere within the HTML `<body>` or `<head>`.

* External script files

Alternatively, we can write js in separate files that are saved with the `.js` extension. We can write as many js files as we see fit and import them into an HTML document for use. Information is available based on the order in which the files are imported into the document.

#### How to import a JS file  
 If we want to include a js file in a specific HTML document we can import them using `<script src="myScript.js"></script>` syntax. The src attribute takes the relative path to the js file from the HTML files location.  

```html
<!DOCTYPE html>
<html>
<head>
  <title>js import</title>
</head>
<body>
  <script src="myScript.js"></script>
</body>
</html>
```

An HTML document can import as many scripts as you see fit. These files can be imported in the head or body of the document. You will see many programmers load their scripts at the bottom of the `<body>`. This is to ensure that the entire HTML document has been loaded by the browser before we try to execute any of our scripts.

### Hello World  
1: Create an HTML document called `helloJS.html`.  

2: Set up the documents HTML skeleton.  

3: Inside of your documents body add `<script></script>` tags.  

4: Inside of these tags use the `console.log()` function to print out a message to the web console. It is similar to the java `System.out.println()` function.  

```html
<script>
  console.log('Hello World');
</script>
```

5: In a browser open your `helloJS.html` file. **Cmd + o**

6: Open the Chrome dev tools by pressing `Cmd + Opt + J`.  

7: You should see the message 'Hello World' printed in the console.  

8: Create a second file called `myscript.js`.  

9: In your HTML file, remove the `<script>` tags and move the `console.log()` code into your js file.  

10: Include the js file into your HTML file using the `<script src="">` syntax we discussed earlier.

11: Open the document again in the browser, you should see the same result.  

##### [JS Fundamentals](../README.md) | [Next](1_chromeConsole.md)
