## HTTP Status Codes

* HTTP server status codes are three-digit numbers and categorized, with each category using a range of 100 possible codes.

  **1xx** Informational.
  * Request received, continuing response. Seldom used.

  **2xx** Successful.
  * `200 OK` is the standard success response for a GET or POST.
  * `201 Created` request resulted in creation of a resource on the server.
    * The server should return the URL representing the new resource in the Location: response header..
  * `206 Partial Content` client sent `GET` with a `Range:` request header, server provided just the requested range of content.

  **3xx** Redirection.
  * Resource has moved, or has multiple versions, etc.; repeat request with the new URI provided in the response.

  **4xx** Client Error.
  * `404 Not found` is common - client requested a nonexistent resource.
  * `401 Unauthorized` initiates an HTTP authentication exchange.
  * `403 Forbidden` might indicate a security violation.

  **5xx** Server Error.
  * `500 Internal Server Error` usually indicates a problem with server-side code - a syntax error in a PHP or Perl script for example, or database error.
  * `501 Not Implemented` client sent an invalid request command.
  * `503 Service Unavailable` temporary server overload.

<hr>

[Status Code Definitions](https://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html)

[Prev](GetPost.md) | [Up](../README.md) | [Next](HTMLForms.md)
