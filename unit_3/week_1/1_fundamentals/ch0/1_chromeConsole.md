## The Chrome console  

The chrome console is going to be our primary debugging tool when writing javascript. Because it is a non compiled language, our errors will not be caught prior to trying to execute the code. All of the client side errors that occur, or print outs we include in our code (using `console.log()`) will show up in the Chrome console.

A link to the Chrome DevTools docs can be found [here][devTools]

### What is it  

Chrome's dev tools are a
> set of web authoring and debugging tools built into Google Chrome. The DevTools provide web developers deep access into the internals of the browser and their web application.  

To open Chromes dev tools we have a few options:
* click the chrome menu in the top right corner and select Tools > Developer Tools.  
* Right click anywhere in the browser and select Inspect Element.  
* Use Cmd + Opt + J to open the Console of the DevTools.  

Up to this point we have used the Elements tab to track our HTML and CSS within the browser. The Console tab is where we will be living while writing our js.

The console is where we will see all the feedback when our code is running in the browser. This can be in the form of error messages or logged information.

### Writing JS
The console can also be used to write live js to interact with your page in real time. Anything saved to the global scope is accessible in the web console.

#### Hands on
1: In a chrome browser, open the DevTools console.  
2: Write the statement `var x = 5;`  
3: Enter just `x` and see what is returned  
4: Log a message `console.log('The value of x is ' + x)`.  
5: Refresh the page, then try to access the value of x. What happens?  

**Note** The undefined message you keep seeing is the return value of the js statement you executed. If there is no return value, it is undefined.

##### [Prev](README.md) | [Next](../ch1-types/README.md)

[devTools]:https://developers.google.com/web/tools/chrome-devtools/
