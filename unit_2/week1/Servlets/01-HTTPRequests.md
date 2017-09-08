## HTTP Requests

* HTTP defines several request methods.

  * A **GET** request usually comes from a user typing a URL into the browser or clicking on a link.

    * GET requests typically retrieve information.

    * GETs encode HTTP request parameters within the URL.

  * A **POST** request usually comes from an HTML form, where

  ```
  <form method="post" ...>.
  ```

    * POSTs are usually used to create or modify a resource.

    * POSTs pass HTTP request parameters as part of the message body.

  * The **PUT** method requests that the body of the request be stored at the specified URI.

  * The **DELETE** method requests that the data at the specified URI is removed.

  * The **TRACE** method requests that the body of the request be returned intact; this is used for debugging.

  * The **HEAD** method is used whenever the client wants only header information, not the data in the document.

* GETs and POSTs make up the majority of HTTP requests.

<hr>
A sample HTTP **GET** request:

```
GET /Stocks/StockPrice?symbol=goog HTTP/1.1
Host: localhost:8080
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.0; en-US; rv:1.7.8) Gecko/20050511 Firefox/1.0.4
Accept: text/xml,application/xml,application/xhtml+xml,text/html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5
Accept-Language: en,en-us;q=0.5
Accept-Encoding: gzip,deflate
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7
Keep-Alive: 300
Connection: keep-alive
Referer: http://localhost:8080/Servlet/StockQuery1.html
```

A sample HTTP **POST** request:

```
POST /Stocks/StockPrice HTTP/1.1
Host: localhost:8080
User-Agent: Mozilla/5.0 (Windows; U; Windows NT 5.0; en-US; rv:1.7.8)
Gecko/20050511 Firefox/1.0.4
Accept: text/xml,application/xml,application/xhtml+xml,text/
html;q=0.9,text/plain;q=0.8,image/png,*/*;q=0.5
Accept-Language: en,en-us;q=0.5
Accept-Encoding: gzip,deflate
Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7
Keep-Alive: 300
Connection: keep-alive
Referer: http://localhost:8080/Servlet/StockQuery1.html
Content-Type: application/x-www-form-urlencoded
Content-Length: 10

symbol=goog
```

For more information on HTTP request methods, see: http://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html.

[Prev](README.md) | [Up](../README.md) | [Next](02-HttpServlet.md)
