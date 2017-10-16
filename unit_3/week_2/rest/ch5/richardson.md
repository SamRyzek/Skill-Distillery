## Richardson Maturity Model

Up to this point we have discussed REST is a very broad sense. There are however specific guidelines associated with properly implementing RESTful protocols.

Leonard Richardson developed a model that divides the principles of REST into 3 steps. You can view them [here][richardson]. These can be used to grade your API according to the constraints of REST.

### The glory of REST
![rest img][gloryofRESTImage]

### 0: Swamp of POX
**Level 0**  
* Tunnels the request and response through its protocol without using the protocol to indicate application state. It will use only one entry point (URI) and one kind of method (typically POST). —> e.g. SOAP

### 1: Resources
**Level 1**  
* API can distinguish between different resources. Uses multiple URIs, each URI is the entry point to a specific resource. Indicates specific resources with id: (e.g. example.org/products, example.org/products/1) -> Still only uses (GET/POST)

### 2: HTTP Verbs
**Level 2**
* Use protocol properties in order to deal with scalability and failures (i.e. Status). Use correct verbs for correct process (GET/PUT/POST/DELETE). Strong separation between safe GET and unsafe modification verbs.

### 3: HyperMedia Controls
* HATEOAS (HyperText As The Engine Of Application State). Introduces the concept of a self documenting resource. The response to a request will include information about how to interact with the resource (i.e. additional URIs that can be accessed and the relative links they should be appended to. e.g:

  * {linkRel : “/doctors/mjones”, uri : “/slots/1234/appointment”} which would request the appointment document for a specific doctor at a specific slot.


[Previous](README.md) | [Next](review.md)


[richardson]:http://martinfowler.com/articles/richardsonMaturityModel.html
[gloryofRESTImage]:http://martinfowler.com/articles/images/richardsonMaturityModel/overview.png
