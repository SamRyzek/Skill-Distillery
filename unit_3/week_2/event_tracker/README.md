# Event Tracker

### Overview
This project is as much about using JSON and SpringREST as it is handling JSON responses with JavaScript. As a result, don't get to caught up on the functionality of your final project, make sure that everything is configured correctly and working then slowly scale up to more complexity.  

'Event Tracker' is a broad term for anything that keeps track of information over time. Examples of these applications are 'Mint' (financial tracking) and 'MyFitnessPal' (diet and exercise tracker). These are very involved applications with a huge feature set. You are embarking on a weekend project that you may or may not come back to afterwards, thus we would caution you to limit your scope significantly. Examples of limited scope would be 'Gas Tracker' (keep track of your fill ups and total mileage to determine dollar/gallon in your car) or 'Timesheet' (track time in and time out to calculate total hours at some rate of pay).  

### Learning Objectives
* Configure a full stack SpringREST app
  * model a simple Java object and store it in a single table database
  * use restful annotations
* Send / receive JSON  
* Parse JSON response with JavaScript  
* Build HTML (using JSON) with jQuery  
* Send asynchronous request to Java controller with jQuery's AJAX  

### Where to start?
1. Create a new JPA project  (don't forget to make it a Gradle project)
  * configure persistence.xml, and log4j  
  * create mysql database and table for your object
2. Create a new 'Dynamic Web Project' (don't forget to make it a Gradle project)
  * include Jackson and Spring dependencies
  * configure the web.xml, and Dispatcher-servlet.xml
  * test that everything works (see if you can generate a JSON response synchronously)
3. Build up a REST API with routes for Create/Read/Update/Delete database interactions.  
  * Test these routes using Postman  
4. Add JavaScript functionality
  * Add AJAX requests, and print the response to console
5. Manipulate the DOM
  * instead of just printing to console, update your HTML with values from the JSON response. (i.e. display the content on the page)
6. Add functionality
  * once your presentation for your get is working, add a function that uses the response data to present the data in some other form (For instance, total all of the hours you worked and calculate the amount of money you are owed. This would involve retrieving all of the "PunchCard" records, totaling their values, and displaying the total multiplied times your hourly rate somewhere on the page.)  

### Goal
Your objective for this project should be to do as much as you can. That is not to say as many features, but as much as you actually understand. Do not move onto the next step until you actually know what you just did and feel comfortable with what is happening. If you reach a point and are confused about what you are doing, or what you have done, ask questions, look for resources, or start over on that piece to ensure that you are comfortable with it. For some of you DOM manipulation will be tricky to conceptualize, others will struggle with AJAX and the nature of asynchrony, and some will have a hard time conceptualizing JSON as a representation of objects and feel uncomfortable routing with it. All of these difficulties are understandable and the reason we are doing this project is to struggle through them.  

#### Grading
This is a graded project.  You are expected to have your project completed by noon on Monday.  

You will be given either a pass or fail based on whether your code works given all of the following test conditions:

* A new event object implements full CRUD.  
* All interactions with the database are done so RESTfully.  
* App uses jQuery to access data and manipulate the DOM.  
* App presents the aggregated data in some additional format.  

If the project does work with all of the above test conditions, you will be given a *1* for this week's project.

If the project does not work with the above test conditions, you will be given a *0* for this week's project.

If you get a zero on the project, you can upgrade to a score of *.5* if you turn in a working project by the start of class the following Monday morning AND notify an instructor that you wish to get partial credit.

To turn in a project, you must push it to GitHub.  You must also deploy it to your AWS server (we will show you how to do that Monday morning).  You must include a README.md that describes your program and how to access it on AWS.


### Example Application
* [Spearmint][spearmint]

[spearmint]: http://52.25.225.137:8080/Spearmint/
