# Event Tracker

### Overview
'Event Tracker' is a broad term for anything that keeps track of information over time. Examples of these applications are 'Mint' (financial tracking) and 'MyFitnessPal' (diet and exercise tracker). These are very involved applications with a huge feature set. You are embarking on a weekend project that you may or may not come back to afterwards, thus we would caution you to limit your scope significantly. Examples of limited scope would be 'Gas Tracker' (keep track of your fill ups and total mileage to determine dollar/gallon in your car) or 'Timesheet' (track time in and time out to calculate total hours at some rate of pay).  

### Learning Objectives
* Configure a SpringREST app
  * model a simple Java object and store it in a single table database
  * map your POJO using JPA
  * use restful annotations
* Send / receive JSON  

### Where to start?
1. Create a single table database to store your event.
2. Create a new JPA project
  * add gradle nature to the project and configure the build.gradle file
  * configure persistence.xml, and log4j  
  * create an entity that maps the sql table you created in step 1
3. Create a new 'Dynamic Web Project'
  * add gradle nature to the project and configure the build.gradle and settings.gradle file
  * include Jackson and Spring dependencies
  * configure the web.xml, and dispatcher-servlet.xml
  * test that everything works
4. Build up a REST API with routes for Create/Read/Update/Delete database interactions.  
  * Test these routes using Postman  


### Goal
Your objective for this project should be to do as much as you can. That is not to say as many features, but as much as you actually understand. Do not move onto the next step until you actually know what you just did and feel comfortable with what is happening. If you reach a point and are confused about what you are doing, or what you have done, ask questions, look for resources, or start over on that piece to ensure that you are comfortable with it.  

#### Grading
This is a graded project.  You are expected to have your project completed by noon on Monday.  

You will be given either a pass or fail based on whether your code works given all of the following test conditions:

* A new event object implements full CRUD.  
* All interactions with the database are done so RESTfully.  

If the project does work with all of the above test conditions, you will be given a *1* for this week's project.

If the project does not work with the above test conditions, you will be given a *0* for this week's project.

If you get a zero on the project, you can upgrade to a score of *.5* if you turn in a working project by the start of class the following Monday morning AND notify an instructor that you wish to get partial credit.

To turn in a project, you must push it to GitHub.  You must also deploy it to your AWS server. You must include a README.md that describes your program and how to access it on AWS.
