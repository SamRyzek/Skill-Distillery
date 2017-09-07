## HTML Form Activation
* The two most important form tag attributes are:
  * `action="URI"` - the name of the server-side program to handle this particular form's input.
  * `method="{GET|POST}"` - whether to use the HTTP GET method or the HTTP POST method to transmit the form content.
* An HTML form needs an element that will activate it, causing the browser to transmit the user's input to the server.
  * The most obvious and traditional example is a Submit button.
  
    ```html
    <input type='submit' value='Click Me'>
    ```
    * A form's first Submit button is its default button.
      * Hitting Enter in the browser triggers the default button.
  * 
* Activating the form causes the browser to:
  * Concatenate the form element names and current values into a properly encoded CGI *query string*.
  * Send the specified HTTP method request to the specified action URL:
    * GET: Append the query string to the URL, following a question mark `?`
    * POST: Send the query string as the request body.
    
    <hr />
```
POST /char.cgi HTTP/1.1
Host: example.com
Connection: keep-alive
Content-Length: 179
Cache-Control: max-age=0
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/
webp,*/*;q=0.8
Origin: null
User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/40.0.2214.91 Safari/537.36
Content-Type: application/x-www-form-urlencoded
Accept-Encoding: gzip, deflate
Accept-Language: en-US,en;q=0.8

character_name=Glorb&character_type=Zombie&inclination=neutral&attitude=
nasty&power=Summon+vermin&power=Bad+Breath&catchphrase=GLURRGGGHH%21&pla
yer_level=1&create_character=Create

HTTP/1.1 200 Ok
Connection: close
Content-type: text/plain
Content-length: 18

Character created.
```


[Prev](HTMLForms.md) | [Up](../README.md) | [Next](HandsOnHTTP.md)
