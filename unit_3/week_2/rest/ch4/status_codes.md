## HTTP Status codes
Status codes give us information on the status of our request. There are five classes of HTTP response codes indicated by the first digit of the code.

**1XX**->  Informational: Im going to send you some information

**2XX's**->  Success: Your request was successful!  

**3XX's**->  Location changed/redirect: I'm going to send you somewhere else  

**4XX's**-> Client error: You messed up

**5XX's**-> Server error: I messed up

As you spend more and more time programming you will start to become familiar with status codes you see regularly. Some important/standard response codes are as follows:
  * 200: OK-the request was successful.
  * 201: Created- request was successful and a new resource was created.
  * 202: Accepted- request was received but not acted upon.
  * 401: Unauthorized- need authentication to access the resource.
  * 404: Not found- can not find resource.
  * 415: Unsupported media type- format of the request data is not supported.
  * 500: Internal server error- server has encountered an error.

For a full list of status codes look at the following resources!
* [HTTP status codes for beginners][Status codes for beginners]
* [Full list of status codes][Full List]

[Previous](README.md) | [Next](spring_request_response.md)


[Status codes for beginners]:https://www.addedbytes.com/articles/for-beginners/http-status-codes/
[Full List]:http://www.restapitutorial.com/httpstatuscodes.html
