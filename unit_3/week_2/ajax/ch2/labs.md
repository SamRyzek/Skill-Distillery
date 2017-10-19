## Labs

1: Create two files xmlhttp.html and app.js.  

2: Source your app.js file into your html doc.  

* Write a onload function in your app.js file that prints out a message that the page has been loaded.  

3: In your onload function create an XMLHTTPRequest object that will execute a `GET` request to `https://kkane106.github.io/data.json`  

4: Create an onreadystatechange function prints out the returned responseText if the request was successful.  

5: If the request fails, write code that prints out that an error occurred to the console.  

6: Change your onreadystatechange code to convert the responseText to json, and print out the first and last names of each returned object.  

[Previous](convertJSON.md) | [Next](../ch3/README.md)
