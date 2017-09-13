## Introduction to Spring MVC
### Table of Contents
#### Chapter 1 - [Introduction to Spring/SpringMVC](01-IntroSpringMVC/README.md)
* [Spring MVC Overview](01-IntroSpringMVC/mvc_overview.md)
  * [What is Spring?](01-IntroSpringMVC/mvc_overview.md)
  * [What is Spring MVC?](01-IntroSpringMVC/what_is_spring_mvc.md)
  * [Components of a Spring MVC Application](01-IntroSpringMVC/components_of_spring_mvc.md)
    * [File Structure](01-IntroSpringMVC/file_structure.md)
    * [Dependencies](01-IntroSpringMVC/dependencies.md)
    * [*web.xml*](01-IntroSpringMVC/webxml.md)
    * [*dispatcher-servlet.xml*](01-IntroSpringMVC/servletxml.md)
    * [`@Controller`](01-IntroSpringMVC/controller.md)

  * [13 Steps to building a SpringMVC web application in Eclipse](01-IntroSpringMVC/13_steps.md)

#### Chapter 2 - [Handling Requests](02-HandlingRequests/README.md)
* [Handling Requests with `@Controller`](02-HandlingRequests/controller.md)
* [Pathing with `@RequestMapping`](02-HandlingRequests/mapping.md)
* [Receiving Data with `@RequestParam`](02-HandlingRequests/params.md)
* [Controller Method Return Types](02-HandlingRequests/return_type.md)
* [View Resolvers](02-HandlingRequests/views.md)
* [Command Objects](02-HandlingRequests/command.md)
* [Preventing Duplicate Posts](02-HandlingRequests/post_redirect_get.md)
* [Unit Testing](02-HandlingRequests/unittesting.md)
* [States Lab](02-HandlingRequests/states_lab.md)

#### Chapter 3 - [Spring Application Contexts and Beans](03-ContextsAndObjects/README.md)
* [ApplicationContexts](03-ContextsAndObjects/applicationcontexts.md)
* [Root and Servlet Contexts](03-ContextsAndObjects/webappcontext.md)
* [Using `@Component` to Discover Beans](03-ContextsAndObjects/component.md)
* [_Singleton_ Beans](03-ContextsAndObjects/singleton.md)
* [`@ModelAttribute`](03-ContextsAndObjects/modelattribute.md)
* [States Lab - Root and Servlet Contexts](03-ContextsAndObjects/states_lab_2.md)

#### Chapter 4 - [Sessions](04-Sessions/README.md)
* [Storing an Object in the Session](04-Sessions/store_object.md)
* [Storing an Object in the Session the Spring MVC Way](04-Sessions/spring_session.md)
* [Unit Testing Session Attributes](04-Sessions/unittestsession.md)
* [States Lab 3](04-Sessions/states_lab_3.md)

#### Chapter 5 - [Validation](05-Validation/README.md)
* [Setup](05-Validation/setup.md)
* [Validation Annotations](05-Validation/annotations.md)
* [Using Validation Information in the Controller](05-Validation/controller.md)
* [Validation using Spring's `Validator` Interface](05-Validation/validator.md)
* [Using the `Validator` Interface in the Controller](05-Validation/controller_validator.md)
* [Adding Validation to Forms](05-Validation/forms.md)
* [Improving Feedback with Custom Messages](05-Validation/custom_messages.md)
* [Using a Properties File to Store Errors](05-Validation/properties.md)
* [Unit Testing Validation](05-Validation/unittestingvalidation.md)
* [Validation Lab](05-Validation/validation_lab.md)

#### Project
* [SpringMVC C.R.U.D. Project](mvc_crud_project.md)

### Index
* [`@Controller`](01-IntroSpringMVC/controller.md)
* [`@RequestMapping`](02-HandlingRequests/mapping.md)
* [`@RequestParam`](02-HandlingRequests/params.md)
* [`ModelAndView`](02-HandlingRequests/return_type.md)
* [`@ModelAttribute`](03-ContextsAndObjects/modelattribute.md)
* [`dispatcher-servlet.xml`](01-IntroSpringMVC/servletxml.md)
  * [Reusable stub](dispatcher-servlet.xml)
* [`web.xml`](01-IntroSpringMVC/webxml.md)
  * [Reusable stub](web.xml)
* [`Root and Servlet Contexts`](03-ContextsAndObjects/webappcontext.md)
  * [web.xml - reusable stub](web_xml_multiple_context.xml)
  * [app-context.xml](app-context.xml)
  * [servlet-context.xml](servlet-context.xml)