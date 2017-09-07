## URIs and URLs
* A fundamental component of the web is the need to identify, in a concise and globally unique way, a particular information resource.
  * For this Tim Berners-Lee devised what became the Uniform Resource Identifier or **URI**.
* A URI is text string beginning with a scheme, followed by a colon, followed by a scheme-specific part.
  * What follows the first colon depends on the specific scheme.
* One scheme, urn (for Uniform Resource Name), allows referencing of various existing identification systems:

  ```html
  urn:isbn:978-0-596-00357-9
  urn:ietf:rfc:3896
  ```
* The most important kind of Internet URI is the Uniform Resource Locator or **URL**, which specifies how to retrieve a resource.
  * In an Internet URL, the scheme is typically an application protocol, followed by a hostname and a path to the resource on that host:
  * Login and port information can be included.
  
  ```html
  http://www.example.com/content/somepage.html
  ftp://user2:mypass@ftp.example.com/pub/somefile.txt
  rtsp://media.example.com:88/videos/somevideo.avi
  ```
* Other forms of URL are common:

  ```html
  mailto:dobbs@example.com
  jdbc:oracle:thin:@localhost:1521/testdb
  ```

<hr />
Internet URIs leverage the existing Domain Name System (DNS), which establishes registered, globally unique, hierarchical domain names. That is, a resouce identified with the URI `http://example.com/schemas` can be assumed to be unique to, and controlled by, the owners of the `example.com` domain. Note that a URI does NOT necessarily refer to an actual item that can be retrieved. In this example, there may be no page to be found at `http://example.com/schemas`, or even a web server with that name. The URI is just used to differentiate a resource from somebody else's. This form of URI is commonly used with XML namespaces.

A URL implies there is actually a resource to be accessed at the named server using the specified scheme. URLs are the basis of HTML hypertext links. A URL provides sufficient information to access the reqource over a network. The port number is implied, defaulting to the well-known port associated with the protocol identified by the scheme. If the server is listening on an alternate port, the port number follows the hostname, separated by a colon.

Web URL:
```

Scheme      Scheme-specific part
vvvv vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
http://www.w3.org/Addressing/#rfc3986
^^^    ^^^^^^^^^ ^^^^^^^^^^^^^^^^^^^^
How      Where          What
```
Mail URL:
```

Scheme                     Scheme-specific part
vvvvvv vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv
mailto:dobbs@example.com?subject=Need%20info&body=Please%20send%catalog
```

[Prev](HTML.md) | [Up](../README.md) | [Next](HTTP.md)
