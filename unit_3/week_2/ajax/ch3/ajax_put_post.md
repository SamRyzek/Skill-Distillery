## Requests with a body

* Up to this point we have only discussed getting data from a server. In order to do full CRUD asynchronously, we need to learn how to send data to the server.

* GET requests do not have access to a request body, PUT and POST do.

* In Spring MVC we executed POST requests using a form action. Behind the scenes Spring was adding the form elements into the body of the request in a structured fashion.

* In order to perform RESTful updates with AJAX you will need to provide additional data (the updateD object) to the server.

* In previous examples we didn't pass any data, thus not providing a body with our request.

* In order to include a Request Body with our request, we must:
  *  convert the JSON to a DOMString that can be conveyed over HTTP
  *  set the Request Headers to indicate that the data being received is JSON

### Converting JSON to a DOMString

* The `JSON.stringify(value)` method converts a JavaScript value to a JSON string.

```javascript
var obj = { name : 'Jim', age : 28 };
var jsonString = JSON.stringify(obj); // '{ "name" : "Jim", "age" : 28 }'
```

* Once 'stringified', the JSON can be conveyed over HTTP and interpreted by the server

* We calso need to let the server know we are sending json as opposed to text or html. If we didn't let the server know to expect JSON, and we receive a Response Status of 415 (unsupported media type):

```bash
application.js:27 POST http://localhost:8080/RestAPI/api/users 415 (Unsupported Media Type)

415: <!DOCTYPE html><html><head><title>Apache Tomcat/8.0.30 - Error
 report</title><style type="text/css">H1 {font-family:Tahoma,Arial,sans
 -serif;color:white;background-color:#525D76;font-size:22px;} H2 {font-
 family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;
 font-size:16px;} H3 {font-family:Tahoma,Arial,sans-serif;color:white;
 background-color:#525D76;font-size:14px;} BODY {font-family:Tahoma,
 Arial,sans-serif;color:black;background-color:white;} B {font-
 family:Tahoma,Arial,sans-serif;color:white;background-color:#525D76;}
 P {font-family:Tahoma,Arial,sans-serif;background:white;color:black;
 font-size:12px;}A {color : black;}A.name {color : black;}.line
 {height: 1px; background-color: #525D76; border: none;}</style> </
 head><body><h1>HTTP Status 415 - </h1><div class="line"></div><p><b>
 type</b> Status report</p><p><b>message</b> <u></u></p><p><b>
 description</b> <u>The server refused this request because the
 request entity is in a format not supported by the requested resource
 for the requested method.</u></p><hr class="line"><h3>Apache Tomcat/8.
 0.30</h3></body></html>
```

* This error almost always indicates that you haven't set the Request Headers 'Content-type' to indicate to the server that the information you have included should be interpreted as JSON.
  * We need to add an additional setting to the ajax object `contentType:'application/json'`.

### PUT request
* Thinking back to our Quiz REST API the PUT route to update a Quiz entity was `PUT /rest/quizzes/{id}`.

```javascript
var quiz = {name: "Updated Quiz Name"}; //object with updated name

$.ajax({
    type: "PUT",
    url: "api/quizzes/1",             //indicates updating quiz with id=1
    dataType: "json",
    contentType: 'application/json',  //setting the request headers content-type
    data: JSON.stringify(quiz)        //the data being added to the request body
});
```

### POST request
* Thinking back to our Quiz REST API the POST route to update a Quiz entity was `POST /rest/quizzes`.

```javascript
var quiz = {name: "New Quiz Name"}; //new object to be persisted to database

$.ajax({
    type: "POST",
    url: "api/quizzes",             //indicates creating a new quiz
    dataType: "json",
    contentType: 'application/json',  //setting the request headers content-type
    data: JSON.stringify(quiz)        //the data being added to the request body
});
```

[Previous](pokemonShow.md) | [Next](ajax_delete.md)
