## HTTP

### Request

HTTP requests are comprised of four pieces:  
1: Request line  
2: Request headers  
3: A blank line  
4: Request body  

##### The request line
The Request Line takes the following format `Method Request-URI HTTP-Version`
* The method is a our standard HTTP Request Methods (GET/POST/PUT/DELETE)  
* The request URI is the location where you are requesting resources from.  
* The http-version is which version of HTTP you are using to execute the request. (HTTP/1.1)

##### Request headers
Request headers allow the sender to pass additional information about the nature of the request. It can also contain information about the user sending the request to see if they have the appropriate permissions to access specific info.

##### Body
HTTP Methods can contain an optional body. This body is used to send the actual data being transferred with a request. For example, POST and PUT requests are sending information to create or edit an entity.

GET and DELETE requests do not have a body.

### Response
HTTP responses are similar in their structure:
1: A status line  
2: Response headers  
3: A blank line  
4: Response body  

##### The status line  
The status line includes information about the HTTP-Version and a status code.  

##### Response headers  
Response headers allow the server to pass additional information about the response. Any information that does not belong in the body or headers

##### Response body  
The response body contains the requested information.

[Previous](README.md) | [Next](spring_mvc_review.md)
