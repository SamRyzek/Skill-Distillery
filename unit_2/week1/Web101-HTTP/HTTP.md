## HTTP: Hypertext Transfer Protocol
* The third key component of the web is the Hypertext Trasfer Protocol, HTTP.
  * This is the language a browser or other client program uses to request a page from a web server, and with which the server responds.
* HTTP is a simple protocol transmitted in human-readable text
  * It includes only a small number of possible requests: GET, POST, HEAD, OPTIONS, etc.
* A request consists of `REQUEST RESOURCE_URI PROTOCOL_VERSION`

  ```
  GET /content/somepage.html HTTP/1.0
  ```
  * The client can optionally send request headers.
  
  ```
  GET /content/somepage.html HTTP/1.1
  Host: www.example.com
  Connection: Keep-Alive
  ```
  * A blank line after the last header indicates the end of the request.
  * The RESOURCE_URI string must not contain spaces - that is, exactly two spaces are allowed in the request.

* A response begins `PROTOCOL_VERSION RESPONSE_CODE REASON`

  ```
  HTTP/1.1 200 OK
  ```
  * Optional headers can (and just about always do) follow the response line.
  
  ```
  HTTP/1.1 301 Moved permanently
  Content-Length: 322
  
  <html><head><title>301 Moved permanently</title></head>
  <body><p>The document has moved <a href="http://example.com/
  pages/somepage.html">here</a>.</p><hr> .....
  ```
  * An extra blank line separates the request or response and its headers from any content to follow.
  
<hr />

[Prev](UriUrl.md) | [Up](../README.md) | [Next](HTTPHeaders.md)
