## What is Spring MVC?

* The goal of Spring MVC is to make it easier to build Java web applications.
  
  * You no longer extend **HttpServlet**, instead Spring MVC provides the servlet for you.
  
  * You will define your controller logic in a POJO annotated with `@Controller`.
  
  * Spring MVC calls methods in your `@Controller` class as requests are received.
  
  * Spring MVC also eliminates calls to `request.getParameter()` by replacing them with auto-populated method parameters.
  
    * You don't even have to convert request parameters to primitve data types, Spring MVC will do that for you.
  
  * Rather than using a **RequestDispatcher** to invoke a JSP, you will simply identify the JSP by name as part of the returned value of your method.
  
  * The full power of Spring is now available for you to take advantage of in your web applications.
  
    * You can still have Spring instantiate and configure objects for you.
  
<hr>

[Prev](mvc_overview.md) | [Up](../README.md) | [Next](components_of_spring_mvc.md)
