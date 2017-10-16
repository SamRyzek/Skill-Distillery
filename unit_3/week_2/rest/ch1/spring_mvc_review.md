# Remember Spring MVC?

In weeks prior we went over developing a web application with Spring-MVC. Let's go over a brief overview of what Spring-MVC is:

- Spring-MVC is a web application framework that leverages the Model-View-Controller pattern to make dynamically generated web pages.

- Spring-MVC uses ```@Controller```, ```@RequestMapping``` to take HTTP requests and map those to a **controller** which runs a function and returns a **view** (either by name, or with a complex object `ModelAndView`.

- A Spring-MVC ```@RequestMapping``` returns a view, which is usually a HTML or JSP (Java Server Page) file. Spring-MVC then passes data via the model(e.g a java object) to the view which then uses it to add custom data to a web page and returns it in a response to the client.

- The JSP views returned from a Spring-MVC view use a template language called *Expression Language* to access data inside of the JSP. In addition to Expression Language, JSP's use a tag library called **JSTL** or *Java Standard Template Library* to format the template page.

[Previous](request_response.md) | [Next](../ch2/README.md)
