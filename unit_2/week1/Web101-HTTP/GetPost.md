## GET and POST
### GET
* CGI **GET** responses should be *idempotent*, meaning a given request has no new side effects no matter how many times the request is repeated..
  * That is, a **GET** request should do no more than retrieve a document.
* A form using the **GET** method must send its content - the query parameters - in the request URI.
  * The URI also includes the name of the CGI script handling the query.
  * Headers are not used to transmit form content.
* A question mark, ?, separates the script URI from the query parameters.

  ```
  GET /cgi-bin/doit.cgi?submit=Submit HTTP/1.0
  ```
*  Ampersands, &, delimit the parameters.

  ```
  GET /cgi-bin/doit.cgi?submit=Submit&search=Products HTTP/1.0
  ```
  * This forms the *CGI Query String*: `submit=Submit&search=Products`
*  Since a request URI cannot contain spaces, and since /, ?, &, =, and other characters have special meanings in URIs, the entire query string must be *URL encoded*:

### POST
* The **POST** method is intended for providing information to a server that might be used by the server-side code to modify content on the site.
  * Because POSTed data is not guaranteed to be idempotent, browsers are required to warn the user before posting the same form a second time.
  * It's perfectly fine for a **POST** to actually be idempotent (having no new side-effects), and POST can have advantages over GET.
    * For a large, complex form the length of the URI query string can be awkward and even run into length limits of various browsers and web servers.
    * Sensitive query parameters should be sent only by POST.
* When a form is POSTed, its contents are sent as the request entity body rather than in the request URI used by GET.
  * For a basic form, the form content is a fully URL-encoded query string just like the equivalent GET query string.
  
  ```
  Content-type: application/x-www-form-urlencoded
  ```
  * For complex or binary form content such as a form containing a file upload element, the content is broken into multiple parts.
  
  ```
  Content-type: multipart/form-data; boundary=---ArbitraryStringToUseBetweenChunksOfDataXYZABCRubberDucky
  ```
* Using POST instead of GET does not provide confidentiality.
  * Form parameter names and options are visible simply by using "view source" in the browser.
  * Posted form content is easily seen using packet-sniffing software.

### URL Encoding
A URL is a text string that cannot contain spaces (spaces delimit the three parts of a valid HTTP request), or any characters other than letters, digits, -, _, ., and ~. Other characters, such as /, ?, &, =, and so on have special meanings in web URLs. To include these special characters as literals in a URL we must encode them using URL encoding:
* Each space character can be encoded as a plus sign, +:

  ```
  http://example.com/My+Cool+Page.html
  ```
represents a resource named "/My Cool Page.html"
* Other reserved characters like ?, &, /, %, etc. are encoded with *percent encoding*: the character is replaced by its hexadecimal character code, preceded by a percent sign: 

  ```
  http://example.com/What+Is+HTML%2FCSS%2FJavaScript%3F.html
  ```
  Represents a resource named "/What Is HTML/CSS/JavaScript?.html".

Note that a space can be represented either as a +, or as %20. A newline is %0A. A percent sign is %25.
  
<hr />
Because GET requests are idempotent (multiple accesses have no new side effects) and because all query parameters are in the URI query string, GET query strings have some conveniences:
* A query-string URL can be bookmarked, or shared, or embedded in an HTML `href` link.
* The result of a GET with a URI query string can be cached by a browser or proxy server.
* The query string can be modified by the user and resubmitted as a new query.

Pre-built query string URIs are often embedded in href links. For example, a web-based image galley might have "Previous" and "Next" links with URIs that include page number parameters for the previous and next page numbers in the series. Each new gallery page, as it's being generated by the server-side CGI script, includes the correct "Previous" and "Next" page numbers relative to the new page. This also allows a user to navigate the gallery by manually editing the page number parameter in the browser address bar - that is, by hacking the URL. For these same reasons, never use GET request parameters that include sensitive information like credit card or bank account numbers.
* A user might unwittingly bookmark or share the URL (including its query string parameters and values), exposing the sensitive data.
* Request URIs are recorded in clear text both in browser history and in web server log files, where the sensitive data might be found by malicious actors.

When a browser submits a simple form via GET or POST, it concatenates the query parameters as name=value pairs with data URL-encoded as needed, indicating this with a **Content-type:** header:

```
Content-Type: application/x-www-form-urlencoded
```
For a GET the form contents are in the query URI, for a POST in the entity body. When form content includes binary data (like a file upload), the form uses POST. In this case the browser indicates the multipart content type, specifying an arbitrary string for marking the boundaries between the parts of the content:

```
Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryPEeckgHsmAb8xol
```
This messaging format originated with email MIME attachments, though email's SMTP protocol, being textonly, requires the binary content to be encoded for transfer in a bin-to-text encoding such as base64. HTTP however allows binary transfers. So form content that includes binary data like one or more file upload fields will be broken by the browser into multiple parts, with standard form element content sent in a text piece, and binary pieces sent in separate pieces, with the content boundary separating each of the parts.

```
POST /char.cgi HTTP/1.1
Host: example.com
Connection: keep-alive
Content-Length: 29970
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/
*;q=0.8
User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like
Gecko) Chrome/40.0.2214.91 Safari/537.36
Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryPEeckgHsmAb8xol
Accept-Encoding: gzip, deflate
Accept-Language: en-US,en;q=0.8

------WebKitFormBoundaryPEeckgHsmAb8xol
Content-Disposition: form-data; name="upload_avatar"

Upload
------WebKitFormBoundaryPEeckgHsmAb8xol
Content-Disposition: form-data; name="avatarfile"; filename="myzombie3.png"
Content-Type: image/png

.... BINARY IMAGE FILE CONTENT ...
------WebKitFormBoundary6PEeckgHsmAb8xol--
```

The server-side code receiving the query uses headers, newlines, and the boundary strings to delineate the various parts of the content as it reads it from its standard input.

[Prev](HTTPHeaders.md) | [Up](../README.md) | [Next](HTTPStatusCodes.md)
