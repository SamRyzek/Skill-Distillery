## HTTP Headers
* HTTP defines four general categories of header:
  * General headers
  * Request headers
  * Response headers
  * Entity headers
    * In HTTP the term entity refers to any content sent by the server or client.
* HTTP headers follow a format used by earlier protocols such as SMTP and NNTP.
  ```
  Header-name: [header value]
  ```
  * The header name occurs at the beginning of a line.
  * Any following lines that begin with whitespace (space or tab) are part of the preceding header's value.
  * Header names are case-insensitive and do not contain spaces.
  * A header is not required to have a value.
* Headers allow HTTP clients and servers to:
  * Exchange "meta-information" about documents.
  * Negotiate conditional requests (If-Modified-Since: date).
  * Negotiate prefered and acceptible content types.
  * Perform HTTP basic or digest access authentication.
  * Control caching and proxy server behavior.

<hr />
Example HTTP GET transaction:

*(Client connects to web server via socket connection on port 80)*
```
GET /index.html HTTP/1.0                                                             Request line
Connection: Keep-Alive                                                             General header
User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:11.0)                           Request header
Accept: image/gif, image/x-xbitmap, image/jpeg, */*                                Request header
                                                Carriage-return terminates client request headers
HTTP/1.1 200 OK                                                                     Response line
Connection: Close                                                                  General header
Date: Mon, 04 Aug 2014 20:28:06 GMT                                                General header
Server: Apache/2.2.29 (CentOS)                                                    Response header
Content-Type: text/html                                                             Entity header
Content-Length: 249                                                                 Entity header
                                               Carriage-return terminates server response headers
<HTML>                                                                    Entity body from server
<HEAD><TITLE>Welcome to my Web Site</TITLE></HEAD>                        Entity body from server
<BODY>This is a sample page...                                            Entity body from server
```
*(Server closes socket connection after the entity-body is sent)*

Example HTTP POST transaction:

*(Client connects to web server via socket connection on port 80)*
```
POST /cgi-bin/guestbook HTTP/1.0                                                     Request line
Connection: Keep-Alive                                                             General header
User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64; rv:11.0)                           Request header
Accept: image/gif, image/x-xbitmap, image/jpeg, */*                                Request header
Content-Type: text/plain                                                            Entity header
Content-Length: 37                                                                  Entity header
                                                Carriage-return terminates client request headers
Hello, I’m Bob Dobbs! Nice web site!                                      Entity body from client
                                                                          Entity body from client
HTTP/1.1 200 OK                                                                     Response line
Connection: Close                                                                  General header
Date: Mon, 04 Aug 2014 20:28:06 GMT                                                General header
Server: Apache/2.2.29 (CentOS)                                                    Response header
Content-Type: text/html                                                             Entity header
Content-Length: 100                                                                 Entity header
                                               Carriage-return terminates server response headers
<HTML>                                                                    Entity body from server
<HEAD><TITLE>Thanks!</TITLE></HEAD>                                       Entity body from server
<BODY>You’ve been added to my guest book.</BODY>                          Entity body from server
</HTML>                                                                   Entity body from server
```
*(Server closes socket connection after the entity-body is sent)*


[Prev](HTTP.md) | [Up](../README.md) | [Next](GetPost.md)
